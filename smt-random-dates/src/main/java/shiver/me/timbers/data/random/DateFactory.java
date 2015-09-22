package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface DateFactory {

    Date date(long date);

    long nowTime();

    long yesterdayMidnightTime();

    long todayMidnight();

    long tomorrowMidnightTime();
}
