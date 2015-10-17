package shiver.me.timbers.data.random.test;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.joda.time.LocalDate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.joda.time.Period.days;
import static shiver.me.timbers.data.random.test.MatcherWeekDay.MONDAY;

public class DateMatchers {

    public static IsOnDateMatcher isOn(Date date) {
        return new IsOnDateMatcher(date);
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

    public static Matcher<Date> isSometimeLastWeek() {
        return new LastWeekMatcher();
    }

    public static Matcher<Date> isSometimeThisWeek() {
        return new ThisWeekMatcher();
    }

    public static Matcher<Date> isSometimeNextWeek() {
        return new NextWeekMatcher();
    }

    public static Matcher<Date> isSometimeLastWeekOn(MatcherWeekDay weekDay) {
        return new LastWeekDayMatcher(weekDay);
    }

    public static Matcher<Date> isSometimeThisWeekOn(MatcherWeekDay weekDay) {
        return new ThisWeekDayMatcher(weekDay);
    }

    public static Matcher<Date> isSometimeNextWeekOn(MatcherWeekDay weekDay) {
        return new NextWeekDayMatcher(weekDay);
    }

    public static Date yesterdayMidnight() {
        return today().minus(days(1)).toDate();
    }

    public static Date todayMidnight() {
        return today().toDate();
    }

    public static Date tomorrowMidnight() {
        return tomorrow().toDate();
    }

    public static Date dayAfterTomorrowMidnight() {
        return tomorrow().plus(days(1)).toDate();
    }

    public static Date mondayLastWeekMidnight() {
        return lastWeekMidnight(MONDAY);
    }

    public static Date mondayThisWeekMidnight() {
        return thisWeekMidnight(MONDAY);
    }

    public static Date mondayNextWeekMidnight() {
        return nextWeekMidnight(MONDAY);
    }

    public static Date mondayWeekAfterNextMidnight() {
        return nextWeek(MONDAY).plusWeeks(1).toDate();
    }

    public static Date lastWeekMidnight(MatcherWeekDay weekDay) {
        return lastWeek(weekDay).toDate();
    }

    public static Date thisWeekMidnight(MatcherWeekDay weekDay) {
        return thisWeek(weekDay).toDate();
    }

    public static Date nextWeekMidnight(MatcherWeekDay weekDay) {
        return nextWeek(weekDay).toDate();
    }

    private static LocalDate today() {
        return LocalDate.now();
    }

    private static LocalDate tomorrow() {
        return today().plus(days(1));
    }

    private static LocalDate lastWeek(MatcherWeekDay weekDay) {
        return thisWeek(weekDay).minusWeeks(1);
    }

    private static LocalDate thisWeek(MatcherWeekDay weekDay) {
        return today().withDayOfWeek(weekDay.ordinal() + 1);
    }

    private static LocalDate nextWeek(MatcherWeekDay weekDay) {
        return thisWeek(weekDay).plusWeeks(1);
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

    private static class LastWeekDayMatcher extends BetweenDateMatcher {
        public LastWeekDayMatcher(MatcherWeekDay weekDay) {
            super(lastWeekMidnight(weekDay), lastWeek(weekDay).plusDays(1).toDate());
        }
    }

    private static class ThisWeekDayMatcher extends BetweenDateMatcher {
        public ThisWeekDayMatcher(MatcherWeekDay weekDay) {
            super(thisWeekMidnight(weekDay), thisWeek(weekDay).plusDays(1).toDate());
        }
    }

    private static class NextWeekDayMatcher extends BetweenDateMatcher {
        public NextWeekDayMatcher(MatcherWeekDay weekDay) {
            super(nextWeekMidnight(weekDay), nextWeek(weekDay).plusDays(1).toDate());
        }
    }

    private static class LastWeekMatcher extends BetweenDateMatcher {
        public LastWeekMatcher() {
            super(mondayLastWeekMidnight(), mondayThisWeekMidnight());
        }
    }

    private static class ThisWeekMatcher extends BetweenDateMatcher {
        public ThisWeekMatcher() {
            super(mondayThisWeekMidnight(), mondayNextWeekMidnight());
        }
    }

    private static class NextWeekMatcher extends BetweenDateMatcher {
        public NextWeekMatcher() {
            super(mondayNextWeekMidnight(), mondayWeekAfterNextMidnight());
        }
    }
}
