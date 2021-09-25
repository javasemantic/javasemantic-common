package io.github.javasemantic;

import org.apache.log4j.BasicConfigurator;

import java.util.ArrayList;

import io.github.javasemantic.commit.engine.CommitEngine;
import io.github.javasemantic.commit.retrieval.CommitRetrieval;
import io.github.javasemantic.degenerator.Degenerator;
import io.github.javasemantic.domain.DomainFactory;
import io.github.javasemantic.domain.model.Commit;
import io.github.javasemantic.domain.model.DirtyCommit;
import io.github.javasemantic.domain.model.common.Version;
import io.github.javasemantic.logging.Log;
import io.github.javasemantic.version.manager.VersionManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JavaSemanticServiceImpl implements JavaSemanticService {

  private final Degenerator degenerator;
  private final CommitEngine<Commit> commitEngine;
  private final VersionManager versionManager;
  private final CommitRetrieval commitRetrieval;
  private final org.apache.maven.plugin.logging.Log mavenLog;
  private final DirtyCommit lastCommit;

  public void init() {
    BasicConfigurator.configure();
    Log.setMavenLog(mavenLog);
  }

  @Override
  public Version execute() {
    init();

    var projectData = DomainFactory.getProjectData();
    var dirtyCommits = new ArrayList<>(commitRetrieval.getCommits());
    dirtyCommits.add(lastCommit);

    for (var dirtyCommit : dirtyCommits) {
      var commit = createCommit(dirtyCommit);
      var result = commitEngine.execute(commit);

      if (result.isValid()) {
        Log.info(this.getClass(), String.format(
            "Valid Commit: %s, Commit's dirty version: %s",
            dirtyCommit.getMessage(),
            commit.getDirtyVersion().toString()
        ));
        projectData.getCommits().add(commit);
      }
    }

    var projectVersion = versionManager.calculateProjectVersion(projectData);

    Log.info(this.getClass(), String.format(
        "Project version: %s",
        projectVersion.toString()
    ));

    return projectVersion;
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
