package com.github.javasemantic.commit.engine.framework.rule.common;

import com.github.javasemantic.commit.engine.framework.result.RuleResult;
import java.util.ArrayList;
import java.util.List;

public abstract class ParentRule<Argument> extends BasicRule<Argument> {

  protected final List<BasicRule<Argument>> childrenRules = new ArrayList<>();

  @Override
  public RuleResult execute(final Argument argument) {
    var result = run(argument);

    if (result.isAppliedOrValid()) {
      for (var childRule : childrenRules) {
        childRule.setEngine(engine);
        result = childRule.execute(argument);
        if (result.isInvalid()) {
          break;
        }
      }
    }

    return result;
  }

  protected abstract RuleResult run(final Argument argument);
}
