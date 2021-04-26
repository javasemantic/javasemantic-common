package com.github.javasemantic.commit.retrieval;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommitRetrievalFactory {

    private static final Supplier<CommitRetrieval> constructor = JgitCommitRetrievalImpl::new;

    public static CommitRetrieval get() {
        return constructor.get();
    }
}
