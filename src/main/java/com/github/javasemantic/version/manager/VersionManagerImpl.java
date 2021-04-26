package com.github.javasemantic.version.manager;

import com.github.javasemantic.domain.DomainFactory;
import com.github.javasemantic.domain.model.ProjectData;
import com.github.javasemantic.domain.model.common.Version;

public class VersionManagerImpl implements VersionManager {

    @Override
    public Version calculateProjectVersion(ProjectData projectData) {
        return DomainFactory.getVersion();
    }
}
