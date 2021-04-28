package com.github.javasemantic.commit.engine.rules.commit.rules.convetional;

import com.github.javasemantic.commit.engine.rules.commit.type.TypeRuleEnum;
import com.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import com.github.javasemantic.commit.engine.framework.result.RuleResult;
import com.github.javasemantic.commit.engine.framework.rule.ConventionalValidationRule;
import com.github.javasemantic.domain.model.Commit;
import java.util.Arrays;
import java.util.Optional;


public class TypeConventionalRule extends ConventionalValidationRule {

  @Override
  protected RuleResult run(Commit commit) {

    var ruleStatusEnum = RuleStatusEnum.INVALID;

    Optional<TypeRuleEnum> answer =
        Arrays.stream(TypeRuleEnum.values())
        .filter(type -> type.evaluate(commit.getCommitComponents()))
        .findAny();

    if (answer.isPresent()) {
      commit.setTypeEnum(answer.get().getTypeEnum());
      ruleStatusEnum = RuleStatusEnum.VALID;
    }

    return RuleResult.builder().status(ruleStatusEnum).build();
  }

}
