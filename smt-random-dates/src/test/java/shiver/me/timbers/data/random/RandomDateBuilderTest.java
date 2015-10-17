package shiver.me.timbers.data.random;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomLongs.someLong;

public class RandomDateBuilderTest {

    @Test
    public void Can_create_a_random_date_builder() {

        final Date date = mock(Date.class);

        final Long time = someLong();

        // Given
        given(date.getTime()).willReturn(time);

        // When
        final RandomDateBuilder actual = new RandomDateBuilder().create(date);

        // Then
        assertThat(actual.getTime(), is(time));
    }
}