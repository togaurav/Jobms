package com.framework.core.querybuilder.hql.model.query.converter;

/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:00:42 PM
 */
public class ConversionException extends RuntimeException {

    /**
     * @param message
     */
    public ConversionException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public ConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public ConversionException(Throwable cause) {
        super(cause);
    }
    
}
