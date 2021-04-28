package io.github.javasemantic.commit.engine.rules.commit.rules.version;

import io.github.javasemantic.commit.engine.rules.common.TypeEnum;
import io.github.javasemantic.domain.model.Commit;
import io.github.javasemantic.domain.model.common.Version;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class StatefulSemanticVersionTest {


  @Test
  void when_version_is_valid() {

    //Given
    var version = new StatefulSemanticVersion();
    Commit commit = Commit.builder().dirtyVersion(new Version()).typeEnum(TypeEnum.BREAKING_CHANGE).build();

    //When
    var actual = version.execute(commit);

    //Then
    assertTrue(actual.isAppliedOrValid());
    assertEquals((int) commit.getDirtyVersion().getMajor(), 1);
  }

}
