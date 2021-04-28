package com.github.javasemantic.version.manager;

import com.github.javasemantic.domain.DomainFactory;
import com.github.javasemantic.domain.model.Commit;
import com.github.javasemantic.domain.model.common.Version;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class VersionManagerTest {

  @Test
  public void when_calculateProjectVersion_should_return_FinalProjectVersion(){
    var projectData = DomainFactory.getProjectData();
    List<Commit> listOfCommits = new ArrayList<>();
    listOfCommits.add(
        Commit.builder().dirtyVersion(
        new Version(1, 1, 1)
        ).build()
    );
    listOfCommits.add(
        Commit.builder().dirtyVersion(
        new Version(0, 0, 1)
        ).build()
    );
    listOfCommits.add(
        Commit.builder().dirtyVersion(
            new Version(0, 1, 1)
        ).build()
    );
    listOfCommits.add(
        Commit.builder().dirtyVersion(
            new Version(1, 0, 1)
        ).build()
    );
    listOfCommits.add(
        Commit.builder().dirtyVersion(
            new Version(0, 0, 56)
        ).build()
    );
    projectData.setCommits(listOfCommits);
    var versionManager = new VersionManagerImpl();
    var finalTestVersion = versionManager.calculateProjectVersion(projectData);

    assertEquals(2, finalTestVersion.getMajor());
    assertEquals(0,finalTestVersion.getMinor());
    assertEquals(1,finalTestVersion.getPatch());
  }
}
