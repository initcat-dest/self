package com.base.self;

import com.base.self.spi.Robot;
import org.junit.Test;

import java.util.ServiceLoader;


/**
 * class description TODO
 *
 * @author libo
 * @package com.base.self.spi
 * @company initcat
 * @date 2020/4/7
 */
public class JavaSPITest {
    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
