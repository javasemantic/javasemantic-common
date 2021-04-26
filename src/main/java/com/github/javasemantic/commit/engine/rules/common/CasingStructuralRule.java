package com.github.javasemantic.commit.engine.rules.common;

import com.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import com.github.javasemantic.commit.engine.framework.result.RuleResult;
import com.github.javasemantic.commit.engine.framework.rule.StructuralValidationRule;
import com.github.javasemantic.domain.model.Commit;

public class CasingStructuralRule extends StructuralValidationRule {

  @Override
  protected RuleResult run(final Commit commit) {
    return RuleResult
        .builder()
        .status(RuleStatusEnum.VALID)
        .build();
  }

}
