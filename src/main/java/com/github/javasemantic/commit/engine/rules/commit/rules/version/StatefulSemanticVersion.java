package com.github.javasemantic.commit.engine.rules.commit.rules.version;

import com.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import com.github.javasemantic.commit.engine.framework.result.RuleResult;
import com.github.javasemantic.commit.engine.framework.rule.VersionRule;
import com.github.javasemantic.commit.engine.rules.common.TypeEnum;
import com.github.javasemantic.domain.model.Commit;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StatefulSemanticVersion extends VersionRule {

  @Override
  public RuleResult execute(Commit commit) {

    commit.getDirtyVersion().addVersion(commit.getTypeEnum());

    return  RuleResult.builder().status(RuleStatusEnum.VALID).build();
  }

}