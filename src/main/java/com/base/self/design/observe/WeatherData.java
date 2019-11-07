package com.base.self.design.observe;

import java.util.ArrayList;

/**
 * class description 天气信息
 *
 * @author libo
 * @package com.base.self.design.observe
 * @company initcat
 * @date 2019/11/7
 */
public class WeatherData implements Subject {

    private ArrayList<Observer> observers;
    private float temperature;
    private float himidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    /**
     * 注册观察者。
     */
    @Override
    public void registerObserver(Observer ob) {
        observers.add(ob);
    }

    /**
     * 移除观察者。
     */
    @Override
    public void removeObserver(Observer ob) {
        int index = observers.indexOf(ob);
        if (index >= 0) {
            observers.remove(index);
        }
    }

    /**
     * 当有最新的气象监测数据时被调用。↓下面的函数调用。
     */
    @Override
    public void notifyObservers() {
        for (Observer ob : observers) {
            ob.update(this.temperature, this.himidity, this.pressure);
        }
    }

    /**
     * 气象站硬件监测到新数据会调用该方法。↓下面的函数调用。
     */
    public void measurementsChanged() {
        notifyObservers();
    }

    /**
     * 因为没有气象站，所以模拟一个硬件，获得气象数据调用measurementsChanged()方法。
     * 在main()函数中使用。
     */
    public void setMeasurements(float temperature, float himidity, float pressure) {
        this.temperature = temperature;
        this.himidity = himidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHimidity() {
        return himidity;
    }

    public void setHimidity(float himidity) {
        this.himidity = himidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

}
