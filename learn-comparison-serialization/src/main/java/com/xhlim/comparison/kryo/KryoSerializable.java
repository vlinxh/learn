package com.xhlim.comparison.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import com.xhlim.comparison.entity.SerializableEntity;
import org.objenesis.strategy.StdInstantiatorStrategy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by xhlim on 2017/7/6.
 */
public class KryoSerializable {

    /**
     * 序列化
     *
     * @param obj
     * @return
     */
    public static String serialize(Object obj) {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(false);

        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
        kryo.register(obj.getClass(), new JavaSerializer());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output output = new Output(baos);
        kryo.writeClassAndObject(output, obj);
        output.flush();
        output.close();

        byte[] b = baos.toByteArray();
        try {
            baos.flush();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return com.sun.org.apache.xml.internal.security.utils.Base64.encode(b);
    }

    /**
     * 反序列化
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String json, Class<T> clazz) throws Base64DecodingException {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.register(clazz, new JavaSerializer());

        ByteArrayInputStream bais = new ByteArrayInputStream(Base64.decode(json));
        Input input = new Input(bais);
        return kryo.readObject(input, clazz);
    }

    public static void main(String[] args) throws Base64DecodingException {
        SerializableEntity entity = new SerializableEntity();
        entity.setB(new Byte("1"));
        String json = KryoSerializable.serialize(entity);
        System.out.println(json);
        SerializableEntity serializableEntity = KryoSerializable.deserialize(json, SerializableEntity.class);
        System.out.println(serializableEntity);
    }

}
