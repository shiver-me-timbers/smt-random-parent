package shiver.me.timbers.data.random;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Karl Bennett
 */
class UtilDateFactory implements DateFactory {

    @Override
    public Date date(long date) {
        return new Date(date);
    }

    @Override
    public long nowTime() {
        return new Date().getTime();
    }

    @Override
    public long yesterdayMidnightTime() {

        Calendar yesterday = midnight();
        yesterday.add(Calendar.DAY_OF_MONTH, -1);

        return yesterday.getTime().getTime();
    }

    @Override
    public long todayMidnight() {
        return midnight().getTime().getTime();
    }

    @Override
    public long tomorrowMidnightTime() {

        Calendar tomorrow = midnight();
        tomorrow.add(Calendar.DAY_OF_MONTH, 1);

        return tomorrow.getTime().getTime();
    }

    private Calendar midnight() {

        Calendar midnight = new GregorianCalendar();
        midnight.set(Calendar.HOUR_OF_DAY, 0);
        midnight.set(Calendar.MINUTE, 0);
        midnight.set(Calendar.SECOND, 0);
        midnight.set(Calendar.MILLISECOND, 0);

        return midnight;
    }
}
