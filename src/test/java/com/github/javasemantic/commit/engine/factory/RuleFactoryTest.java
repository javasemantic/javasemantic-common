package com.github.javasemantic.commit.engine.factory;

import com.github.javasemantic.commit.engine.factory.enums.CommitPartRuleEnum;
import com.github.javasemantic.commit.engine.factory.enums.ConventionalRuleEnum;
import com.github.javasemantic.commit.engine.factory.enums.StructuralRuleEnum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class RuleFactoryTest {

    @Test
    public void when_getNewCommitRule_should_returnNewOneEachTime() {
        var ruleOne = RuleFactory.get(CommitPartRuleEnum.TYPE_RULE);
        var ruleTwo = RuleFactory.get(CommitPartRuleEnum.TYPE_RULE);

        System.out.println(ruleOne);
        System.out.println(ruleTwo);

        assertNotEquals(ruleOne.toString(), ruleTwo.toString());
    }

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

}
