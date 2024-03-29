package io.github.javasemantic.commit.engine.rules.commit.rules.structure;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.javasemantic.domain.model.Commit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OptionalStructuralRuleTest {

  @Test
  void when_given_valid_commit() {

    //Given
    var rule = new OptionalStructuralRule((a) -> true);

    //When
    var actual = rule.run(Commit.builder().build());

    //Then

    assertTrue(actual.isAppliedOrValid());
  }

  @Test
  void when_given_notApplicable_commit() {

    //Given
    var rule = new OptionalStructuralRule((a) -> false);

    //When
    var actual = rule.run(Commit.builder().build());

    //Then

    assertTrue(actual.isNotApplicable());
  }

}
