package com.github.javasemantic.commit.engine.rules.commit.type;

import com.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import com.github.javasemantic.domain.model.Commit;
import com.github.javasemantic.commit.engine.framework.result.RuleResult;
import com.github.javasemantic.commit.engine.framework.rule.StructuralValidationRule;

public class TypeStructuralRule extends StructuralValidationRule {

    @Override
    protected RuleResult run(final Commit commit) {
      return RuleResult
          .builder()
          .status(RuleStatusEnum.VALID)
          .build();
    }

}
