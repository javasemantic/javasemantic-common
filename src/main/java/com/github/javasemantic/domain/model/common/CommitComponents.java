package com.github.javasemantic.domain.model.common;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommitComponents {

  private String type;
  private String exclamation;
  private String scope;
  private String colon;
  private boolean whitespace;
  private String description;
  private String body;

}
