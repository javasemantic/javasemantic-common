package com.github.javasemantic.degenerator;

import com.github.javasemantic.domain.model.common.CommitComponents;

public interface Degenerator {

    CommitComponents degenerate(String commit);

}
