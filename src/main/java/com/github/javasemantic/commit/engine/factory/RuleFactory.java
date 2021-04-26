package com.github.javasemantic.commit.engine.factory;

import com.github.javasemantic.commit.engine.factory.enums.ConventionalRuleEnum;
import com.github.javasemantic.commit.engine.factory.enums.StructuralRuleEnum;
import com.github.javasemantic.commit.engine.framework.rule.CommitPartRule;
import com.github.javasemantic.commit.engine.framework.rule.ConventionalValidationRule;
import com.github.javasemantic.commit.engine.framework.rule.StructuralValidationRule;

import java.util.function.Supplier;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RuleFactory {

    private static final Supplier<CommitPartRule> commitPartRuleConstructor = CommitPartRule::new;

    public static CommitPartRule getCommitPartRule() {
        return commitPartRuleConstructor.get();
    }

    public static ConventionalValidationRule get(ConventionalRuleEnum type) {
        return type.getConstructor().get();
    }

    public static StructuralValidationRule get(StructuralRuleEnum type) {
        return type.getConstructor().get();
    }
}
