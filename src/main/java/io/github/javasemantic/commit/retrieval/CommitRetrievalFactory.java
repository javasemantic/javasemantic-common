package io.github.javasemantic.commit.retrieval;

import java.util.function.Supplier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommitRetrievalFactory {

  private static final Supplier<CommitRetrieval> constructor = JgitCommitRetrievalImpl::new;

  public static CommitRetrieval get() {
    return constructor.get();
  }
}
