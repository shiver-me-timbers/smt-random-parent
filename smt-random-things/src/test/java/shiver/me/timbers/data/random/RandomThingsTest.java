package shiver.me.timbers.data.random;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomThings.someThing;
import static shiver.me.timbers.data.random.RandomThings.someThings;

public class RandomThingsTest {

    @Test
    public void Instantiation_to_get_full_coverage() {

        new RandomThings();
    }

    @Test
    public void Can_generate_some_thing() {

        // Given
        final Object zero = new Object();
        final Object one = 1;
        final Object two = "two";

        // When
        final Object actual = someThing(zero, one, two);

        // Then
        assertThat(actual, isOneOf(zero, one, two));
    }

    @Test
    public void Can_generate_some_things() {

        // Given
        final Object zero = new Object();
        final Object one = 1;
        final Object two = "two";

        // When
        final List<Object> actual = someThings(zero, one, two);

        // Then
        assertThat(actual, anyOf(hasItem(zero), hasItem(one), hasItem(two)));
    }

    @Test
    public void Can_generate_some_things_with_a_fixed_length() {

        // Given
        final int size = 5;
        final Object zero = new Object();
        final Object one = 1;
        final Object two = "two";

        // When
        final List<Object> actual = someThings(size, new Object[]{zero, one, two});

        // Then
        assertThat(actual, hasSize(size));
        assertThat(actual, anyOf(hasItem(zero), hasItem(one), hasItem(two)));
    }
}