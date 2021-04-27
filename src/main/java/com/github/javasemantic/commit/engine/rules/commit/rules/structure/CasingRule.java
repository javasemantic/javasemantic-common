package com.github.javasemantic.commit.engine.rules.commit.rules.structure;

import com.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import com.github.javasemantic.commit.engine.framework.result.RuleResult;
import com.github.javasemantic.commit.engine.framework.rule.StructuralValidationRule;
import com.github.javasemantic.domain.model.Commit;
import java.util.function.Predicate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CasingRule extends StructuralValidationRule {

  private final Predicate<Commit> predicate;

  @Override
  protected RuleResult run(Commit commit) {

    var status = RuleStatusEnum.INVALID;

    if (predicate.test(commit)) {
      status = RuleStatusEnum.VALID;
    }

    return RuleResult.builder().status(status).build();
  }
}