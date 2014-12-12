package com.wrongkey.pos.model;

/**
 * Created by Administrator on 2014/12/9.
 */
public class ItemAddtionException extends RuntimeException {
    private static final long serialVersionUID = 123456789L;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ItemAddtionException(String message) {
        super(message);
    }
}
