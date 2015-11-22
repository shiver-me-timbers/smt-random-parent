package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
public class RandomTimeBuilder extends Date {

    private final Calendars calendars;
    private final Numbers<Long> longs;

    RandomTimeBuilder(Calendars calendars, Numbers<Long> longs, long time) {
        super(time);
        this.calendars = calendars;
        this.longs = longs;
    }

    RandomTimeBuilder inThePast() {
        setTime(getTime() + (longs.someNegativeNumber() - 1));
        return this;
    }

    RandomTimeBuilder inTheFuture() {
        setTime(getTime() + (longs.somePositiveNumber() + 1));
        return this;
    }

    public RandomTimeBuilder minusDays(int days) {
        setTime(calendars.create(getTime()).minusDays(days).toTime());
        return this;
    }

    public RandomTimeBuilder addDays(int days) {
        setTime(calendars.create(getTime()).addDays(days).toTime());
        return this;
    }

    public RandomTimeBuilder minusWeeks(int weeks) {
        setTime(calendars.create(getTime()).minusWeeks(weeks).toTime());
        return this;
    }

    public RandomTimeBuilder addWeeks(int weeks) {
        setTime(calendars.create(getTime()).addWeeks(weeks).toTime());
        return this;
    }

    public RandomTimeBuilder minusMonths(int months) {
        setTime(calendars.create(getTime()).minusMonths(months).toTime());
        return this;
    }

    public RandomTimeBuilder addMonths(int months) {
        setTime(calendars.create(getTime()).addMonths(months).toTime());
        return this;
    }

    public RandomTimeBuilder minusYears(int years) {
        setTime(calendars.create(getTime()).minusYears(years).toTime());
        return this;
    }

    public RandomTimeBuilder addYears(int years) {
        setTime(calendars.create(getTime()).addYears(years).toTime());
        return this;
    }

}
