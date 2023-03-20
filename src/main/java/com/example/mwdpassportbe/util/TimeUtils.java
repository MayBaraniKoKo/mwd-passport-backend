package com.example.mwdpassportbe.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Slf4j
public class TimeUtils {
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp plusCurrentTimestamp(long amountDays) {
        Timestamp newTimestamp = Timestamp.from(getCurrentTimestamp().toInstant().plus(amountDays, ChronoUnit.DAYS));
        return newTimestamp;
    }

    public static boolean isEqualDate(Date date1, Date date2) {
        return date1.compareTo(date2) == 0;
    }

    public static boolean isEqualDateByTwoTimestamp(Timestamp timestamp1, Timestamp timestamp2) {
        long longTimestamp1 = timestamp1.getTime();
        long longTimestamp2 = timestamp2.getTime();

        String date1 = new SimpleDateFormat("yyy-MM-dd").format(new Date(longTimestamp1));
        String date2 = new SimpleDateFormat("yyy-MM-dd").format(new Date(longTimestamp2));

        return date1.equals(date2);
    }


    public static boolean timestamp1GreaterThanTimestamp2ByDate(Timestamp timestamp1, Timestamp timestamp2) {
        long longTimestamp1 = timestamp1.getTime();
        long longTimestamp2 = timestamp2.getTime();

        String date1Str = new SimpleDateFormat("yyy-MM-dd").format(new Date(longTimestamp1));
        String date2Str = new SimpleDateFormat("yyy-MM-dd").format(new Date(longTimestamp2));

        Date date1 = null;
        Date date2 = null;
        try {
            date1 = new SimpleDateFormat("yyy-MM-dd").parse(date1Str);
            date2 = new SimpleDateFormat("yyy-MM-dd").parse(date2Str);

        } catch (ParseException e) {
            log.error("Error convert string to date: {}", e.getMessage());
        }
        if(date1 == null || date2 == null){
            return false;
        }
        return date1.after(date2);
    }

    public static LocalDate getDateNow() {
        return LocalDate.now();
    }

    public static java.sql.Date getNextDate() {
        return java.sql.Date.valueOf(TimeUtils.getDateNow().plusDays(1L));
    }

    public static java.sql.Date getSub3DaysFromDateNow() {
        return java.sql.Date.valueOf(TimeUtils.getDateNow().plusDays(-3L));
    }

    public static java.sql.Date getPlus40DaysFromDateNow() {
        return java.sql.Date.valueOf(TimeUtils.getDateNow().plusDays(40L));
    }

    public static int getWeekNowOfYear() {
        LocalDate date = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.GERMANY);
        return date.get(weekFields.weekOfWeekBasedYear()) + 1;
    }

    public static int getLastWeekOfYear() {
        LocalDate date = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.GERMANY);
        return date.get(weekFields.weekOfWeekBasedYear());
    }

    public static int getNextWeekOfYear() {
        LocalDate date = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.GERMANY);
        return date.get(weekFields.weekOfWeekBasedYear()) + 2;
    }

    public static int getMonthNowOfYear() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        return month;
    }

    public static int getLastMonthOfYear() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        return month;
    }

    public static int getNextMonthOfYear() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        return month + 1;
    }

    public static java.sql.Date getPlus10DaysFromDateNow() {
        return java.sql.Date.valueOf(TimeUtils.getDateNow().plusDays(10L));
    }

    public static java.sql.Date getYesterday() {
        return java.sql.Date.valueOf(TimeUtils.getDateNow().plusDays(-1L));
    }

    public static String timeCode() {
        return (Calendar.getInstance().get(Calendar.MONTH) + 1) + "_" + (Calendar.getInstance().get(Calendar.YEAR));
    }

    public static String convertDateToString(java.sql.Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public static String timeWeekCode() {
        return getWeekNowOfYear() + "_" + (Calendar.getInstance().get(Calendar.YEAR));
    }

    public static String timeLastWeekCode() {
        return (getWeekNowOfYear() - 1) + "_" + (Calendar.getInstance().get(Calendar.YEAR));
    }
}