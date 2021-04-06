package com.richur.venus.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author richur
 */
public class RichurSubject implements Subject {
    private static final long serialVersionUID = 5803633158553347658L;

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observerList) {
            System.out.println(observer.getClass().getName());
            observer.update(message);
        }
    }
}
