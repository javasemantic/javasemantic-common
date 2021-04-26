package com.github.javasemantic.commit.engine.rules.commit.message;

import com.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import com.github.javasemantic.domain.model.Commit;
import com.github.javasemantic.commit.engine.framework.result.RuleResult;
import com.github.javasemantic.commit.engine.framework.rule.ConventionalValidationRule;

public class MessageConventionalRule extends ConventionalValidationRule {

    @Override
    protected RuleResult run(final Commit commit) {
      return RuleResult
          .builder()
          .status(RuleStatusEnum.VALID)
          .build();
    }

}
