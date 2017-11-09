package com.xhlim.comparison.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.xhlim.comparison.entity.SerializableEntity;
import org.objenesis.strategy.StdInstantiatorStrategy;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

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

        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(b);
    }

    /**
     * 反序列化
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String json, Class<T> clazz) throws IOException {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.register(clazz, new JavaSerializer());

        BASE64Decoder decoder = new BASE64Decoder();

        ByteArrayInputStream bais = new ByteArrayInputStream(decoder.decodeBuffer(json));
        Input input = new Input(bais);
        return kryo.readObject(input, clazz);
    }

    public static void main(String[] args) throws IOException {
        SerializableEntity entity = new SerializableEntity();
        entity.setB(new Byte("1"));
        String json = KryoSerializable.serialize(entity);
        System.out.println(json);
        SerializableEntity serializableEntity = KryoSerializable.deserialize(json, SerializableEntity.class);
        System.out.println(serializableEntity);
    }

}
