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

    public static Matcher<Date> isSometimeLastMonth() {
        return new LastMonthMatcher();
    }

    public static Matcher<Date> isSometimeThisMonth() {
        return new ThisMonthMatcher();
    }

    public static Matcher<Date> isSometimeNextMonth() {
        return new NextMonthMatcher();
    }

    public static Matcher<Date> isSometimeLastMonthOnThe(int date) {
        return new LastMonthDateMatcher(date);
    }

    public static Matcher<Date> isSometimeThisMonthOnThe(int date) {
        return new ThisMonthDateMatcher(date);
    }

    public static Matcher<Date> isSometimeNextMonthOnThe(int date) {
        return new NextMonthDateMatcher(date);
    }

    public static Matcher<Date> isSometimeLastYear() {
        return new LastYearMatcher();
    }

    public static Matcher<Date> isSometimeThisYear() {
        return new ThisYearMatcher();
    }

    public static Matcher<Date> isSometimeNextYear() {
        return new NextYearMatcher();
    }

    public static Matcher<Date> isSometimeLastYearOnDay(int day) {
        return new LastYearDayMatcher(day);
    }

    public static Matcher<Date> isSometimeThisYearOnDay(int day) {
        return new ThisYearDayMatcher(day);
    }

    public static Matcher<Date> isSometimeNextYearOnDay(int day) {
        return new NextYearDayMatcher(day);
    }

    private static Date yesterdayMidnight() {
        return today().minus(days(1)).toDate();
    }

    private static Date todayMidnight() {
        return today().toDate();
    }

    private static Date tomorrowMidnight() {
        return tomorrow().toDate();
    }

    private static Date dayAfterTomorrowMidnight() {
        return tomorrow().plus(days(1)).toDate();
    }

    private static Date mondayLastWeekMidnight() {
        return lastWeekMidnight(MONDAY);
    }

    private static Date mondayThisWeekMidnight() {
        return thisWeekMidnight(MONDAY);
    }

    private static Date mondayNextWeekMidnight() {
        return nextWeekMidnight(MONDAY);
    }

    private static Date mondayWeekAfterNextMidnight() {
        return nextWeek(MONDAY).plusWeeks(1).toDate();
    }

    private static Date lastWeekMidnight(MatcherWeekDay weekDay) {
        return lastWeek(weekDay).toDate();
    }

    private static Date thisWeekMidnight(MatcherWeekDay weekDay) {
        return thisWeek(weekDay).toDate();
    }

    private static Date nextWeekMidnight(MatcherWeekDay weekDay) {
        return nextWeek(weekDay).toDate();
    }

    private static Date the1stOfLastMonthMidnight() {
        return lastMonthMidnight(1);
    }

    private static Date the1stOfThisMonthMidnight() {
        return thisMonthMidnight(1);
    }

    private static Date the1stOfNextMonthMidnight() {
        return nextMonthMidnight(1);
    }

    private static Date the1stOfTheMonthAfterNextMidnight() {
        return nextMonth(1).plusMonths(1).toDate();
    }

    private static Date lastMonthMidnight(int date) {
        return lastMonth(date).toDate();
    }

    private static Date thisMonthMidnight(int date) {
        return thisMonth(date).toDate();
    }

    private static Date nextMonthMidnight(int date) {
        return nextMonth(date).toDate();
    }

    private static Date the1stDayOfLastYearMidnight() {
        return lastYearMidnight(1);
    }

    private static Date the1stDayOfThisYearMidnight() {
        return thisYearMidnight(1);
    }

    private static Date the1stDayOfNextYearMidnight() {
        return nextYearMidnight(1);
    }

    private static Date the1stDayOfTheYearAfterNextMidnight() {
        return nextYear(1).plusYears(1).toDate();
    }

    private static Date lastYearMidnight(int day) {
        return lastYear(day).toDate();
    }

    private static Date thisYearMidnight(int day) {
        return thisYear(day).toDate();
    }

    private static Date nextYearMidnight(int day) {
        return nextYear(day).toDate();
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

    private static LocalDate lastMonth(int date) {
        return today().minusMonths(1).withDayOfMonth(date);
    }

    private static LocalDate thisMonth(int date) {
        return today().withDayOfMonth(date);
    }

    private static LocalDate nextMonth(int date) {
        return today().plusMonths(1).withDayOfMonth(date);
    }

    private static LocalDate lastYear(int day) {
        return today().minusYears(1).withDayOfYear(day);
    }

    private static LocalDate thisYear(int day) {
        return today().withDayOfYear(day);
    }

    private static LocalDate nextYear(int day) {
        return today().plusYears(1).withDayOfYear(day);
    }

    public static int maxDaysLastMoneth() {
        return LocalDate.now().minusMonths(1).dayOfMonth().getMaximumValue();
    }

    public static int maxDaysThisMoneth() {
        return LocalDate.now().dayOfMonth().getMaximumValue();
    }

    public static int maxDaysNextMoneth() {
        return LocalDate.now().plusMonths(1).dayOfMonth().getMaximumValue();
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

    private static class LastMonthMatcher extends BetweenDateMatcher {
        public LastMonthMatcher() {
            super(the1stOfLastMonthMidnight(), the1stOfThisMonthMidnight());
        }
    }

    private static class ThisMonthMatcher extends BetweenDateMatcher {
        public ThisMonthMatcher() {
            super(the1stOfThisMonthMidnight(), the1stOfNextMonthMidnight());
        }
    }

    private static class NextMonthMatcher extends BetweenDateMatcher {
        public NextMonthMatcher() {
            super(the1stOfNextMonthMidnight(), the1stOfTheMonthAfterNextMidnight());
        }
    }

    private static class LastMonthDateMatcher extends BetweenDateMatcher {
        public LastMonthDateMatcher(int date) {
            super(lastMonthMidnight(date), lastMonth(date).plusDays(1).toDate());
        }

    }

    private static class ThisMonthDateMatcher extends BetweenDateMatcher {
        public ThisMonthDateMatcher(int date) {
            super(thisMonthMidnight(date), thisMonth(date).plusDays(1).toDate());
        }

    }

    private static class NextMonthDateMatcher extends BetweenDateMatcher {
        public NextMonthDateMatcher(int date) {
            super(nextMonthMidnight(date), nextMonth(date).plusDays(1).toDate());
        }

    }

    private static class LastYearMatcher extends BetweenDateMatcher {
        public LastYearMatcher() {
            super(the1stDayOfLastYearMidnight(), the1stDayOfThisYearMidnight());
        }
    }

    private static class ThisYearMatcher extends BetweenDateMatcher {
        public ThisYearMatcher() {
            super(the1stDayOfThisYearMidnight(), the1stDayOfNextYearMidnight());
        }
    }

    private static class NextYearMatcher extends BetweenDateMatcher {
        public NextYearMatcher() {
            super(the1stDayOfNextYearMidnight(), the1stDayOfTheYearAfterNextMidnight());
        }
    }

    private static class LastYearDayMatcher extends BetweenDateMatcher {
        public LastYearDayMatcher(int day) {
            super(lastYearMidnight(day), lastYear(day).plusDays(1).toDate());
        }
    }

    private static class ThisYearDayMatcher extends BetweenDateMatcher {
        public ThisYearDayMatcher(int day) {
            super(thisYearMidnight(day), thisYear(day).plusDays(1).toDate());
        }
    }

    private static class NextYearDayMatcher extends BetweenDateMatcher {
        public NextYearDayMatcher(int day) {
            super(nextYearMidnight(day), nextYear(day).plusDays(1).toDate());
        }
    }
}
