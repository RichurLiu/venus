package com.richur.venus.design.pattern.observer;

/**
 * @author richur
 */
public class RichurObserverOne implements Observer{
    @Override
    public void update(String message) {
        System.out.println("RichurObserverOne:" + message);
    }
}
