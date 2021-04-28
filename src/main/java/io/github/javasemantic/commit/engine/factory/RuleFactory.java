package io.github.javasemantic.commit.engine.factory;

import io.github.javasemantic.commit.engine.factory.enums.ConventionalRuleEnum;
import io.github.javasemantic.commit.engine.factory.enums.StructuralRuleEnum;
import io.github.javasemantic.commit.engine.factory.enums.VersionRuleEnum;
import io.github.javasemantic.commit.engine.framework.rule.CommitPartRule;
import io.github.javasemantic.commit.engine.framework.rule.ConventionalValidationRule;
import io.github.javasemantic.commit.engine.framework.rule.StructuralValidationRule;
import io.github.javasemantic.commit.engine.framework.rule.VersionRule;
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

  public static VersionRule get(VersionRuleEnum type) {
    return type.getConstructor().get();
  }
}
