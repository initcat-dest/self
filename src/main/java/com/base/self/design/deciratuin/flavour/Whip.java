package com.base.self.design.deciratuin.flavour;

import com.base.self.design.deciratuin.Beverage;

/**
 * class description 奶泡调料
 *
 * @author libo
 * @package com.base.self.design.deciratuin
 * @company initcat
 * @date 2019/11/7
 */
public class Whip extends CondimentDecorator {

    /**
     * 需要装饰的类
     */
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
