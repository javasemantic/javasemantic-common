package com.github.javasemantic.commit.engine.factory.enums;

import com.github.javasemantic.commit.engine.framework.rule.StructuralValidationRule;
import com.github.javasemantic.commit.engine.rules.commit.type.TypeStructuralRule;
import com.github.javasemantic.commit.engine.rules.common.CasingStructuralRule;
import java.util.function.Supplier;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StructuralRuleEnum {

  TYPE_RULE(TypeStructuralRule::new),
  MESSAGE_RULE(TypeStructuralRule::new),
  CASING_RULE(CasingStructuralRule::new);

  private final Supplier<StructuralValidationRule> constructor;
}
