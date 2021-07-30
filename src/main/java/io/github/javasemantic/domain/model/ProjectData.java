package io.github.javasemantic.domain.model;

import io.github.javasemantic.domain.DomainFactory;
import io.github.javasemantic.domain.model.common.Version;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ProjectData {

  private Version projectVersion = DomainFactory.getVersion();
  private List<Commit> commits = new ArrayList<>();

}
