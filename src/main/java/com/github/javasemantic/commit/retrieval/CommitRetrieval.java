package com.github.javasemantic.commit.retrieval;

import com.github.javasemantic.domain.model.DirtyCommit;
import java.util.List;

public interface CommitRetrieval {

  List<DirtyCommit> getCommits();

}
