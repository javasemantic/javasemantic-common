package io.github.javasemantic.commit.engine.framework.rule;

import io.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import io.github.javasemantic.commit.engine.framework.result.RuleResult;
import io.github.javasemantic.commit.engine.framework.rule.common.ParentRule;
import io.github.javasemantic.domain.model.Commit;
import io.github.javasemantic.utility.ValidConventionalCommitUtil;

public class PreStructuralValidationRule extends ParentRule<Commit> {

  @Override
  protected RuleResult run(Commit commit) {

    var resultBuilder = RuleResult.builder();

    resultBuilder.status(ValidConventionalCommitUtil.isValid(commit.getDirtyCommit().getMessage())
        ? RuleStatusEnum.VALID
        : RuleStatusEnum.INVALID);

    var result = resultBuilder
        .ruleName("Pre-structural Validation Rule")
        .build();

    engine.addResultToEngine(result);

    return result;
  }
}
