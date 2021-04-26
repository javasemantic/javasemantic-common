package com.github.javasemantic.commit.engine.factory.enums;

import com.github.javasemantic.commit.engine.framework.rule.ConventionalValidationRule;
import com.github.javasemantic.commit.engine.rules.commit.message.MessageConventionalRule;
import com.github.javasemantic.commit.engine.rules.commit.type.TypeConventionalRule;

import java.util.function.Supplier;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConventionalRuleEnum {

    TYPE_RULE(TypeConventionalRule::new),
    MESSAGE_RULE(MessageConventionalRule::new);

    private final Supplier<ConventionalValidationRule> constructor;
}
