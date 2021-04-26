package com.github.javasemantic;

import com.github.javasemantic.commit.engine.CommitEngine;
import com.github.javasemantic.commit.retrieval.CommitRetrieval;
import com.github.javasemantic.degenerator.Degenerator;
import com.github.javasemantic.domain.DomainFactory;
import com.github.javasemantic.domain.model.Commit;
import com.github.javasemantic.domain.model.DirtyCommit;
import com.github.javasemantic.domain.model.common.Version;
import com.github.javasemantic.version.manager.VersionManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JavaSemanticServiceImpl implements JavaSemanticService {

  private final Degenerator degenerator;
  private final CommitEngine<Commit> commitEngine;
  private final VersionManager versionManager;
  private final CommitRetrieval commitRetrieval;

  public Version execute() {
    var projectData = DomainFactory.getProjectData();

    for (var dirtyCommit : commitRetrieval.getCommits()) {
      var commit = createCommit(dirtyCommit);
      var result = commitEngine.execute(commit);

      if (result.isValid()) {
        projectData.getCommits().add(commit);
      }
    }

    return versionManager.calculateProjectVersion(projectData);
  }

  private Commit createCommit(DirtyCommit dirtyCommit) {
    var components = degenerator.degenerate(dirtyCommit);

    return Commit
        .builder()
        .commitComponents(components)
        .dirtyVersion(DomainFactory.getVersion())
        .dirtyCommit(dirtyCommit)
        .build();
  }

}
