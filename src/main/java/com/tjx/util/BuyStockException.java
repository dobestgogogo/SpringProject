package com.tjx.util;

public class BuyStockException extends RuntimeException {

    public BuyStockException(String message) {
        super(message);
    }

    public BuyStockException(String message, Throwable cause) {
        super(message, cause);
    }
}
