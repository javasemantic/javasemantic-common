package com.github.javasemantic.domain.model.common;

import com.github.javasemantic.commit.engine.rules.common.TypeEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.github.javasemantic.commit.engine.rules.common.ReleaseEnum.MAJOR;
import static com.github.javasemantic.commit.engine.rules.common.ReleaseEnum.MINOR;
import static com.github.javasemantic.commit.engine.rules.common.ReleaseEnum.PATCH;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
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

  public void addVersion(TypeEnum typeEnum) {
    if (MAJOR.equals(typeEnum.getRelease())) {
      this.major += 1;
    } else if (MINOR.equals(typeEnum.getRelease())) {
      this.minor += 1;
    } else if (PATCH.equals(typeEnum.getRelease())) {
      this.patch += 1;
    }
  }
}
