package shiver.me.timbers.data.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Karl Bennett
 */
class SomeThings implements Things {

    private final Random random;

    public SomeThings(Random random) {
        this.random = random;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T someThing(T... things) {
        return things[random.nextInt(things.length)];
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> someThings(T... things) {
        return someThings(random.nextInt(1024), things);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> someThings(int length, T... things) {

        final List<T> someThings = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            someThings.add(things[random.nextInt(things.length)]);
        }

        return someThings;
    }
}
