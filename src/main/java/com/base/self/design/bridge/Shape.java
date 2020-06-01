package com.base.self.design.bridge;

/**
 * class description 形状
 *
 * @author libo
 * @package com.base.self.design.bridge
 * @company initcat
 * @date 2020/5/8
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();

}
