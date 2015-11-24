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
        // longs.someNegativeNumber() may produce 0 so subtract 1 to make sure the time is in the past.
        setTime(getTime() + (longs.someNegativeNumber() - 1));
        return this;
    }

    RandomTimeBuilder inTheFuture() {
        // longs.somePositiveNumber() may produce 0 so add 1 to make sure the time is in the future.
        setTime(getTime() + (longs.somePositiveNumber() + 1));
        return this;
    }

    public RandomTimeBuilder minusHours(int hours) {
        setTime(calendars.create(getTime()).minusHours(hours).getTime());
        return this;
    }

    public RandomTimeBuilder addHours(int hours) {
        setTime(calendars.create(getTime()).addHours(hours).getTime());
        return this;
    }

    public RandomTimeBuilder minusDays(int days) {
        setTime(calendars.create(getTime()).minusDays(days).getTime());
        return this;
    }

    public RandomTimeBuilder addDays(int days) {
        setTime(calendars.create(getTime()).addDays(days).getTime());
        return this;
    }

    public RandomTimeBuilder minusWeeks(int weeks) {
        setTime(calendars.create(getTime()).minusWeeks(weeks).getTime());
        return this;
    }

    public RandomTimeBuilder addWeeks(int weeks) {
        setTime(calendars.create(getTime()).addWeeks(weeks).getTime());
        return this;
    }

    public RandomTimeBuilder minusMonths(int months) {
        setTime(calendars.create(getTime()).minusMonths(months).getTime());
        return this;
    }

    public RandomTimeBuilder addMonths(int months) {
        setTime(calendars.create(getTime()).addMonths(months).getTime());
        return this;
    }

    public RandomTimeBuilder minusYears(int years) {
        setTime(calendars.create(getTime()).minusYears(years).getTime());
        return this;
    }

    public RandomTimeBuilder addYears(int years) {
        setTime(calendars.create(getTime()).addYears(years).getTime());
        return this;
    }
}
