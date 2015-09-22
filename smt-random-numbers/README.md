<!---
Copyright 2015 Karl Bennett

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
-->
smt-random-numbers
===========
[![Build Status](https://travis-ci.org/shiver-me-timbers/smt-random-parent.svg?branch=master)](https://travis-ci.org/shiver-me-timbers/smt-random-parent) [![Coverage Status](https://coveralls.io/repos/shiver-me-timbers/smt-random-parent/badge.svg?branch=master&service=github)](https://coveralls.io/github/shiver-me-timbers/smt-random-parent?branch=master) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.shiver-me-timbers/smt-random-numbers/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.shiver-me-timbers/smt-random-numbers/)

This library contains helper methods for generating random number.

### Maven

```xml
<dependencies>
    <dependency>
        <groupId>com.github.shiver-me-timbers</groupId>
        <artifactId>smt-random-numbers</artifactId>
        <version>1.6</version>
    </dependency>
</dependencies>
```
### Usage

This is a very simple library that contains some static methods that can be used to generate random numbers of varying
size and magnitude.

It was inspired by an internal library built by [Paul Jacobs](https://www.linkedin.com/profile/view?id=5717945) to help
with [Mockist TDD](http://martinfowler.com/articles/mocksArentStubs.html#ClassicalAndMockistTesting).

```java
someShort(); // A random positive or negative short.

somePositiveBigInteger(); // A random positive integer.

someNegativeLong(); // A random negative long.

someFloatGreaterThan(1.234F); // A random float greater than 1.234.

someDoubleLessThan(4.321D); // A random double less than 4.321.

// A random BigInteger between 1000000 and 2000000.
someBigIntegerBetween(BigInteger.valueOf(1000000), BigInteger.valueOf(2000000));

someBigDecimals(); // An iterable containing a random number of random BigDecimals.

someShorts(2); // An iterable containing 2 random shorts.

someIntegers(3).list(); // A list containing 3 random integers.

someLongs(4).array(); // An array containing 4 random longs.

// A set containing 5 random floats. NOTE: There is a very slim chance that two identical random numbers will be
// generated so the set might be small than the requested size.
someFloats(5).set();

// An iterable containing the following:
// [ someNegativeDouble(), someDoubleLessThan(7), someDoubleBetween(8, 9), someNegativeDouble(), someDoubleLessThan(7) ]
someDoubles(5).thatAreNegative().thatAreLessThan(7).thatAreBetween(8, 9);
```

There are also some methods for generating random bytes.

```java
someByte(); // A random positive or negative byte.

someBytes(); // A random length array of positive or negative bytes.

someBytes(10); // An array of 10 positive or negative bytes.

someByteInputStream(); // A random stream of positive or negative bytes.

someByteInputStream(10); // A random stream of 10 positive or negative bytes.
```

A method for generating a random enum.

```java
someEnum(MY_ENUM.class); // A random enum value.
```

And lastly a method for generating a random boolean.

```java
someBoolean(); // A random true or false value.
```