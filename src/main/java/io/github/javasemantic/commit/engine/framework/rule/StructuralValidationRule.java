package io.github.javasemantic.commit.engine.framework.rule;

import io.github.javasemantic.commit.engine.framework.rule.common.ParentRule;
import io.github.javasemantic.domain.model.Commit;

public abstract class StructuralValidationRule extends ParentRule<Commit> {

  public StructuralValidationRule addChild(StructuralValidationRule rule) {
    this.childrenRules.add(rule);
    return this;
  }

}
