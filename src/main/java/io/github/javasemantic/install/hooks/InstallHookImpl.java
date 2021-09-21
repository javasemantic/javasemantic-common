package io.github.javasemantic.install.hooks;

import io.github.javasemantic.git.GitFactory;
import io.github.javasemantic.install.hooks.model.InstallHookArguments;
import io.github.javasemantic.install.hooks.other.DefaultExecutableFile;
import io.github.javasemantic.install.hooks.other.Executable;
import io.github.javasemantic.logging.Log;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class InstallHookImpl implements InstallHook {

  private static final String BASE_PLUGIN_PRE_COMMIT_HOOK = "commit-msg";

  @Override
  public void execute(InstallHookArguments installHookArguments) throws IOException {

    Log.info(this.getClass(), "Check if executing from project's root directory.");

    if (!installHookArguments.isExecutionRoot()) {
      throw new RuntimeException("Not executing from project's root directory.");
    }

    var gitHookDirectory = GitFactory.get().getGitHookPath();

    createPluginHookFile(
        gitHookDirectory,
        BASE_PLUGIN_PRE_COMMIT_HOOK,
        BASE_PLUGIN_PRE_COMMIT_HOOK,
        installHookArguments);

  }

  private void createPluginHookFile(
      Path gitHookDirectory,
      String resourceFile,
      String fileDirectory,
      InstallHookArguments installHookArguments) throws IOException {

    Executable executable = new DefaultExecutableFile(gitHookDirectory.resolve(fileDirectory));
    executable.truncateWithTemplate(
        () -> getClass().getResourceAsStream("/" + resourceFile),
        StandardCharsets.UTF_8.toString(),
        installHookArguments.getBuildToolAbsolutePath(),
        installHookArguments.getProjectBuildFile());

  }

}
