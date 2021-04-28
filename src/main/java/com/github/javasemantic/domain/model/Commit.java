package com.github.javasemantic.domain.model;

import com.github.javasemantic.commit.engine.rules.common.TypeEnum;
import com.github.javasemantic.domain.model.common.CommitComponents;
import com.github.javasemantic.domain.model.common.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class Commit {

  private TypeEnum typeEnum;
  private final Version dirtyVersion;
  private final DirtyCommit dirtyCommit;
  private final CommitComponents commitComponents;

}