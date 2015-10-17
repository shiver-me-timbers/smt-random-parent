package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
public class RandomDateBuilder extends Date {

    RandomDateBuilder() {
    }

    private RandomDateBuilder(long time) {
        super(time);
    }

    public RandomDateBuilder create(Date date) {
        return new RandomDateBuilder(date.getTime());
    }
}
