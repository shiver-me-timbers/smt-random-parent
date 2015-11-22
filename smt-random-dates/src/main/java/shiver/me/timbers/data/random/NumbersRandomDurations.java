package shiver.me.timbers.data.random;

/**
 * @author Karl Bennett
 */
class NumbersRandomDurations implements RandomDurations {

    private static final int MILLISECONDS_IN_ONE_DAY = 86400000;
    private static final int MILLISECONDS_IN_ONE_WEEK = 604800000;

    private final Numbers<Integer> integers;

    public NumbersRandomDurations(Numbers<Integer> integers) {
        this.integers = integers;
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
