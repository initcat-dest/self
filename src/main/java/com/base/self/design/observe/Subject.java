package com.base.self.design.observe;

/**
 * interface description 主题接口
 *
 * @author libo
 * @package com.base.self.design.observe
 * @company initcat
 * @date 2019/11/7
 */
public interface Subject {

    /**
     * registerObserver和removeObserver方法都需要一个观察者作为变量，该观察者是用来注册或被删除的。
     */
    void registerObserver(Observer ob);

    void removeObserver(Observer ob);

    /**
     * 当主题的状态改变时，这个方法会被调用，已通知所有的观察者。
     */
    void notifyObservers();

}