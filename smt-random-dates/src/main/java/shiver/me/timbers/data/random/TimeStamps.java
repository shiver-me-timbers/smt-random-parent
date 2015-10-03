package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface TimeStamps {

    Date date(long date);

    long now();

    long yesterdayMidnight();

    long todayMidnight();

    long tomorrowMidnight();
}
