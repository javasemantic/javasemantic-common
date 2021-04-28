package com.github.javasemantic.commit.engine.factory;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.javasemantic.commit.engine.factory.enums.ConventionalRuleEnum;
import com.github.javasemantic.commit.engine.factory.enums.StructuralRuleEnum;
import com.github.javasemantic.commit.engine.factory.enums.VersionRuleEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RuleFactoryTest {

  @Test
  public void when_getNewStructuralRule_should_returnNewOneEachTime() {
    var ruleOne = RuleFactory.get(StructuralRuleEnum.TYPE_RULE);
    var ruleTwo = RuleFactory.get(StructuralRuleEnum.TYPE_RULE);

    System.out.println(ruleOne);
    System.out.println(ruleTwo);

    assertNotEquals(ruleOne.toString(), ruleTwo.toString());
  }

  @Test
  public void when_getNewConventionalRule_should_returnNewOneEachTime() {

    var ruleOne = RuleFactory.get(ConventionalRuleEnum.TYPE_RULE);
    var ruleTwo = RuleFactory.get(ConventionalRuleEnum.TYPE_RULE);

    System.out.println(ruleOne);
    System.out.println(ruleTwo);

    assertNotEquals(ruleOne.toString(), ruleTwo.toString());
  }

  @Test
  public void when_getNewVersionRule_should_returnNewOneEachTime() {

    var ruleOne = RuleFactory.get(VersionRuleEnum.BREAKING_CHANGE_RULE);
    var ruleTwo = RuleFactory.get(VersionRuleEnum.BREAKING_CHANGE_RULE);

    System.out.println(ruleOne);
    System.out.println(ruleTwo);

    assertNotEquals(ruleOne.toString(), ruleTwo.toString());
  }

}
