package za.co.jobcreation.ejb;

import org.junit.Ignore;

import java.util.Calendar;
import java.util.Date;

/**
 * @author khumbu
 */
@Ignore
public class TestConstants {

    // Dates

    public static final Date DATE_NOW = toDate(2013, 04, 06, 13, 48, 12, 000);
    public static final Date DATE_NOW_PLUS_1 = toDate(2013, 04, 07, 13, 48, 12, 000);

    // Other
    public static final String userName = "Peter Pan";
    public static final String password = "Wendy01";
    public static final boolean userActiveTrue = Boolean.TRUE;

    private static Date toDate(int year, int month, int date, int hourOfDay, int minute,
                               int second, int milliSeconds) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, date, hourOfDay, minute, second);
        cal.set(Calendar.MILLISECOND, milliSeconds);
        return cal.getTime();
    }


}
