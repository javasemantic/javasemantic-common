package io.github.javasemantic.install.hooks.model;

import java.nio.file.Path;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class InstallHookArguments {

  private Path projectBuildFile;
  private String artifactId;
  private boolean isExecutionRoot;
  private Path projectBaseDirectory;
  private String[] propertiesToPropagate;
  private String[] propertiesToAdd;
  private String gitLifeCycle;
  private Path buildToolAbsolutePath;
  private String buildFileName;

}
