package com.lwt.testgit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by liu.wentao on 2021-03-11 19:32
 */

public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    private static final String defaultDateformat = "yyyyMMdd";
    private static final DateTimeFormatter defaultFormatter = DateTimeFormatter.ofPattern(defaultDateformat);

    /**
     * 当前unixtime
     */
    public static int unixtime() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /**
     * 当天0点的unixtime
     */
    public static int todayStart() {
        return (int) LocalDateTime.now().withHour(0).truncatedTo(ChronoUnit.HOURS).atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }


    /**
     * 明日0点
     *
     * @return
     */
    public static int tomorrorStart() {
        return todayStart() + 86400;
    }

    /**
     * 指定时间当天的0点unixtime
     */
    public static int getDayStart(int unixtime) {
        return (int) Instant.ofEpochSecond(unixtime).atZone(ZoneId.systemDefault()).withHour(0).withMinute(0).withSecond(0).toInstant().getEpochSecond();
    }

    /**
     * 指定时间当天的0点unixtime
     */
    public static int getDayStartByAge(int age) {
        return (int) Instant.ofEpochSecond(unixtime()).atZone(ZoneId.systemDefault()).withHour(0).withMinute(0).withSecond(0).minusYears(age).toInstant().getEpochSecond();
    }

    /**
     * 获取当天的日期字符串，默认格式："yyyyMMdd"
     */
    public static String getTodayString() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(defaultDateformat);
        return date.format(formatter);
    }
}
