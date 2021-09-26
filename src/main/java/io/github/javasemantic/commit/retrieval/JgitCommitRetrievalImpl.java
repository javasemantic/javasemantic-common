package io.github.javasemantic.commit.retrieval;

import static io.github.javasemantic.utility.GitRepositoryFactory.createRepository;
import static io.github.javasemantic.utility.GitRepositoryFactory.currentWorkingBranch;

import io.github.javasemantic.domain.model.DirtyCommit;
import io.github.javasemantic.logging.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.FooterLine;
import org.eclipse.jgit.revwalk.RevCommit;

public class JgitCommitRetrievalImpl implements CommitRetrieval {

  private Git git;
  private Repository repository;

  @Override
  public List<DirtyCommit> getCommits() {
    init();
    return createCommits();
  }

  private void init() {
    repository = createRepository();
    git = new Git(repository);
    Log.info(
        this.getClass(),
        String.format(
            "Branch detected: %s",
            currentWorkingBranch(repository)
        ));
  }

  private List<DirtyCommit> createCommits() {

    List<DirtyCommit> dirtyCommits = getDirtyCommits();
    Collections.reverse(dirtyCommits);
    logDetectedCommits(dirtyCommits);

    return dirtyCommits;
  }

  private void logDetectedCommits(final List<DirtyCommit> dirtyCommits) {
    dirtyCommits.forEach(
        printableCommit -> Log.info(this.getClass(), printableCommit.getMessage())
    );
  }

  private List<DirtyCommit> getDirtyCommits() {
    return StreamSupport.stream(getRevCommits().spliterator(),false)
    .map(this::buildDirtyCommit).collect(Collectors.toList());
  }

  private DirtyCommit buildDirtyCommit(final RevCommit commit) {
    return DirtyCommit
        .builder()
        .message(commit.getShortMessage())
        .footers(getFooters(commit.getFooterLines()))
        .build();
  }

  private void logDetectedCommitsToConsole(final List<String> printableCommits) {
    Collections.reverse(printableCommits);

  }

  private List<String> getFooters(List<FooterLine> footerLines) {
    return footerLines
        .stream()
        .map(FooterLine::toString)
        .collect(Collectors.toList());
  }

  private Iterable<RevCommit> getRevCommits() {
    try {
      return git.log().add(repository.resolve(currentWorkingBranch(repository))).call();
    } catch (IOException | GitAPIException e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
