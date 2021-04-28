package io.github.javasemantic.domain;

import io.github.javasemantic.domain.model.ProjectData;
import io.github.javasemantic.domain.model.common.Version;
import java.util.function.Supplier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DomainFactory {

  private static final Supplier<Version> constructorVersion = Version::new;
  private static final Supplier<ProjectData> constructorProjectData = ProjectData::new;

  public static Version getVersion() {
    return constructorVersion.get();
  }

  public static ProjectData getProjectData() {
    return constructorProjectData.get();
  }
}
