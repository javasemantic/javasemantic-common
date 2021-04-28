package io.github.javasemantic.version.manager;

import io.github.javasemantic.domain.model.ProjectData;
import io.github.javasemantic.domain.model.common.Version;

public interface VersionManager {

  Version calculateProjectVersion(ProjectData projectData);

}
