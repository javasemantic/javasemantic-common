package com.github.javasemantic.commit.engine;

import com.github.javasemantic.domain.model.Commit;
import com.github.javasemantic.version.manager.VersionManager;
import com.github.javasemantic.version.manager.VersionManagerImpl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommitEngineFactory {

    private static final Supplier<CommitEngine<Commit>> constructor = CommitEngineImpl::new;

    public static CommitEngine<Commit> get() {
        return constructor.get();
    }
}
