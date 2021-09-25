package io.github.javasemantic.version.updater;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VersionUpdaterFactory {

  public static VersionUpdater getMavenVersionUpdater(){
    return new MavenVersionUpdater();
  }

}
