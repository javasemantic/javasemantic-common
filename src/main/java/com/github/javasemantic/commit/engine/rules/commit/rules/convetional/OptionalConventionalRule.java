package com.github.javasemantic.commit.engine.rules.commit.rules.convetional;

import com.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import com.github.javasemantic.commit.engine.framework.result.RuleResult;
import com.github.javasemantic.commit.engine.framework.rule.ConventionalValidationRule;
import com.github.javasemantic.domain.model.Commit;
import com.github.javasemantic.domain.model.common.CommitComponents;
import java.util.function.Predicate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OptionalConventionalRule extends ConventionalValidationRule {

  private final Predicate<CommitComponents> predicate;

  @Override
  protected RuleResult run(Commit commit) {

    var ruleStatusEnum = RuleStatusEnum.NOT_APPLICABLE;

    if (predicate.test(commit.getCommitComponents())) {
      ruleStatusEnum = RuleStatusEnum.VALID;
    }

    return RuleResult.builder().status(ruleStatusEnum).build();
  }
}