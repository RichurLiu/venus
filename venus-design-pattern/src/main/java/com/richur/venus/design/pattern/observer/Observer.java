package com.richur.venus.design.pattern.observer;

/**
 * @author richur
 */
public interface Observer {
    default void update(String message) {
        System.out.println("update...");
    }
}
