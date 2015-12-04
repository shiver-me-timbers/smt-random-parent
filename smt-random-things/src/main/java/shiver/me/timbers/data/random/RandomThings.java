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

    /**
     * Randomly selects one of the supplied objects and returns it.
     */
    @SafeVarargs
    public static <T> T someThing(T... things) {
        return things().someThing(things);
    }

    /**
     * Generates a list with a random length (max 1024) that is populated with random amounts of any of the supplied
     * objects.
     */
    @SafeVarargs
    public static <T> List<T> someThings(T... things) {
        return things().someThings(things);
    }

    /**
     * Generates a list with fixed a random length that is populated with random amounts of any of the supplied objects.
     */
    @SafeVarargs
    public static <T> List<T> someThings(int length, T... things) {
        return things().someThings(length, things);
    }
}
