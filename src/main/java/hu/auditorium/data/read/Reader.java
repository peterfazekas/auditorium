package hu.auditorium.data.read;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public interface Reader {

    List<String> read(final String fileName);

}
