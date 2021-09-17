package io.github.javasemantic.commit.engine;


import io.github.javasemantic.commit.engine.factory.RuleFactory;
import io.github.javasemantic.commit.engine.factory.enums.ConventionalRuleEnum;
import io.github.javasemantic.commit.engine.factory.enums.StructuralRuleEnum;
import io.github.javasemantic.commit.engine.factory.enums.VersionRuleEnum;
import io.github.javasemantic.commit.engine.framework.engine.BasicEngine;
import io.github.javasemantic.commit.engine.framework.rule.PreStructuralValidationRule;
import io.github.javasemantic.commit.engine.framework.rule.common.BasicRule;
import io.github.javasemantic.domain.model.Commit;
import java.util.List;

public class CommitEngineImpl extends BasicEngine<BasicRule<Commit>, Commit> {

  @Override
  public List<BasicRule<Commit>> assignRules() {

    return List.of(
        new PreStructuralValidationRule().setChildrenRules(
            List.of(
                RuleFactory
                    .getCommitPartRule()
                    .setStructuralValidationRule(RuleFactory.get(StructuralRuleEnum.TYPE_RULE))
                    .setConventionalValidationRule(RuleFactory.get(ConventionalRuleEnum.TYPE_RULE))
                    .setVersionRule((RuleFactory.get(VersionRuleEnum.VERSION_RULE_ENUM))),

                RuleFactory
                    .getCommitPartRule()
                    .setStructuralValidationRule(
                        RuleFactory.get(StructuralRuleEnum.OPTIONAL_EXCLAMATION_RULE))
                    .setConventionalValidationRule(
                        RuleFactory.get(ConventionalRuleEnum.BREAKING_EXCLAMATION_RULE))
                    .setVersionRule((RuleFactory.get(VersionRuleEnum.BREAKING_CHANGE_RULE))),

                RuleFactory
                    .getCommitPartRule()
                    .setStructuralValidationRule(
                        RuleFactory.get(StructuralRuleEnum.OPTIONAL_SCOPE_RULE)),

                RuleFactory
                    .getCommitPartRule()
                    .setStructuralValidationRule(RuleFactory.get(StructuralRuleEnum.COLON_RULE)),

                RuleFactory
                    .getCommitPartRule()
                    .setStructuralValidationRule(
                        RuleFactory.get(StructuralRuleEnum.DESCRIPTION_RULE)),

                RuleFactory
                    .getCommitPartRule()
                    .setStructuralValidationRule(RuleFactory.get(StructuralRuleEnum.BODY_RULE))
                    .setConventionalValidationRule(
                        RuleFactory.get(ConventionalRuleEnum.BREAKING_BODY_RULE))
                    .setVersionRule((RuleFactory.get(VersionRuleEnum.BREAKING_CHANGE_RULE)))
            )
        )
    );
  }
}
