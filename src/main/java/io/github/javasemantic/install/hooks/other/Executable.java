package io.github.javasemantic.install.hooks.other;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Supplier;

public interface Executable {

    /** Erase the executable content */
    void truncate() throws IOException;

    /**
     * @param template The template to truncate with
     * @param sourceEncoding The source encoding
     * @param values The values to use for the template interpolations
     */
    Executable truncateWithTemplate(
            Supplier<InputStream> template, String sourceEncoding, Object... values) throws IOException;

    /**
     * Appends a command call to the executable
     *
     * @param commandCall The command call to append to the executable
     */
    Executable appendCommandCall(String commandCall) throws IOException;

    /**
     * Remove a command call from the executable
     *
     * @param commandCall The command call to remove
     */
    Executable removeCommandCall(String commandCall);

}
