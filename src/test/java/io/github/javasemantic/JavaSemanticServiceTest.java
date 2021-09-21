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
        new CommitRetrievalTestImpl()

    );

    var version = service.execute();

    assertEquals("3.0.2", version.toString());
  }

  private class CommitRetrievalTestImpl implements CommitRetrieval {

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
  public void testAgainstOurGit() {
    var service = JavaSemanticServiceFactory.get();
    var version = service.execute();
    System.out.println(version);
  }

}
