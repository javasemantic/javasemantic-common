package io.github.javasemantic.commit.engine.rules.commit.message;

import io.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import io.github.javasemantic.commit.engine.framework.result.RuleResult;
import io.github.javasemantic.commit.engine.framework.rule.ConventionalValidationRule;
import io.github.javasemantic.domain.model.Commit;

public class MessageConventionalRule extends ConventionalValidationRule {

  @Override
  protected RuleResult run(final Commit commit) {
    return RuleResult
        .builder()
        .status(RuleStatusEnum.VALID)
        .build();
  }

}
