package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
public class RandomTimeBuilderCreator implements RandomTimeCreator<RandomTimeBuilder> {

    @Override
    public RandomTimeBuilder create(Date date) {
        return new RandomTimeBuilder(date.getTime());
    }
}
