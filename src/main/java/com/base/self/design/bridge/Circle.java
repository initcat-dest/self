package com.base.self.design.bridge;

/**
 * class description 圆
 *
 * @author libo
 * @package com.base.self.design.bridge
 * @company initcat
 * @date 2020/5/8
 */
public class Circle extends Shape {

    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
