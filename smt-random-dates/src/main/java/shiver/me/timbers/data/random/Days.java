package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface Days {

    Date yesterday();

    Date today();

    Date tomorrow();

    Date mondayLastWeek();

    Date mondayThisWeek();

    Date mondayNextWeek();
}
