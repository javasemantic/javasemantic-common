package com.github.javasemantic.domain.model.common;

import com.github.javasemantic.commit.engine.rules.common.TypeEnum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class VersionTest {

  @Test
  void when_major_should_increase_version() {

    //Given
    Version version = new Version();

    //When
    version.addVersion(TypeEnum.BREAKING_CHANGE);

    //Then
    assertEquals((int) version.getMajor(), 1);
    assertEquals((int) version.getMinor(), 0);
    assertEquals((int) version.getPatch(), 0);
  }

  @Test
  void when_minor_should_increase_version() {

    //Given
    Version version = new Version();

    //When
    version.addVersion(TypeEnum.FEAT);

    //Then
    assertEquals((int) version.getMajor(), 0);
    assertEquals((int) version.getMinor(), 1);
    assertEquals((int) version.getPatch(), 0);
  }

  @Test
  void when_patch_should_increase_version() {

    //Given
    Version version = new Version();

    //When
    version.addVersion(TypeEnum.REFACTOR);

    //Then
    assertEquals((int) version.getMajor(), 0);
    assertEquals((int) version.getMinor(), 0);
    assertEquals((int) version.getPatch(), 1);
  }

  @Test
  void when_none_should_do_nothing() {

    //Given
    Version version = new Version();

    //When
    version.addVersion(TypeEnum.DEPRECATED);

    //Then
    assertEquals((int) version.getMajor(), 0);
    assertEquals((int) version.getMinor(), 0);
    assertEquals((int) version.getPatch(), 0);
  }

}
