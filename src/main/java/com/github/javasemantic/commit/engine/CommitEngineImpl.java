package com.github.javasemantic.commit.engine;


import com.github.javasemantic.domain.model.Commit;
import com.github.javasemantic.commit.engine.framework.engine.BasicEngine;
import com.github.javasemantic.commit.engine.framework.rule.CommitPartRule;
import com.github.javasemantic.commit.engine.factory.enums.ConventionalRuleEnum;
import com.github.javasemantic.commit.engine.factory.RuleFactory;
import com.github.javasemantic.commit.engine.factory.enums.StructuralRuleEnum;

import java.util.List;

public class CommitEngineImpl extends BasicEngine<CommitPartRule, Commit> {

    @Override
    public List<CommitPartRule> assignRules() {
        return List.of(
            RuleFactory.getCommitPartRule()
                .setConventionalValidationRule(
                    RuleFactory.get(ConventionalRuleEnum.TYPE_RULE)
                )
                .setStructuralValidationRule(
                    RuleFactory.get(StructuralRuleEnum.TYPE_RULE) // optional null -> not applicable, otherwise applicable
                        .addChild(RuleFactory.get(StructuralRuleEnum.CASING_RULE)) // further structural validation (no need for null check)
                ),

            RuleFactory.getCommitPartRule()
                .setConventionalValidationRule(
                    RuleFactory.get(ConventionalRuleEnum.MESSAGE_RULE)
                )
                .setStructuralValidationRule(
                    RuleFactory.get(StructuralRuleEnum.MESSAGE_RULE) // mandatory -> null = invalid otherwise valid
                        .addChild(RuleFactory.get(StructuralRuleEnum.CASING_RULE)) // further structural validation (no need for null check)
                )
        );
    }

}
