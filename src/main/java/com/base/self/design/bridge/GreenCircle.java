package com.base.self.design.bridge;

/**
 * class description 绿圆
 *
 * @author libo
 * @package com.base.self.design.bridge
 * @company initcat
 * @date 2020/5/8
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}