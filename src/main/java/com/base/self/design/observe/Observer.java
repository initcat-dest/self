package com.base.self.design.observe;

/**
 * interface description 观察者接口
 *
 * @author libo
 * @package com.base.self.design.observe
 * @company initcat
 * @date 2019/11/7
 */
public interface Observer {

    /**
     * 当气象监测数据改变时，主题会把这些状态值当作方法的参数，传送给观察者。
     */
    void update(float temp, float humidity, float perssure);

}