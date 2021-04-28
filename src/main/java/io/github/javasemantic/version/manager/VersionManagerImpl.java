package io.github.javasemantic.version.manager;

import io.github.javasemantic.domain.DomainFactory;
import io.github.javasemantic.domain.model.Commit;
import io.github.javasemantic.domain.model.ProjectData;
import io.github.javasemantic.domain.model.common.Version;

public class VersionManagerImpl implements VersionManager {

  private final Version finalProjectVersion = DomainFactory.getVersion();

  @Override
  public Version calculateProjectVersion(ProjectData projectData) {
    for (var commit: projectData.getCommits()) {
      addVersionToProject(normaliseCommit(commit));
    }
    projectData.setProjectVersion(finalProjectVersion);
    return projectData.getProjectVersion();
  }

  private Version normaliseCommit(Commit commit){
    var commitVersion = commit.getDirtyVersion();
    commitVersion.setMajor(commitVersion.getMajor() >= 1 ? 1 : 0);
    commitVersion.setMinor(commitVersion.getMinor() >= 1
        && commitVersion.getMajor() <= 0 ? 1 : 0);
    commitVersion.setPatch(commitVersion.getPatch() >= 1
        && commitVersion.getMajor() <= 0
        && commitVersion.getMinor() <= 0 ? 1 : 0);
    return commitVersion;
  }

  private void addVersionToProject(Version commitVersion){
    if(commitVersion.getMajor() == 1){
      finalProjectVersion.setMajor(finalProjectVersion.getMajor()
          + commitVersion.getMajor());
      finalProjectVersion.setMinor(0);
      finalProjectVersion.setPatch(0);
    } else if(commitVersion.getMinor() == 1){
      finalProjectVersion.setMinor(finalProjectVersion.getMinor()
          + commitVersion.getMinor());
      finalProjectVersion.setPatch(0);
    }else if(commitVersion.getPatch() == 1){
      finalProjectVersion.setPatch(finalProjectVersion.getPatch()
          + commitVersion.getPatch());
    }
  }

}
