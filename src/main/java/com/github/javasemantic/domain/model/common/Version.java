package com.github.javasemantic.domain.model.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Version {

  private Integer major = 0;
  private Integer minor = 0;
  private Integer patch = 0;

  @Override
  public String toString() {
    return String.format("%d.%d.%d", major, minor, patch);
  }
}
