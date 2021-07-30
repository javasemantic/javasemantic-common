package io.github.javasemantic.commit.engine.rules.commit.rules.structure;

import io.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import io.github.javasemantic.commit.engine.framework.result.RuleResult;
import io.github.javasemantic.commit.engine.framework.rule.StructuralValidationRule;
import io.github.javasemantic.domain.model.Commit;
import io.github.javasemantic.domain.model.common.CommitComponents;
import java.util.function.Predicate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StructuralRule extends StructuralValidationRule {

  private final Predicate<CommitComponents> predicate;

  @Override
  protected RuleResult run(Commit commit) {

    var status = predicate.test(commit.getCommitComponents())
        ? RuleStatusEnum.VALID
        : RuleStatusEnum.INVALID;

    return RuleResult.builder().status(status).build();
  }
}