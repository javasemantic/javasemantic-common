package io.github.javasemantic.git;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GitFactory {

  private static final Supplier<GitHooker> constructor = GitHookerImpl::new;

  public static GitHooker get() {
    return constructor.get();
  }

}
