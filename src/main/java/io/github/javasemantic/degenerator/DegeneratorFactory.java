package io.github.javasemantic.degenerator;

import java.util.function.Supplier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DegeneratorFactory {

  private static final Supplier<Degenerator> constructor = DegeneratorImpl::new;

  public static Degenerator get() {
    return constructor.get();
  }
}
