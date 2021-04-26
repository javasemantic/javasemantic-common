package com.github.javasemantic.commit.engine.framework.result;

import com.github.javasemantic.commit.engine.framework.enums.RuleStatusEnum;
import lombok.Builder;

@Builder
public class RuleResult {

  private RuleStatusEnum status;

  public boolean isAppliedOrValid() {
    return status.equals(RuleStatusEnum.APPLIED) || status.equals(RuleStatusEnum.VALID);
  }

  public boolean isNotApplicable() {
    return status.equals(RuleStatusEnum.NOT_APPLICABLE);
  }

  public boolean isInvalid() {
    return status.equals(RuleStatusEnum.INVALID);
  }

}
