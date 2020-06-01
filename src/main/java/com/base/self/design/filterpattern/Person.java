package com.base.self.design.filterpattern;

import lombok.Builder;
import lombok.Data;

/**
 * class description 需要过滤的对象
 *
 * @author libo
 * @package com.base.self.design.filterpattern
 * @company initcat
 * @date 2020/5/7
 */
@Data
@Builder
public class Person {
    private String name;
    private String gender;
    private String maritalStatus;
}
