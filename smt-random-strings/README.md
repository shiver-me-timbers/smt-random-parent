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
smt-random-strings
===========
[![Build Status](https://travis-ci.org/shiver-me-timbers/smt-random-parent.svg?branch=master)](https://travis-ci.org/shiver-me-timbers/smt-random-parent) [![Coverage Status](https://coveralls.io/repos/shiver-me-timbers/smt-random-parent/badge.svg?branch=master&service=github)](https://coveralls.io/github/shiver-me-timbers/smt-random-parent?branch=master) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.shiver-me-timbers/smt-random-strings/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.shiver-me-timbers/smt-random-strings/)

This library contains helper methods for generating random strings.

### Maven

```xml
<dependencies>
    <dependency>
        <groupId>com.github.shiver-me-timbers</groupId>
        <artifactId>smt-random-strings</artifactId>
        <version>1.4</version>
    </dependency>
</dependencies>
```
### Usage

This is a very simple library that contains some static methods that can be used to generate random strings.

It was inspired by an internal library built by [Paul Jacobs](https://www.linkedin.com/profile/view?id=5717945) to help
with [Mockist TDD](http://martinfowler.com/articles/mocksArentStubs.html#ClassicalAndMockistTesting).

```java
someString(); // A random ASCII string of any length up to 1024 characters.
someString(2); // A random string that has a length of 2 characters.
someString(3, 4); // A random string that has a length between 3 to 4 characters.
// A random string of any length up to 1024 characters that will only contains the characters 'a', 'b', 'c',
// '1', '2', or '3'.
someString("abc123");
// A random string that has a length of 5 characters and will only contain the characters '6', '5', '4', 'g',
// 'f', or 'e'.
someString(5, "654gfe");
// A random string that has a length between 6 to 7 characters and will only contain the characters 'h', 
// 'i', 'j', '7', '8', or '9'.
someString(6, 7, "hij789");

// A random string that only contains alphabet characters of any length up to 1024 characters.
someAlphaString();
// A random string that only contains alphabet characters that has a length of 8 characters.
someAlphaString(8);
// A random string that only contains alphabet characters that has a length between 9 to 10 characters.
someAlphaString(9, 10);

// A random string that only contains number characters of any length up to 1024 characters.
someNumericString(); 
// A random string that only contains number characters that has a length of 11 characters.
someNumericString(11); 
// A random string that only contains number characters that has a length between 12 to 13 characters.
someNumericString(12, 13); 

// A random string that only contains number and alphabet characters of any length up to 1024 characters.
someAlphaNumericString();
// A random string that only contains number and alphabet characters that has a length of 14 characters.
someAlphaNumericString(14);
// A random string that only contains number and alphabet characters that has a length between 15 to 16
// characters.
someAlphaNumericString(15, 16);
```

There is also a builder method that allows for generating more complex strings.

```java
// A random string that has a length between 17 to 18 characters and that can also contain all the alphabet
// characters along with the '_' and '-' characters.
buildSomeString().withLengthBetween(17, 18).thatContainsAlphaCharacters().thatContains("_-").build();
```