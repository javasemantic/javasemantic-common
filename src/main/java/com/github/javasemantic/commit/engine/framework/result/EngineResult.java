package com.github.javasemantic.commit.engine.framework.result;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EngineResult {

    private List<RuleResult> ruleHistory;

    public boolean isValid() {
        return !this.isInvalid();
    }

    public boolean isInvalid() {
        return ruleHistory
            .stream()
            .anyMatch(RuleResult::isInvalid);
    }

}
