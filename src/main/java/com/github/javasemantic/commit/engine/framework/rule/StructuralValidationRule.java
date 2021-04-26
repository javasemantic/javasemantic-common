package com.github.javasemantic.commit.engine.framework.rule;

import com.github.javasemantic.commit.engine.framework.data.object.EngineDataModel;
import com.github.javasemantic.commit.engine.framework.rule.common.ParentRule;

public abstract class StructuralValidationRule extends ParentRule<EngineDataModel> {

    public StructuralValidationRule addChild(StructuralValidationRule rule) {
        this.childrenRules.add(rule);
        return this;
    }

}
