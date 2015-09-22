package shiver.me.timbers.data.random;

import java.util.List;

/**
 * @author Karl Bennett
 */
interface Things {

    @SuppressWarnings("unchecked")
    <T> T someThing(T... things);

    @SuppressWarnings("unchecked")
    <T> List<T> someThings(T... things);

    @SuppressWarnings("unchecked")
    <T> List<T> someThings(int length, T... things);
}
