package com.xhlim.springboot.entity.id;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;
import java.util.UUID;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-08 17:02
 */
public class UUIDGenerator implements IdentifierGenerator, Configurable {

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {

    }

    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        String id = UUID.randomUUID().toString().replace("-", "");
        return id;
    }
}
