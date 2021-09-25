package io.github.javasemantic.version.updater;

import io.github.javasemantic.logging.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MavenVersionUpdater implements VersionUpdater {

  @Override
  public boolean updateVersion(
      Path buildToolAbsolutePath,
      Path projectBuildFile,
      String version) {

    var command = String.format(
        "%s -f %s versions:set -DnewVersion=%s",
        buildToolAbsolutePath,
        projectBuildFile,
        version);
    Log.info(MavenVersionUpdater.class, "Updating project version");
    Log.info(MavenVersionUpdater.class, String.format("Command: %s", command));

    try {
      Process process = Runtime.getRuntime().exec(command);
      printProcessToConsole(process);
      Log.info(MavenVersionUpdater.class, "Updating project version completed");
      return 0 == process.waitFor();
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  private void printProcessToConsole(final Process process) throws IOException {

    try (InputStream in = process.getInputStream()) {
      readLogs(in);
    }

    try (InputStream in = process.getErrorStream()) {
      readLogs(in);
    }

  }

  private void readLogs(final InputStream in) throws IOException {
    var printStream = new BufferedReader(new InputStreamReader(in));
    String line;
    while ((line = printStream.readLine()) != null) {
      Log.info(MavenVersionUpdater.class, line);
    }
  }
}
