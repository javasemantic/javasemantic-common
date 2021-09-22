package io.github.javasemantic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.javasemantic.commit.engine.CommitEngineImpl;
import io.github.javasemantic.commit.retrieval.CommitRetrieval;
import io.github.javasemantic.degenerator.DegeneratorImpl;
import io.github.javasemantic.domain.model.DirtyCommit;
import io.github.javasemantic.version.manager.VersionManagerImpl;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JavaSemanticServiceTest {

  @Test
  void integrationTest() {

    var service = new JavaSemanticServiceImpl(
        new DegeneratorImpl(),
        new CommitEngineImpl(),
        new VersionManagerImpl(),
        new CommitRetrievalTestImplOne(),
        null
    );

    var version = service.execute();

    assertEquals("3.0.2", version.toString());
  }

  private static class CommitRetrievalTestImplOne implements CommitRetrieval {

    @Override
    public List<DirtyCommit> getCommits() {
      return List.of(
          DirtyCommit.builder().message("feat!: Chicken code").build(),//100
          DirtyCommit.builder().message("feat!: a breaking feature").build(),//200
          DirtyCommit.builder().message("fix: a random fix").build(),//201
          DirtyCommit.builder()
              .message("fix(not really): help Kreason insert commits to free Britney").build(),//202
          DirtyCommit.builder().message("fix!: Your noon").build(),//300
          DirtyCommit.builder().message("chore: Do nothing").build(),//301
          DirtyCommit.builder().message("chore: updated docs").build()//302
      );
    }
  }

  @Test
  void integrationTestTwo() {

    var service = new JavaSemanticServiceImpl(
        new DegeneratorImpl(),
        new CommitEngineImpl(),
        new VersionManagerImpl(),
        new CommitRetrievalTestImplTwo(),
        null
    );

    var version = service.execute();

    assertEquals("1.1.2", version.toString());
  }

  private static class CommitRetrievalTestImplTwo implements CommitRetrieval {

    @Override
    public List<DirtyCommit> getCommits() {
      return List.of(
          DirtyCommit.builder().message("chore: initial project files and setup").build(),//001
          DirtyCommit.builder().message("feat: commit engine").build(),//010
          DirtyCommit.builder().message("Merge pull request #8 from java-semantic/poc/commit-engine").build(),//010
          DirtyCommit.builder().message("fix: test and create action for automated builds (#9)").build(),//011
          DirtyCommit.builder().message("feat: initial project services (#10)").build(),//020
          DirtyCommit.builder().message("feat: add rules and update engine (#13)").build(),//030
          DirtyCommit.builder().message("feat: version manager (#12)").build(),//040
          DirtyCommit.builder().message("feat: added jgit integration for getting commits from git (#11)").build(),//050
          DirtyCommit.builder().message("chore: create maven publish action").build(),//051
          DirtyCommit.builder().message("Create codeql-analysis.yml (#15)").build(),//051
          DirtyCommit.builder().message("feat: add degenerator impl, and fix for green (#14)").build(),//060
          DirtyCommit.builder().message("feat: testing update, big fixes and first green flow (#17)").build(),//070
          DirtyCommit.builder().message("chore: added jacoco, reformatted code, code owners (#18)").build(),//071
          DirtyCommit.builder().message("feature!: install hooks and plenty of bugs (#19)").build(),//080
          DirtyCommit.builder().message("feat: get logging from plugin").build(),//090
          DirtyCommit.builder().message("chore: more logs").build(),//091
          DirtyCommit.builder().message("fix: fixed regex not allowing any char after colon").build()//092
      );
    }
  }

  @Test
  public void testAgainstOurGit() {
    var service = JavaSemanticServiceFactory.get(null);
    var version = service.execute();
    System.out.println(version);
  }

}
