package com.github.javasemantic.domain.model.common;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommitComponents {

  private String type;
  private boolean exclamation;
  private String scope;
  private boolean colon;
  private boolean whitespace;
  private String description;
  private String body;

}
