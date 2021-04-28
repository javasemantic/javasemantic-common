package io.github.javasemantic.commit.engine;

import io.github.javasemantic.commit.engine.framework.result.EngineResult;

public interface CommitEngine<Argument> {

  EngineResult execute(final Argument argument);

}
