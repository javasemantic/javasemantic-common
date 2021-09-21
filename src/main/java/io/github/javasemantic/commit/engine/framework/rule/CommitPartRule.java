package io.github.javasemantic.commit.engine.framework.rule;

import io.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import io.github.javasemantic.commit.engine.framework.result.RuleResult;
import io.github.javasemantic.commit.engine.framework.rule.common.BasicRule;
import io.github.javasemantic.domain.model.Commit;
import java.util.Objects;

public class CommitPartRule extends BasicRule<Commit> {

  private ConventionalValidationRule conventionalValidationRule;
  private StructuralValidationRule structuralValidationRule;
  private VersionRule versionRule;

  private RuleResult ruleResult = RuleResult
      .builder()
      .status(RuleStatusEnum.NOT_APPLICABLE)
      .build();

  @Override
  public RuleResult execute(final Commit commit) {
    executeAssociatedRule(structuralValidationRule, commit);
    executeAssociatedRule(conventionalValidationRule, commit);
    executeAssociatedVersionRule(versionRule, commit);

    return ruleResult;
  }

  private void executeAssociatedRule(BasicRule<Commit> associatedRule,
      final Commit commit) {
    if (Objects.nonNull(associatedRule)) {
      if (ruleResult.isAppliedOrValid() || ruleResult.isNotApplicable()) {
        associatedRule.setEngine(engine);
        ruleResult = associatedRule.execute(commit);
      }
    }
  }

  private void executeAssociatedVersionRule(BasicRule<Commit> associatedRule,
      final Commit commit) {
    if (Objects.nonNull(associatedRule)) {
      if (ruleResult.isAppliedOrValid()) {
        associatedRule.setEngine(engine);
        ruleResult = associatedRule.execute(commit);
      }
    }
  }

  public CommitPartRule setConventionalValidationRule(
      final ConventionalValidationRule conventionalValidationRule) {
    this.conventionalValidationRule = conventionalValidationRule;
    return this;
  }

  public CommitPartRule setStructuralValidationRule(
      final StructuralValidationRule structuralValidationRule) {
    this.structuralValidationRule = structuralValidationRule;
    return this;
  }

  public CommitPartRule setVersionRule(final VersionRule versionRule) {
    this.versionRule = versionRule;
    return this;
  }

}
