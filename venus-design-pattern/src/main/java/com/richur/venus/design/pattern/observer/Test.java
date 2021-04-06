package com.richur.venus.design.pattern.observer;

/**
 * @author richur
 */
public class Test {
    public static void main(String[] args) {
        RichurSubject richurSubject = new RichurSubject();
        RichurObserverOne richurObserverOne = new RichurObserverOne();
        RichurObserverTwo richurObserverTwo = new RichurObserverTwo();
        richurSubject.registerObserver(richurObserverOne);
        richurSubject.registerObserver(richurObserverTwo);
        richurSubject.notifyObservers("success");
        richurSubject.removeObserver(richurObserverOne);
        richurSubject.notifyObservers("failed");
    }
}
