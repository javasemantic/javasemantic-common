package io.github.javasemantic.git;

import java.nio.file.Path;
import org.eclipse.jgit.lib.Repository;

public interface GitHooker {

  Path getGitHookPath();

  Repository getGitRepository();

}
