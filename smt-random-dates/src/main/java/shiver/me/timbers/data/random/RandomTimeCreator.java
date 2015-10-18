package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface RandomTimeCreator<D extends Date> {

    D create(Date date);

    D random();

    D thisWeek();

    D thisWeekOn(WeekDay weekDay);

    D today();

    D between(Date min, Date max);

    D now();
}
