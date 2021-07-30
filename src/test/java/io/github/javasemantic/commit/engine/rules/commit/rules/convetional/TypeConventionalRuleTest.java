package io.github.javasemantic.commit.engine.rules.commit.rules.convetional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.javasemantic.commit.engine.rules.common.TypeEnum;
import io.github.javasemantic.domain.model.Commit;
import io.github.javasemantic.domain.model.common.CommitComponents;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TypeConventionalRuleTest {

  @Test
  void when_given_valid_commit() {

    //Given
    var rule = new TypeConventionalRule();
    var commit =
        Commit.builder().commitComponents(CommitComponents.builder().type("feat").build()).build();

    //When
    var actual = rule.execute(commit);

    //Then

    assertEquals(TypeEnum.FEAT, commit.getTypeEnum());
    assertTrue(actual.isAppliedOrValid());
  }

  @Test
  void when_given_isInvalid_commit() {

    //Given
    var rule = new TypeConventionalRule();
    var commit =
        Commit.builder().commitComponents(CommitComponents.builder().type("booo").build()).build();

    //When
    var actual = rule.execute(commit);

    //Then
    assertTrue(actual.isInvalid());
  }

}
