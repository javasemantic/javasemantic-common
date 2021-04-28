package io.github.javasemantic.commit.engine.rules.commit.rules.structure;

import io.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import io.github.javasemantic.commit.engine.framework.result.RuleResult;
import io.github.javasemantic.commit.engine.framework.rule.StructuralValidationRule;
import io.github.javasemantic.domain.model.Commit;
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