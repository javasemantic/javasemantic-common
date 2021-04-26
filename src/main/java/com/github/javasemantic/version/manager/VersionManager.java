package com.github.javasemantic.version.manager;

import com.github.javasemantic.domain.model.ProjectData;
import com.github.javasemantic.domain.model.common.Version;

public interface VersionManager {

    Version calculateProjectVersion(ProjectData projectData);

}
