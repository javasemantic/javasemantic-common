package io.github.javasemantic.commit.engine.rules.commit.rules.version;

import io.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import io.github.javasemantic.commit.engine.framework.result.RuleResult;
import io.github.javasemantic.commit.engine.framework.rule.VersionRule;
import io.github.javasemantic.domain.model.Commit;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StatefulSemanticVersion extends VersionRule {

  @Override
  public RuleResult execute(Commit commit) {

    commit.getDirtyVersion().addVersion(commit.getTypeEnum());

    return  RuleResult.builder().status(RuleStatusEnum.VALID).build();
  }

}