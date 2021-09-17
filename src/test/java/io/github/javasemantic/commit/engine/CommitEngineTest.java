package io.github.javasemantic.commit.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.javasemantic.domain.model.Commit;
import io.github.javasemantic.domain.model.DirtyCommit;
import io.github.javasemantic.domain.model.ProjectData;
import io.github.javasemantic.domain.model.common.CommitComponents;
import io.github.javasemantic.domain.model.common.Version;
import io.github.javasemantic.version.manager.VersionManagerImpl;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CommitEngineTest {

  private final CommitEngine<Commit> commitEngine = CommitEngineFactory.get();


  @Test
  void version_update_test() {

    Commit commit = Commit.builder()
        .dirtyCommit(
            DirtyCommit.builder()
                .message("fix: BOOOO")
                .build()
        )
        .commitComponents(CommitComponents.builder()
            .description("BOOOO")
            .whitespace(true)
            .colon(true)
            .scope("Cake")
            .exclamation(true)
            .type("feat")
            .build())
        .dirtyVersion(new Version())
        .build();
    var result = commitEngine.execute(commit);

    assertEquals("1.1.0", commit.getDirtyVersion().toString());

    var versionManager = new VersionManagerImpl();
    var projectData = new ProjectData();
    projectData.setCommits(List.of(commit));

    var cleanResult = versionManager.calculateProjectVersion(projectData);

    assertEquals("1.0.0", cleanResult.toString());
  }

  @Test
  void multiple_commit_test() {

    Commit commit1 = Commit.builder()
        .dirtyCommit(
            DirtyCommit.builder()
                .message("fix: BOOOO")
                .build()
        )
        .commitComponents(CommitComponents.builder()
            .description("BOOOO")
            .whitespace(true)
            .colon(true)
            .scope("Cake")
            .exclamation(false)
            .type("fix")
            .build())
        .dirtyVersion(new Version())
        .build();

    Commit commit2 = Commit.builder()
        .dirtyCommit(
            DirtyCommit.builder()
                .message("feat: BOOOO")
                .build()
        )
        .commitComponents(CommitComponents.builder()
            .description("BOOOO")
            .whitespace(true)
            .colon(true)
            .scope("Cake")
            .exclamation(false)
            .type("feat")
            .build())
        .dirtyVersion(new Version())
        .build();

    Commit commit3 = Commit.builder()
        .dirtyCommit(
            DirtyCommit.builder()
                .message("fix: BOOOO")
                .build()
        )
        .commitComponents(CommitComponents.builder()
            .description("This is a BREAKING CHANGE")
            .whitespace(true)
            .colon(true)
            .scope("Cake")
            .exclamation(false)
            .type("fix")
            .build())
        .dirtyVersion(new Version())
        .build();

    var result1 = commitEngine.execute(commit1);
    var result2 = commitEngine.execute(commit2);
    var result3 = commitEngine.execute(commit3);

    var versionManager = new VersionManagerImpl();
    var projectData = new ProjectData();
    projectData.setCommits(List.of(commit1, commit2, commit3));

    var cleanResult = versionManager.calculateProjectVersion(projectData);

    assertEquals("0.1.1", cleanResult.toString());
  }
}
