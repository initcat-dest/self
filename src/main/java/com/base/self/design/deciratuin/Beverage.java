package com.base.self.design.deciratuin;

/**
 * class description 饮料的基类
 *
 * @author libo
 * @package com.base.self.design.deciratuin
 * @company initcat
 * @date 2019/11/7
 */
public abstract class Beverage {
    /**
     * 饮料的说明
     */
    public String description = "Unknow Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
