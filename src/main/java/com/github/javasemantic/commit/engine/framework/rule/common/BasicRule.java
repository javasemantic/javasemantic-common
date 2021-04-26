package com.github.javasemantic.commit.engine.framework.rule.common;

import com.github.javasemantic.commit.engine.framework.engine.BasicEngine;
import com.github.javasemantic.commit.engine.framework.result.RuleResult;

import lombok.Setter;

public abstract class BasicRule<Argument> {

    @Setter
    protected BasicEngine engine;

    public abstract RuleResult execute(final Argument argument);

}
