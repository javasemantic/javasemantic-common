package com.github.javasemantic.commit.engine.framework.rule;

import com.github.javasemantic.domain.model.Commit;
import com.github.javasemantic.commit.engine.framework.rule.common.ParentRule;

public abstract class StructuralValidationRule extends ParentRule<Commit> {

    public StructuralValidationRule addChild(StructuralValidationRule rule) {
        this.childrenRules.add(rule);
        return this;
    }

}
