package io.github.javasemantic.commit.engine.framework.rule;

import io.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import io.github.javasemantic.commit.engine.framework.result.RuleResult;
import io.github.javasemantic.commit.engine.framework.rule.common.ParentRule;
import io.github.javasemantic.domain.model.Commit;
import io.github.javasemantic.utility.ValidConventionalCommitUtil;

public class PreStructuralValidationRule extends ParentRule<Commit> {

  @Override
  protected RuleResult run(Commit commit) {

    var result = RuleResult.builder();

    result.status(ValidConventionalCommitUtil.isValid(commit.getDirtyCommit().getMessage())
        ? RuleStatusEnum.VALID
        : RuleStatusEnum.INVALID);

    return result.build();
  }
}
