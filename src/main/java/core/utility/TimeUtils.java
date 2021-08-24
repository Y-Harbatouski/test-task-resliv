package core.utility;

import core.testbase.TestListener;
import org.testng.log4testng.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeUtils {
    private static final Logger log = Logger.getLogger(TestListener.class);
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String getDateToday() {
        Date dateNow = new Date();
        log.info(String.format("Значение сегодняшней даты: %s", dateFormat.format(dateNow)));

        return dateFormat.format(dateNow);
    }

    public static String convertToDateFormatResultsPage(String date) {
        DateFormat newDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String month = newDateFormat.format(calendar.getTime()).replaceAll("[ \\d]", "").substring(0, 3);

        return newDateFormat.format(calendar.getTime()).replaceAll("[^\\w ]+", month);
    }


    public static String addDaysToDateNow(int addDays) {
        String myDate = getDateToday();
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(myDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.add(Calendar.DATE, addDays);  // number of days to add
        myDate = dateFormat.format(calendar.getTime());  // is now the new date
        log.info(String.format("Получаю значение даты: %s", myDate));

        return myDate;
    }

}
