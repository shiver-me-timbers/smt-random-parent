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
interface Times {

    RandomTimeBuilder someTime();

    RandomTimeBuilder someTimeInThePast();

    RandomTimeBuilder someTimeInTheFuture();

    RandomTimeBuilder someTimeBefore(Date date);

    RandomTimeBuilder someTimeAfter(Date date);

    RandomTimeBuilder someTimeBetween(Date min, Date max);

    RandomTimeBuilder someTimeLastSecond();

    RandomTimeBuilder someTimeThisSecond();

    RandomTimeBuilder someTimeNextSecond();

    RandomTimeBuilder someTimeLastMinute();

    RandomTimeBuilder someTimeThisMinute();

    RandomTimeBuilder someTimeNextMinute();

    RandomTimeBuilder someTimeLastHour();

    RandomTimeBuilder someTimeThisHour();

    RandomTimeBuilder someTimeNextHour();

    RandomTimeBuilder someTimeYesterday();

    RandomTimeBuilder someTimeToday();

    RandomTimeBuilder someTimeTomorrow();

    RandomTimeBuilder someTimeLastWeek();

    RandomTimeBuilder someTimeThisWeek();

    RandomTimeBuilder someTimeNextWeek();

    RandomTimeBuilder someTimeLastWeekOn(WeekDay weekDay);

    RandomTimeBuilder someTimeThisWeekOn(WeekDay weekDay);

    RandomTimeBuilder someTimeNextWeekOn(WeekDay weekDay);

    RandomTimeBuilder someTimeLastMonth();

    RandomTimeBuilder someTimeThisMonth();

    RandomTimeBuilder someTimeNextMonth();

    RandomTimeBuilder someTimeLastMonthOnThe(int date);

    RandomTimeBuilder someTimeThisMonthOnThe(int date);

    RandomTimeBuilder someTimeNextMonthOnThe(int date);

    RandomTimeBuilder someTimeLastYear();

    RandomTimeBuilder someTimeThisYear();

    RandomTimeBuilder someTimeNextYear();

    RandomTimeBuilder someTimeLastYearOnDay(int day);

    RandomTimeBuilder someTimeThisYearOnDay(int day);

    RandomTimeBuilder someTimeNextYearOnDay(int day);
}
