package com.github.javasemantic.commit.engine.rules.commit.rules.version;

import com.github.javasemantic.commit.engine.factory.enums.StructuralRuleEnum;
import com.github.javasemantic.commit.engine.rules.common.TypeEnum;
import com.github.javasemantic.domain.model.Commit;
import com.github.javasemantic.domain.model.common.CommitComponents;
import com.github.javasemantic.domain.model.common.Version;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
