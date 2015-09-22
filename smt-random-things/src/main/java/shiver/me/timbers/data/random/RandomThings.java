package shiver.me.timbers.data.random;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Simple helper methods for generating random things.
 *
 * @author Karl Bennett
 */
public class RandomThings {

    private static Things things() {
        return new SomeThings(ThreadLocalRandom.current());
    }

    @SafeVarargs
    public static <T> T someThing(T... things) {
        return things().someThing(things);
    }

    @SafeVarargs
    public static <T> List<T> someThings(T... things) {
        return things().someThings(things);
    }

    @SafeVarargs
    public static <T> List<T> someThings(int length, T... things) {
        return things().someThings(length, things);
    }
}
