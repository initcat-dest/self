package com.base.self.design.deciratuin;

import com.base.self.design.deciratuin.coffee.DarkRoast;
import com.base.self.design.deciratuin.coffee.Espresso;
import com.base.self.design.deciratuin.flavour.Mocha;
import com.base.self.design.deciratuin.flavour.Whip;

/**
 * class description 执行
 *
 * @author libo
 * @package com.base.self.design.deciratuin
 * @company initcat
 * @date 2019/11/7
 */
public class Client {

    /**
     * output:
     * Espresso Coffee $1.99
     * DarkRoast Coffee, Mocha, Mocha, Whip $1.49
     */
    public static void main(String[] args) {
        // 订一杯浓缩咖啡，不需要调料，打印价格。
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        // 订一杯深焙咖啡，加入双倍的Mocha，在加入奶泡。
        // 因为调料与饮料都是扩展自Beverage，所以可以使用下面的等式。
        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
