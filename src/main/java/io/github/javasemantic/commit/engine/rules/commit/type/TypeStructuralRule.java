package io.github.javasemantic.commit.engine.rules.commit.type;

import io.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import io.github.javasemantic.commit.engine.framework.result.RuleResult;
import io.github.javasemantic.commit.engine.framework.rule.StructuralValidationRule;
import io.github.javasemantic.domain.model.Commit;

public class TypeStructuralRule extends StructuralValidationRule {

  @Override
  protected RuleResult run(final Commit commit) {
    return RuleResult
        .builder()
        .status(RuleStatusEnum.VALID)
        .build();
  }

}
