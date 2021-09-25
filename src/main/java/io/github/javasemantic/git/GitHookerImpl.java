package io.github.javasemantic.git;

import io.github.javasemantic.logging.Log;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;

public class GitHookerImpl implements GitHooker {

  private static final String GIT_DIR = ".git";
  private static final String HOOKS_DIR = "hooks";

  @Override
  public Path getGitHookPath() {
    var hooksDirectory = getGitRepository().getDirectory().toPath().resolve(HOOKS_DIR);

    if (!Files.exists(hooksDirectory)) {
      Log.info(this.getClass(),
          "Git hook directory doesn't exist, creating directory " + hooksDirectory);
      try {
        Files.createDirectories(hooksDirectory);
      } catch (IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }

    return hooksDirectory;
  }

  @Override
  public Repository getGitRepository() {

    //    Repository gitRepository;
    //    try {
    //      FileRepositoryBuilder repositoryBuilder =
    //          new FileRepositoryBuilder().findGitDir(// inject base directory);
    //              String gitIndexFileEnvVariable = System.getenv("GIT_INDEX_FILE");
    //      if (StringUtils.isNotBlank(gitIndexFileEnvVariable)) {
    //        repositoryBuilder = repositoryBuilder.setIndexFile(new File(gitIndexFileEnvVariable));
    //      }
    //      gitRepository = repositoryBuilder.build();
    //    } catch (IOException e) {
    //      throw new RuntimeException(
    //          "Could not find the git repository. Run 'git init' if you did not.", e);
    //    }
    //    return gitRepository;

    try {
      return new FileRepository(GIT_DIR);
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }

  }

  @Override
  public void addBuildFileToGit(String buildFileName) {
    try {
      var git = Git.init().setDirectory(new File(GIT_DIR)).call();
      git.add().addFilepattern(buildFileName).setUpdate(true).call();
    } catch (GitAPIException e) {
      throw new RuntimeException("Failed to add to commit.");
    }
  }

}
