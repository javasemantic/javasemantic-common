package io.github.javasemantic.logging.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LogLevel {
  ERROR(1),
  WARNING(2),
  INFO(3),
  DEBUG(4),
  TRACE(5);

  private final int numericValue;
}
