package shiver.me.timbers.data.random;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Karl Bennett
 */
class CalendarDays implements Days {

    @Override
    public Date yesterday() {
        Calendar yesterday = midnight();
        yesterday.add(Calendar.DAY_OF_MONTH, -1);

        return yesterday.getTime();
    }

    @Override
    public Date today() {
        return midnight().getTime();
    }

    @Override
    public Date tomorrow() {
        Calendar tomorrow = midnight();
        tomorrow.add(Calendar.DAY_OF_MONTH, 1);

        return tomorrow.getTime();
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
