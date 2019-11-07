package com.base.self.design.deciratuin.coffee;


import com.base.self.design.deciratuin.Beverage;

/**
 * class description 深焙咖啡对象
 *
 * @author libo
 * @package com.base.self.design.deciratuin
 * @company initcat
 * @date 2019/11/7
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        super.description = "DarkRoast Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }

}
