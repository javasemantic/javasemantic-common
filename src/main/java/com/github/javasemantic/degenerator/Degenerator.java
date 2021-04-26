package com.github.javasemantic.degenerator;

import com.github.javasemantic.domain.model.DirtyCommit;
import com.github.javasemantic.domain.model.common.CommitComponents;

public interface Degenerator {

  CommitComponents degenerate(DirtyCommit commit);

}
