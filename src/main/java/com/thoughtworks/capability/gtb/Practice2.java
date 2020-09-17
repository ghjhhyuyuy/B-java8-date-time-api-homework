package com.thoughtworks.capability.gtb;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对任意日期获取下一个工作日, 不考虑节假日
 *
 * @author itutry
 * @create 2020-05-15_17:20
 */
public class Practice2 {

  public static LocalDate getNextWorkDate(LocalDate date) {
    DayOfWeek dayOfWeek = date.getDayOfWeek();
    String[] workDayIsNextDay = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","SUNDAY"};
    List<String> dayString = Arrays.stream(workDayIsNextDay).filter(day -> day.equals(dayOfWeek.name())).collect(Collectors.toList());
    if(dayString.size() != 0){
      return date.plusDays(1);
    }
    if(dayOfWeek.name().equals("FRIDAY")){
      return date.plusDays(3);
    }
    return date.plusWeeks(2);
  }
}
