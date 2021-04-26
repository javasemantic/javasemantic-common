package com.github.javasemantic.commit.engine.framework.engine;

import com.github.javasemantic.commit.engine.framework.result.EngineResult;
import com.github.javasemantic.commit.engine.framework.result.RuleResult;
import com.github.javasemantic.commit.engine.framework.rule.common.BasicRule;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicEngine<RuleType extends BasicRule<Argument>, Argument> {

    private final List<RuleResult> history = new ArrayList<>();

    public EngineResult execute(final Argument argument) {
        final List<RuleType> rules = this.assignRules();

        for (var rule : rules) {
            rule.setEngine(this);
            var result = rule.execute(argument);
            if (result.isInvalid()) {
                break;
            }
        }

        return createEngineResult();
    }

    private EngineResult createEngineResult() {
        var result = new EngineResult();
        result.setRuleHistory(history);

        return result;
    }

    public void addResultToEngine(RuleResult ruleResult) {
        this.history.add(ruleResult);
    }

    public abstract List<RuleType> assignRules();
}
