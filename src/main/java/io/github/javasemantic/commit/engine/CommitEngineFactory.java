package io.github.javasemantic.commit.engine;

import io.github.javasemantic.domain.model.Commit;
import java.util.function.Supplier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommitEngineFactory {

  private static final Supplier<CommitEngine<Commit>> constructor = CommitEngineImpl::new;

  public static CommitEngine<Commit> get() {
    return constructor.get();
  }
}
