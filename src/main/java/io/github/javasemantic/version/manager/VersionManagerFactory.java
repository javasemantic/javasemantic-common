package io.github.javasemantic.version.manager;

import java.util.function.Supplier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VersionManagerFactory {

  private static final Supplier<VersionManager> constructor = VersionManagerImpl::new;

  public static VersionManager get() {
    return constructor.get();
  }
}
