package com.base.self.io;

import lombok.Builder;
import lombok.Data;

/**
 * class description
 *
 * @author libo
 * @package com.base.self.io
 * @company initcat
 * @date 2019/2/25
 */
@Data
@Builder
public class InsuraceExcelBean {
    private String insuraceUser;
    private String bankCardId;
    private String idCard;
    private String buyTime;
    private String insEndTime;
    private String insStartTime;
    private String money;
    private String type;
}
