/*
 * Copyright 2015 Karl Bennett
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
class SomeTimes implements Times {

    private final RandomTimeFactory<RandomTimeBuilder> randomTimeFactory;

    public SomeTimes(RandomTimeFactory<RandomTimeBuilder> randomTimeFactory) {
        this.randomTimeFactory = randomTimeFactory;
    }

    @Override
    public RandomTimeBuilder someTime() {
        return randomTimeFactory.random();
    }

    @Override
    public RandomTimeBuilder someTimeInThePast() {
        return now().inThePast();
    }

    @Override
    public RandomTimeBuilder someTimeInTheFuture() {
        return now().inTheFuture();
    }

    @Override
    public RandomTimeBuilder someTimeBefore(Date date) {
        return create(date).inThePast();
    }

    @Override
    public RandomTimeBuilder someTimeAfter(Date date) {
        return create(date).inTheFuture();
    }

    @Override
    public RandomTimeBuilder someTimeBetween(Date min, Date max) {
        return randomTimeFactory.between(min, max);
    }

    @Override
    public RandomTimeBuilder someTimeLastSecond() {
        return someTimeThisSecond().minusSecond(1);
    }

    @Override
    public RandomTimeBuilder someTimeThisSecond() {
        return randomTimeFactory.thisSecond();
    }

    @Override
    public RandomTimeBuilder someTimeNextSecond() {
        return someTimeThisSecond().addSecond(1);
    }

    @Override
    public RandomTimeBuilder someTimeLastMinute() {
        return someTimeThisMinute().minusMinutes(1);
    }

    @Override
    public RandomTimeBuilder someTimeThisMinute() {
        return randomTimeFactory.thisMinute();
    }

    @Override
    public RandomTimeBuilder someTimeNextMinute() {
        return someTimeThisMinute().addMinutes(1);
    }

    @Override
    public RandomTimeBuilder someTimeLastHour() {
        return someTimeThisHour().minusHours(1);
    }

    @Override
    public RandomTimeBuilder someTimeThisHour() {
        return randomTimeFactory.thisHour();
    }

    @Override
    public RandomTimeBuilder someTimeNextHour() {
        return someTimeThisHour().addHours(1);
    }

    @Override
    public RandomTimeBuilder someTimeYesterday() {
        return someTimeToday().minusDays(1);
    }

    @Override
    public RandomTimeBuilder someTimeToday() {
        return randomTimeFactory.today();
    }

    @Override
    public RandomTimeBuilder someTimeTomorrow() {
        return someTimeToday().addDays(1);
    }

    @Override
    public RandomTimeBuilder someTimeLastWeek() {
        return someTimeThisWeek().minusWeeks(1);
    }

    @Override
    public RandomTimeBuilder someTimeThisWeek() {
        return randomTimeFactory.thisWeek();
    }

    @Override
    public RandomTimeBuilder someTimeNextWeek() {
        return someTimeThisWeek().addWeeks(1);
    }

    @Override
    public RandomTimeBuilder someTimeLastWeekOn(WeekDay weekDay) {
        return someTimeThisWeekOn(weekDay).minusWeeks(1);
    }

    @Override
    public RandomTimeBuilder someTimeThisWeekOn(WeekDay weekDay) {
        return randomTimeFactory.thisWeekOn(weekDay);
    }

    @Override
    public RandomTimeBuilder someTimeNextWeekOn(WeekDay weekDay) {
        return someTimeThisWeekOn(weekDay).addWeeks(1);
    }

    @Override
    public RandomTimeBuilder someTimeLastMonth() {
        return randomTimeFactory.lastMonth();
    }

    @Override
    public RandomTimeBuilder someTimeThisMonth() {
        return randomTimeFactory.thisMonth();
    }

    @Override
    public RandomTimeBuilder someTimeNextMonth() {
        return randomTimeFactory.nextMonth();
    }

    @Override
    public RandomTimeBuilder someTimeLastMonthOnThe(int date) {
        return randomTimeFactory.lastMonthOnThe(date);
    }

    @Override
    public RandomTimeBuilder someTimeThisMonthOnThe(int date) {
        return randomTimeFactory.thisMonthOnThe(date);
    }

    @Override
    public RandomTimeBuilder someTimeNextMonthOnThe(int date) {
        return randomTimeFactory.nextMonthOnThe(date);
    }

    @Override
    public RandomTimeBuilder someTimeLastYear() {
        return randomTimeFactory.lastYear();
    }

    @Override
    public RandomTimeBuilder someTimeThisYear() {
        return randomTimeFactory.thisYear();
    }

    @Override
    public RandomTimeBuilder someTimeNextYear() {
        return randomTimeFactory.nextYear();
    }

    @Override
    public RandomTimeBuilder someTimeLastYearOnDay(int day) {
        return randomTimeFactory.lastYearOnDay(day);
    }

    @Override
    public RandomTimeBuilder someTimeThisYearOnDay(int day) {
        return randomTimeFactory.thisYearOnDay(day);
    }

    @Override
    public RandomTimeBuilder someTimeNextYearOnDay(int day) {
        return randomTimeFactory.nextYearOnDay(day);
    }

    private RandomTimeBuilder now() {
        return randomTimeFactory.now();
    }

    private RandomTimeBuilder create(Date date) {
        return randomTimeFactory.create(date);
    }

}
