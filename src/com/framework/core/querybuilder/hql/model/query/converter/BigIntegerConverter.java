package com.framework.core.querybuilder.hql.model.query.converter;

import java.math.BigInteger;


/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:00:34 PM
 */
public class BigIntegerConverter implements Converter {

    public Object convert(Class type, String value) throws ConversionException {
        return new BigInteger(value);
    }

}

