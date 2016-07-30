<!---
Copyright (C) 2015  Karl Bennett

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
-->
smt-random-dates
===========
[![Build Status](https://travis-ci.org/shiver-me-timbers/smt-random-parent.svg?branch=master)](https://travis-ci.org/shiver-me-timbers/smt-random-parent) [![Coverage Status](https://coveralls.io/repos/shiver-me-timbers/smt-random-parent/badge.svg?branch=master&service=github)](https://coveralls.io/github/shiver-me-timbers/smt-random-parent?branch=master) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.shiver-me-timbers/smt-random-dates/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.shiver-me-timbers/smt-random-dates/)

This library contains helper methods for generating random dates.

### Usage

This is a very simple library that contains some static methods that can be used to generate random dates.

##### Time

It is possible to generate a completely random time (`java.util.Date`), one in the past, or one in the future. Or a time 
can be generate in relation to a specific time or within a time range.

```java
final long millisecondsInADay = 86400000;
final Date now = new Date();
final Date tomorrow = new Date(now.getTime() + millisecondsInADay);

// A completely random time that could be in the past, present, or future.
someTime();
// A random time in the past.
someTimeInThePast();
// A random time in the future.
someTimeInTheFuture();
// A random time before now.
someTimeBefore(now);
// A random time after now.
someTimeAfter(now);
// A random time between now and tomorrow.
someTimeBetween(now, tomorrow);
```

##### Time Units

It is possible to generate random times that fall within different time units in relation to the current time. That is 
you can generate a random time within a second, minute, hour, day, week, month, or year from now.

```java
// Generate a random time that falls within the last second.
someTimeLastSecond();
// Generate a random time that falls within the current minute.
someTimeThisMinute();
// Generate a random time that falls within the next hour.
someTimeNextHour();
// Generate a random time that falls within yesterday.
someTimeYesterday();
// Generate a random time that falls within this week.
someTimeThisWeek();
// Generate a random time that falls on Tuesday next week.
someTimeNextWeekOn(TUESDAY);
// Generate a random time that falls within last month.
someTimeLastMonth();
// Generate a random time that falls on the 10th of this month.
someTimeThisMonthOnThe(10);
// Generate a random time that falls within next year.
someTimeNextYear(10);
// Generate a random time that falls on the 100th day of last year.
someTimeLastYearOnDay(100);
```

##### Time Building

All of the random time generation methods return a 
[`RandomTimeBuilder`](src/main/java/shiver/me/timbers/data/random/RandomTimeBuilder.java) which is an extension of the 
Java `java.util.Date` object. So it can be used in place of any `Date`, but it also provides methods that allow you to 
refine your generate date.

```java
// Generate a random time that falls within the last minute minus thirty seconds.
someTimeLastMinute().minusSecond(30);
// Generate a random time that falls within the current hour plus 2 minutes.
someTimeThisHour().minusMinutes(2);
// Generate a random time that falls within tomorrow plus 6 hours.
someTimeTomorrow().addHours(6);
// Generate a random time that falls within last week minus 3 days.
someTimeLastWeek().minusDays(3);
// Generate a random time that falls within this month plus 1 week.
someTimeThisMonth().addWeeks(1);
// Generate a random time that falls within next year minus 5 months.
someTimeNextYear().minusMonths(5);
// Generate a random time that falls within the year before last.
someTimeLastYear().minusYears(1);
```