package com.base.self.design.deciratuin.flavour;

import com.base.self.design.deciratuin.Beverage;

/**
 * class description 调料对象
 *
 * @author libo
 * @package com.base.self.design.deciratuin
 * @company initcat
 * @date 2019/11/7
 */
public abstract class CondimentDecorator extends Beverage {

    /**
     * 饮料描述
     *
     * @return String
     */
    @Override
    public abstract String getDescription();

}