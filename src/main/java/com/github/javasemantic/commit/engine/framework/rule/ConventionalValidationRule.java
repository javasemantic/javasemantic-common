package com.github.javasemantic.commit.engine.framework.rule;

import com.github.javasemantic.commit.engine.framework.rule.common.ParentRule;
import com.github.javasemantic.domain.model.Commit;

public abstract class ConventionalValidationRule extends ParentRule<Commit> {

  public ConventionalValidationRule addChild(ConventionalValidationRule rule) {
    this.childrenRules.add(rule);
    return this;
  }
}
