package shiver.me.timbers.data.random;

import java.util.Date;

/**
 * @author Karl Bennett
 */
public interface RandomTimeCreator<D extends Date> {

    D create(Date date);
}
