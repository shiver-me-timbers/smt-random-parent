package shiver.me.timbers.data.random;

/**
 * @author Karl Bennett
 */
class NumbersRandomDurations implements RandomDurations {

    private static final int MILLISECONDS_IN_ONE_SECOND = 1000;
    private static final int MILLISECONDS_IN_ONE_MINUTE = MILLISECONDS_IN_ONE_SECOND * 60;
    private static final int MILLISECONDS_IN_ONE_HOUR = MILLISECONDS_IN_ONE_MINUTE * 60;
    private static final int MILLISECONDS_IN_ONE_DAY = MILLISECONDS_IN_ONE_HOUR * 24;
    private static final int MILLISECONDS_IN_ONE_WEEK = MILLISECONDS_IN_ONE_DAY * 7;

    private final Numbers<Integer> integers;

    public NumbersRandomDurations(Numbers<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public long someTimeInASecond() {
        return integers.someNumberBetween(0, MILLISECONDS_IN_ONE_SECOND);
    }

    @Override
    public long someTimeInAMinute() {
        return integers.someNumberBetween(0, MILLISECONDS_IN_ONE_MINUTE);
    }

    @Override
    public long someTimeInAnHour() {
        return integers.someNumberBetween(0, MILLISECONDS_IN_ONE_HOUR);
    }

    @Override
    public long someTimeInADay() {
        return integers.someNumberBetween(0, MILLISECONDS_IN_ONE_DAY);
    }

    @Override
    public long someTimeInAWeek() {
        return integers.someNumberBetween(0, MILLISECONDS_IN_ONE_WEEK);
    }

    @Override
    public long someTimeInDays(int days) {
        return (long) integers.someNumberBetween(0, days) * MILLISECONDS_IN_ONE_DAY;
    }
}
