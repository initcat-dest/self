package com.base.self.design.deciratuin.coffee;

import com.base.self.design.deciratuin.Beverage;

/**
 * class description 浓缩咖啡对象
 *
 * @author libo
 * @package com.base.self.design.deciratuin
 * @company initcat
 * @date 2019/11/7
 */
public class Espresso extends Beverage {

    public Espresso() {
        super.description = "Espresso Coffee";
    }

    @Override
    public double cost() {
        return 1.99D;
    }

}
