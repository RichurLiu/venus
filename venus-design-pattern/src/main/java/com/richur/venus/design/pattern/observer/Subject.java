package com.richur.venus.design.pattern.observer;

/**
 * @author richur
 */
public interface Subject {
    /**
     *
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     *
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     *
     * @param message
     */
    void notifyObservers(String message);
}
