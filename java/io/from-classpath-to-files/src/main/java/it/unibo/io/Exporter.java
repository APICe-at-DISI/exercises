package it.unibo.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class Exporter {

    private Exporter() { }

    private static final File LOCAL_DIRECTORY = new File(System.getProperty("user.dir"));

    public static void exportResourceAs(final URL resource, final File place) {
        try (
            final InputStream resourceStream = resource.openStream();
            final BufferedInputStream in = new BufferedInputStream(resourceStream)
        ) {
            Files.write(place.toPath(), in.readAllBytes());
        } catch (IOException e) {
            throw new IllegalStateException(e); // Rethrow, always preserve the stacktrace!
        }
    }
}
