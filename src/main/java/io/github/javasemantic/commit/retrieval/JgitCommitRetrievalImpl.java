package io.github.javasemantic.commit.retrieval;

import io.github.javasemantic.domain.model.DirtyCommit;
import io.github.javasemantic.logging.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.FooterLine;
import org.eclipse.jgit.revwalk.RevCommit;

public class JgitCommitRetrievalImpl implements CommitRetrieval {

  private static final String GIT = ".git";

  private Git git;
  private Repository repository;

  @Override
  public List<DirtyCommit> getCommits() {
    init();
    return createCommits();
  }

  private List<DirtyCommit> createCommits() {
    List<DirtyCommit> dirtyCommits = new ArrayList<>();
    List<String> printableCommits = new ArrayList<>();

    for (var commit : getRevCommits()) {
      printableCommits.add(String.format("Commit detected: %s", commit.getShortMessage()));
      dirtyCommits.add(DirtyCommit
          .builder()
          .message(commit.getShortMessage())
          .footers(getFooters(commit.getFooterLines()))
          .build()
      );
    }

    Collections.reverse(dirtyCommits);
    Collections.reverse(printableCommits);

    printableCommits.forEach(
        printableCommit -> Log.info(this.getClass(), printableCommit)
    );

    return dirtyCommits;
  }

  private List<String> getFooters(List<FooterLine> footerLines) {
    return footerLines
        .stream()
        .map(FooterLine::toString)
        .collect(Collectors.toList());
  }

  private void init() {
    repository = createRepository();
    git = new Git(repository);
    try {
      Log.info(
          this.getClass(),
          String.format("Branch detected: %s", repository.getFullBranch())
      );
    } catch (Exception e) {
      throw new RuntimeException("Can't retrieve branch name.");
    }
  }

  private Repository createRepository() {
    try {
      return new FileRepository(GIT);
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  private Iterable<RevCommit> getRevCommits() {
    try {
      return git.log().add(repository.resolve(repository.getFullBranch())).call();
    } catch (IOException | GitAPIException e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
