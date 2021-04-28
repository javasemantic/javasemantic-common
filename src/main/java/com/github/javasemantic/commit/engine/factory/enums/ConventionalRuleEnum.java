package com.github.javasemantic.commit.engine.factory.enums;

import com.github.javasemantic.commit.engine.framework.rule.ConventionalValidationRule;
import com.github.javasemantic.commit.engine.rules.commit.rules.convetional.OptionalConventionalRule;
import com.github.javasemantic.commit.engine.rules.commit.rules.convetional.TypeConventionalRule;
import java.util.function.Supplier;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ConventionalRuleEnum {

  TYPE_RULE(TypeConventionalRule::new),

  BREAKING_CHANGE_RULE(() -> new OptionalConventionalRule((commitComponent) ->
      "!".equals(commitComponent.getExclamation()) || (commitComponent.getBody() != null
          && commitComponent.getBody().contains("BREAKING CHANGE"))
  ));

  @Getter
  private final Supplier<ConventionalValidationRule> constructor;

}
