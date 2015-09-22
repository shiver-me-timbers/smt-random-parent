package shiver.me.timbers.data.random;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class SomeThingsTest {

    private Random random;
    private SomeThings someThings;

    @Before
    public void setUp() {
        random = mock(Random.class);
        someThings = new SomeThings(random);
    }

    @Test
    public void Can_generate_some_thing_a_single_thing() {

        final Object expected = new Object();
        final Object[] things = {expected};

        // Given
        given(random.nextInt(things.length)).willReturn(0);

        // When
        final Object actual = someThings.someThing(things);

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_generate_some_thing_from_a_some_things() {

        final Object expected = new Object();
        final Object[] things = {1, expected, "three"};

        // Given
        given(random.nextInt(things.length)).willReturn(1);

        // When
        final Object actual = someThings.someThing(things);

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void Can_generate_some_things_from_a_single_thing() {

        final Object expected = new Object();
        final Object[] things = {expected};

        // Given
        given(random.nextInt(1024)).willReturn(2);
        given(random.nextInt(things.length)).willReturn(0);

        // When
        final List<Object> actual = someThings.someThings(things);

        // Then
        assertThat(actual, equalTo(asList(expected, expected)));
    }

    @Test
    public void Can_generate_some_things_from_multiple_things() {

        final Object zero = new Object();
        final Object one = 1;
        final Object two = "two";
        final Object[] things = {zero, one, two};

        // Given
        given(random.nextInt(1024)).willReturn(4);
        given(random.nextInt(things.length)).willReturn(1, 0, 2, 0);

        // When
        final List<Object> actual = someThings.someThings(things);

        // Then
        assertThat(actual, equalTo(asList(one, zero, two, zero)));
    }

    @Test
    public void Can_generate_a_fixed_number_of_things() {

        final int size = 3;
        final Object zero = new Object();
        final Object one = "one";
        final Object[] things = {zero, one};

        // Given
        given(random.nextInt(things.length)).willReturn(1, 0, 1);

        // When
        final List<Object> actual = someThings.someThings(size, things);

        // Then
        assertThat(actual, hasSize(size));
        assertThat(actual, equalTo(asList(one, zero, one)));
    }
}