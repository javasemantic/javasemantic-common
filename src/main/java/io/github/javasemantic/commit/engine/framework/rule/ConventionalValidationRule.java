package io.github.javasemantic.commit.engine.framework.rule;

import io.github.javasemantic.commit.engine.framework.rule.common.ParentRule;
import io.github.javasemantic.domain.model.Commit;

public abstract class ConventionalValidationRule extends ParentRule<Commit> {

  public ConventionalValidationRule addChild(ConventionalValidationRule rule) {
    this.childrenRules.add(rule);
    return this;
  }
}
