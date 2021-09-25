package io.github.javasemantic;

import io.github.javasemantic.commit.engine.CommitEngineFactory;
import io.github.javasemantic.commit.retrieval.CommitRetrievalFactory;
import io.github.javasemantic.degenerator.DegeneratorFactory;
import io.github.javasemantic.domain.model.DirtyCommit;
import io.github.javasemantic.version.manager.VersionManagerFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JavaSemanticServiceFactory {


  public static JavaSemanticService get(
      org.apache.maven.plugin.logging.Log mavenLog,
      DirtyCommit lastCommit) {
    return new JavaSemanticServiceImpl(
        DegeneratorFactory.get(),
        CommitEngineFactory.get(),
        VersionManagerFactory.get(),
        CommitRetrievalFactory.get(),
        mavenLog, lastCommit
    );
  }

}
