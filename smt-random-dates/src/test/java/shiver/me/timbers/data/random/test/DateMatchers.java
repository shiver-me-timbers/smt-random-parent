package shiver.me.timbers.data.random.test;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.apache.commons.lang3.time.DateUtils.truncate;

public class DateMatchers {

    public static Matcher<Date> isWithinASecondOf(Date date) {
        return new WithinASecondDateMatcher(date);
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

        Calendar yesterday = calendarTodayMidnight();
        yesterday.add(Calendar.DAY_OF_MONTH, -1);

        return yesterday.getTime();
    }

    public static Date todayMidnight() {
        return calendarTodayMidnight().getTime();
    }

    public static Date tomorrowMidnight() {

        Calendar yesterday = calendarTodayMidnight();
        yesterday.add(Calendar.DAY_OF_MONTH, 1);

        return yesterday.getTime();
    }

    public static Date dayAfterTomorrowMidnight() {

        Calendar yesterday = calendarTodayMidnight();
        yesterday.add(Calendar.DAY_OF_MONTH, 2);

        return yesterday.getTime();
    }

    private static Calendar calendarTodayMidnight() {
        Calendar today = new GregorianCalendar();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        return today;
    }

    private static class WithinASecondDateMatcher extends TypeSafeMatcher<Date> {

        private final Date expected;

        public WithinASecondDateMatcher(Date expected) {
            this.expected = expected;
        }

        @Override
        protected boolean matchesSafely(Date actual) {
            return truncate(expected, Calendar.SECOND).equals(truncate(actual, Calendar.SECOND));
        }

        @Override
        public void describeTo(Description description) {
            description.appendValue(expected);
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
