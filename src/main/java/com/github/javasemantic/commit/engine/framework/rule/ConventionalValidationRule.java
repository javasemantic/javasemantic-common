package com.github.javasemantic.commit.engine.framework.rule;

import com.github.javasemantic.commit.engine.framework.data.object.EngineDataModel;
import com.github.javasemantic.commit.engine.framework.rule.common.ParentRule;

public abstract class ConventionalValidationRule extends ParentRule<EngineDataModel> {

    public ConventionalValidationRule addChild(ConventionalValidationRule rule) {
        this.childrenRules.add(rule);
        return this;
    }
}
