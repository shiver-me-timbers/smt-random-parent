package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface Dates {

    Date someDate();

    Date somePastDate();

    Date someFutureDate();

    Date someDateBefore(Date date);

    Date someDateAfter(Date date);

    Date someDateBetween(Date min, Date max);

    Date someDateYesterday();

    Date someDateToday();

    Date someDateTomorrow();
}
