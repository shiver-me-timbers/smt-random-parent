package shiver.me.timbers.data.random.test;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.joda.time.LocalDate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.joda.time.Period.days;

public class DateMatchers {

    public static IsOnDateMatcher isOn(Date date) {
        return new IsOnDateMatcher(date);
    }

    public static Matcher<Date> isMidnightYesterday() {
        return new IsOnDateMatcher(yesterdayMidnight());
    }

    public static Matcher<Date> isMidnightToday() {
        return new IsOnDateMatcher(todayMidnight());
    }

    public static Matcher<Date> isMidnightTomorrow() {
        return new IsOnDateMatcher(tomorrowMidnight());
    }

    public static Matcher<Date> isBetween(Date min, Date max) {
        return new BetweenDateMatcher(min, max);
    }

    public static Matcher<Date> isSometimeYesterday() {
        return new YesterdayMatcher();
    }

    public static Matcher<Date> isSometimeToday() {
        return new TodayMatcher();
    }

    public static Matcher<Date> isSometimeTomorrow() {
        return new TomorrowMatcher();
    }

    public static Date yesterdayMidnight() {
        return yesterday().toDate();
    }

    public static Date todayMidnight() {
        return today().toDate();
    }

    public static Date tomorrowMidnight() {
        return tomorrow().toDate();
    }

    private static LocalDate yesterday() {
        return today().minus(days(1));
    }

    private static LocalDate today() {
        return LocalDate.now();
    }

    private static LocalDate tomorrow() {
        return today().plus(days(1));
    }

    public static Date dayAfterTomorrowMidnight() {
        return tomorrow().plus(days(1)).toDate();
    }

    public static class IsOnDateMatcher extends TypeSafeMatcher<Date> {

        private final Date expected;
        private long duration = 0;
        private TimeUnit unit = MILLISECONDS;

        public IsOnDateMatcher(Date expected) {
            this.expected = expected;
        }

        @Override
        protected boolean matchesSafely(Date actual) {
            final long expectedTime = expected.getTime();
            final long actualTime = actual.getTime();
            final long threshold = unit.toMillis(duration);
            final long lowerBoundTime = expectedTime - threshold;
            final long upperBoundTime = expectedTime + threshold;

            return lowerBoundTime <= actualTime && actualTime <= upperBoundTime;
        }

        @Override
        public void describeTo(Description description) {
            description.appendValue(expected);
        }

        public IsOnDateMatcher within(long duration, TimeUnit unit) {
            this.duration = duration;
            this.unit = unit;
            return this;
        }
    }

    private static class BetweenDateMatcher extends TypeSafeMatcher<Date> {

        private final Date min;
        private final Date max;

        public BetweenDateMatcher(Date min, Date max) {
            this.min = min;
            this.max = max;
        }

        @Override
        protected boolean matchesSafely(Date actual) {
            return !(actual.before(min)) && actual.before(max);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText(String.format("between: %s and %s", min, max));
        }
    }

    private static class YesterdayMatcher extends BetweenDateMatcher {
        public YesterdayMatcher() {
            super(yesterdayMidnight(), todayMidnight());
        }
    }

    private static class TodayMatcher extends BetweenDateMatcher {
        public TodayMatcher() {
            super(todayMidnight(), tomorrowMidnight());
        }
    }

    private static class TomorrowMatcher extends BetweenDateMatcher {
        public TomorrowMatcher() {
            super(tomorrowMidnight(), dayAfterTomorrowMidnight());
        }
    }
}
