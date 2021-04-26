package com.github.javasemantic.commit.engine.rules.commit.type;


import com.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import com.github.javasemantic.commit.engine.framework.result.RuleResult;
import com.github.javasemantic.commit.engine.framework.rule.ConventionalValidationRule;
import com.github.javasemantic.domain.model.Commit;

public class TypeConventionalRule extends ConventionalValidationRule {

  @Override
  protected RuleResult run(final Commit commit) {
    return RuleResult
        .builder()
        .status(RuleStatusEnum.VALID)
        .build();
  }
}
