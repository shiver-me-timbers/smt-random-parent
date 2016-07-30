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
smt-randoms-things
===========
[![Build Status](https://travis-ci.org/shiver-me-timbers/smt-random-parent.svg?branch=master)](https://travis-ci.org/shiver-me-timbers/smt-random-parent) [![Coverage Status](https://coveralls.io/repos/shiver-me-timbers/smt-random-parent/badge.svg?branch=master&service=github)](https://coveralls.io/github/shiver-me-timbers/smt-random-parent?branch=master) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.shiver-me-timbers/smt-random-things/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.shiver-me-timbers/smt-random-things/)

This library contains helper methods for generating random objects.

### Usage

This is a very simple library that contains some static methods that can be used to generate random objects.

```java
// An instance random object that could be any of the core types.
someThing();
// One of any of the supplied values, selected at random.
someThing(1, 2.0F, "three", new Four());

// An iterable containing a random number of instances of random objects that could be any of the core types.
someThings()
// An iterable containing a random number of any of the supplied values, selected randomly.
someThings(1, 2.0F, "three", new Four());
```

The iterable returned by the `someThings()` method is a custom iterable that can be used to create any of the main 
collections. As well as set the number of elements within the iterable.

```java
// A list containing 5 instances of random objects that could be any of the core types.
someThings().withLength(5).list();
// A set containing 6 of any of the supplied values, selected randomly.
someThings(1, 2.0F, "three", new Four()).withLength(6).set();
// An array containing 7 of any of the supplied values, selected randomly.
someThings(5L, 6.0D, "seven", new Eight()).withLength(7).set();
```