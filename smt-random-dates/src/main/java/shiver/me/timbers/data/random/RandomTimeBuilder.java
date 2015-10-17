package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
public class RandomTimeBuilder extends Date {

    RandomTimeBuilder() {
    }

    private RandomTimeBuilder(long time) {
        super(time);
    }

    public RandomTimeBuilder create(Date date) {
        return new RandomTimeBuilder(date.getTime());
    }
}
