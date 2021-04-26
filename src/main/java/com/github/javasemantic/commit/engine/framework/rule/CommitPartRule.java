package com.github.javasemantic.commit.engine.framework.rule;

import com.github.javasemantic.commit.engine.framework.data.object.EngineDataModel;
import com.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import com.github.javasemantic.commit.engine.framework.result.RuleResult;
import com.github.javasemantic.commit.engine.framework.rule.common.BasicRule;

import java.util.Objects;

public class CommitPartRule extends BasicRule<EngineDataModel> {

    private ConventionalValidationRule conventionalValidationRule;
    private StructuralValidationRule structuralValidationRule;
    private VersionRule versionRule;

    private RuleResult ruleResult = RuleResult
        .builder()
        .status(RuleStatusEnum.NOT_APPLICABLE)
        .build();

    public RuleResult execute(final EngineDataModel engineDataModel) {
        executeAssociatedRule(structuralValidationRule, engineDataModel);
        executeAssociatedRule(conventionalValidationRule, engineDataModel);
        executeAssociatedRule(versionRule, engineDataModel);

        return ruleResult;
    }

    private void executeAssociatedRule(BasicRule<EngineDataModel> associatedRule,
                                       final EngineDataModel engineDataModel) {
        if (Objects.nonNull(associatedRule)) {
            if (ruleResult.isAppliedOrValid() || ruleResult.isNotApplicable()) {
                ruleResult = associatedRule.execute(engineDataModel);
            }
        }
    }

    public CommitPartRule setConventionalValidationRule(final ConventionalValidationRule conventionalValidationRule) {
        this.conventionalValidationRule = conventionalValidationRule;
        return this;
    }

    public CommitPartRule setStructuralValidationRule(final StructuralValidationRule structuralValidationRule) {
        this.structuralValidationRule = structuralValidationRule;
        return this;
    }

    public CommitPartRule setVersionRule(final VersionRule versionRule) {
        this.versionRule = versionRule;
        return this;
    }

}
