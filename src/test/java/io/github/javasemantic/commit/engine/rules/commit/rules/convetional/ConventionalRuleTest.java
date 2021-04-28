package io.github.javasemantic.commit.engine.rules.commit.rules.convetional;

import io.github.javasemantic.domain.model.Commit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ConventionalRuleTest {

  @Test
  void when_given_valid_commit(){

    //Given
    var rule = new ConventionalRule((a)->true);

    //When
    var actual = rule.execute(Commit.builder().build());

    //Then

    assertTrue(actual.isAppliedOrValid());
  }

  @Test
  void when_given_invalid_commit(){

    //Given
    var rule = new ConventionalRule((a)->false);

    //When
    var actual = rule.execute(Commit.builder().build());

    //Then

    assertTrue(actual.isInvalid());
  }

}
