package io.github.javasemantic.version.updater;

import java.nio.file.Path;

public interface VersionUpdater {

  boolean updateVersion(Path buildToolAbsolutePath, Path projectBuildFile, String version);

}
