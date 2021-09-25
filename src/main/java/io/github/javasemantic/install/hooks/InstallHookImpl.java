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

  private static final String COMMIT_MSG = "commit-msg";
  private static final String POST_COMMIT = "post-commit";

  @Override
  public void execute(InstallHookArguments installHookArguments) throws IOException {

    Log.info(this.getClass(), "Check if executing from project's root directory.");

    if (!installHookArguments.isExecutionRoot()) {
      throw new RuntimeException("Not executing from project's root directory.");
    }

    var gitHookDirectory = GitFactory.get().getGitHookPath();

    installCommitMsgHook(installHookArguments, gitHookDirectory);
    installPostCommitHook(installHookArguments, gitHookDirectory);
  }

  private void installCommitMsgHook(InstallHookArguments installHookArguments,
                                    Path gitHookDirectory) throws IOException {
    Executable executable = new DefaultExecutableFile(gitHookDirectory.resolve(COMMIT_MSG));
    executable.truncateWithTemplate(
        () -> getClass().getResourceAsStream("/" + COMMIT_MSG),
        StandardCharsets.UTF_8.toString(),
        installHookArguments.getBuildToolAbsolutePath(),
        installHookArguments.getProjectBuildFile(),
        installHookArguments.getProjectBaseDirectory()
    );
  }

  private void installPostCommitHook(InstallHookArguments installHookArguments,
                                     Path gitHookDirectory) throws IOException {
    Executable executable = new DefaultExecutableFile(gitHookDirectory.resolve(POST_COMMIT));
    executable.truncateWithTemplate(
        () -> getClass().getResourceAsStream("/" + POST_COMMIT),
        StandardCharsets.UTF_8.toString(),
        installHookArguments.getProjectBaseDirectory(),
        installHookArguments.getBuildFileName()
    );
  }

}
