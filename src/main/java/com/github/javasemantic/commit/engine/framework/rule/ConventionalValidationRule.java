package com.github.javasemantic.commit.engine.framework.rule;

import com.github.javasemantic.domain.model.Commit;
import com.github.javasemantic.commit.engine.framework.rule.common.ParentRule;

public abstract class ConventionalValidationRule extends ParentRule<Commit> {

    public ConventionalValidationRule addChild(ConventionalValidationRule rule) {
        this.childrenRules.add(rule);
        return this;
    }
}
