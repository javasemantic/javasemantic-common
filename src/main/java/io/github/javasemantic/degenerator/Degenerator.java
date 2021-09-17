package io.github.javasemantic.degenerator;

import io.github.javasemantic.domain.model.DirtyCommit;
import io.github.javasemantic.domain.model.common.CommitComponents;

public interface Degenerator {

  CommitComponents degenerate(DirtyCommit commit);

}
