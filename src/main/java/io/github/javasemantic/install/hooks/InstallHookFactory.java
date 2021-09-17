package io.github.javasemantic.install.hooks;

import java.util.function.Supplier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InstallHookFactory {

  private static final Supplier<InstallHook> constructor = InstallHookImpl::new;

  public static InstallHook get() {
    return constructor.get();
  }

}
