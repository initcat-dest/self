package com.base.self.design.observe;

/**
 * class description 调用
 *
 * @author libo
 * @package com.base.self.design.observe
 * @company initcat
 * @date 2019/11/8
 */
public class Client {

    /**
     * output:
     * 当前conditions:80.0F degrees and 65.0% humidity
     * 当前conditions:80.0F degrees and 65.0% humidity
     */
    public static void main(String[] args) {
        // 首先，创建一个主题。
        // 这里应该使用Subject weatherData = new WeatherData();来创建主题。
        // 但是我们在WeatherData中添加了一个模拟硬件发送气象数据的函数，Subject中并没有这个函数。
        // 所以使用了WeatherData来创建主题。
        WeatherData weatherData = new WeatherData();
        // 建立一个观察者（也就是布告板），把主题传给观察者，在观察者的构造函数中订阅主题。
        Observer ccDisplay = new CurrentConditionsDisplay(weatherData);

        // 模拟一个气象变化的情况。
        weatherData.setMeasurements(80, 65, 30.4f);

        // 又变化了！
        weatherData.setMeasurements(80, 65, 30.4f);


    }

}
