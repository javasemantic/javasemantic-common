package io.github.javasemantic.domain.model;

import java.util.List;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DirtyCommit {

  private final String message;
  private final List<String> footers;

}
