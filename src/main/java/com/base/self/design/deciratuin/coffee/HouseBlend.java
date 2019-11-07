package com.base.self.design.deciratuin.coffee;

import com.base.self.design.deciratuin.Beverage;

/**
 * class description 黑咖啡对象
 *
 * @author libo
 * @package com.base.self.design.deciratuin
 * @company initcat
 * @date 2019/11/7
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        super.description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }

}
