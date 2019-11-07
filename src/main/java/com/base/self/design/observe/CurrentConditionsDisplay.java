package com.base.self.design.observe;

/**
 * class description 布告板
 *
 * @author libo
 * @package com.base.self.design.observe
 * @company initcat
 * @date 2019/11/8
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float himidity;
    /**
     * 要观察的主题
     */
    private Subject weatherData;


    public CurrentConditionsDisplay() {
    }

    public CurrentConditionsDisplay(Subject weatherData) {
        // 实例化布告板的时候，传入一个主题，将自己注册到主题中。
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前conditions:" + temperature + "F degrees and "
                + himidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float perssure) {
        this.temperature = temp;
        this.himidity = humidity;
        // 更新数据后刷新布告板。
        display();
    }


}
