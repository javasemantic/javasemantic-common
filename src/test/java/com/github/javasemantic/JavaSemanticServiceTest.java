package com.github.javasemantic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.javasemantic.commit.engine.CommitEngine;
import com.github.javasemantic.commit.engine.CommitEngineFactory;
import com.github.javasemantic.commit.retrieval.CommitRetrieval;
import com.github.javasemantic.degenerator.Degenerator;
import com.github.javasemantic.degenerator.DegeneratorFactory;
import com.github.javasemantic.domain.model.Commit;
import com.github.javasemantic.version.manager.VersionManager;
import com.github.javasemantic.version.manager.VersionManagerFactory;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JavaSemanticServiceTest {

  private JavaSemanticService javaSemanticService;
  private final Degenerator degenerator = DegeneratorFactory.get();
  private final CommitEngine<Commit> commitEngine = CommitEngineFactory.get();
  private final VersionManager versionManager = VersionManagerFactory.get();
  private CommitRetrieval commitRetrieval;

  @BeforeEach
  public void setup() {
    commitRetrieval = mock(CommitRetrieval.class);

    javaSemanticService = new JavaSemanticServiceImpl(
        degenerator, commitEngine, versionManager, commitRetrieval
    );
  }

  @Test
  public void when_executeWithNoData_should_executeWithoutExceptions() {
    when(commitRetrieval.getCommits())
        .thenReturn(Collections.emptyList());

    var version = javaSemanticService.execute();

    assertEquals("0.0.0", version.toString());
  }

  @Test
  public void when_executeWithData_should_executeWithoutExceptions() {
    when(commitRetrieval.getCommits())
        .thenReturn(List.of("feat: this should be picked up when code is implemented"));

    var version = javaSemanticService.execute();

    assertEquals("0.0.0", version.toString());
  }

}
