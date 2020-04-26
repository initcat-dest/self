package com.base.self.times;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * 时间
 *
 * @author libo
 * @package com.base.self.times
 * @company initcat
 * @date 2019/6/20
 */
public class Times {

    public static void main(String[] args) throws ParseException {
        Date date = DateUtils.parseDate("12:00:00", "HH:mm:ss");
        System.out.println(date);
    }

}
