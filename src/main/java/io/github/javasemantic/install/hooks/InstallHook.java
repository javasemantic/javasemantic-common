package io.github.javasemantic.install.hooks;

import io.github.javasemantic.install.hooks.model.InstallHookArguments;
import java.io.IOException;

public interface InstallHook {

  void execute(InstallHookArguments installHookArguments) throws IOException;

}
