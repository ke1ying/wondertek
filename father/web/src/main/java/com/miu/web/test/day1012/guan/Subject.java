package com.miu.web.test.day1012.guan;


/**
 * @author keying
 * @date 2022-10-12 14:03:12
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}