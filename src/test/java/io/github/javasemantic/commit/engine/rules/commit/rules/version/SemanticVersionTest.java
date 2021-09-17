package io.github.javasemantic.commit.engine.rules.commit.rules.version;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.javasemantic.commit.engine.rules.common.TypeEnum;
import io.github.javasemantic.domain.model.Commit;
import io.github.javasemantic.domain.model.common.Version;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SemanticVersionTest {

  @Test
  void when_version_is_valid() {

    //Given
    var version = new SemanticVersion(TypeEnum.FEAT);
    Commit commit = Commit.builder().dirtyVersion(new Version()).build();

    //When
    var actual = version.execute(commit);

    //Then
    assertTrue(actual.isAppliedOrValid());
    assertEquals((int) commit.getDirtyVersion().getMinor(), 1);
  }

}
