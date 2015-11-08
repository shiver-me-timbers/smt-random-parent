package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
public class RandomTimeBuilder extends Date {

    private final TimeStamps timeStamps;
    private final Numbers<Long> longs;

    RandomTimeBuilder(TimeStamps timeStamps, Numbers<Long> longs, long time) {
        super(time);
        this.timeStamps = timeStamps;
        this.longs = longs;
    }

    RandomTimeBuilder inThePast() {
        return someTimeBefore(getTime());
    }

    RandomTimeBuilder inTheFuture() {
        return someTimeAfter(getTime());
    }

    public RandomTimeBuilder minusDays(int days) {
        setTime(timeStamps.minusDays(getTime(), days));
        return this;
    }

    public RandomTimeBuilder addDays(int days) {
        setTime(timeStamps.addDays(getTime(), days));
        return this;
    }

    public RandomTimeBuilder minusWeeks(int weeks) {
        setTime(timeStamps.minusWeeks(getTime(), weeks));
        return this;
    }

    public RandomTimeBuilder addWeeks(int weeks) {
        setTime(timeStamps.addWeeks(getTime(), weeks));
        return this;
    }

    public RandomTimeBuilder minusMonths(int months) {
        setTime(timeStamps.minusMonths(getTime(), months));
        return this;
    }

    public RandomTimeBuilder addMonths(int months) {
        setTime(timeStamps.addMonths(getTime(), months));
        return this;
    }

    private RandomTimeBuilder someTimeBefore(long time) {
        setTime(time + (longs.someNegativeNumber() - 1));
        return this;
    }

    private RandomTimeBuilder someTimeAfter(long time) {
        setTime(time + (longs.somePositiveNumber() + 1));
        return this;
    }
}
