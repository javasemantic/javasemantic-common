package io.github.javasemantic.logging;

import io.github.javasemantic.logging.common.LogLevel;
import io.github.javasemantic.logging.common.LogObject;
import java.lang.reflect.Type;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Log {

  @Setter
  private static org.apache.maven.plugin.logging.Log mavenLog = null;

  @Setter
  private static LogLevel assignedLevel = LogLevel.INFO;

  public static void warning(Type type, String message) {
    print(create(LogLevel.WARNING, type, message));
  }

  public static void trace(Type type, String message) {
    print(create(LogLevel.TRACE, type, message));
  }

  public static void debug(Type type, String message) {
    print(create(LogLevel.DEBUG, type, message));
  }

  public static void info(Type type, String message) {
    print(create(LogLevel.INFO, type, message));
  }

  public static void error(Type type, String message) {
    print(create(LogLevel.ERROR, type, message));
  }

  private static LogObject create(LogLevel level, Type type, String message) {
    return LogObject
        .builder()
        .level(level)
        .message(message)
        .type(type)
        .build();
  }

  private static void print(LogObject logObject) {
    if (Objects.nonNull(mavenLog)) {
      printMavenPluginLog(logObject);
    } else {
      printHomemadeLog(logObject);
    }
  }

  private static void printHomemadeLog(LogObject logObject) {
    if (logObject.getLevel().getNumericValue() <= assignedLevel.getNumericValue()) {
      System.out.printf(
          "[%s] %s: %s%n",
          logObject.getLevel(),
          logObject.getType(),
          logObject.getMessage()
      );
    }
  }

  private static void printMavenPluginLog(LogObject logObject) {
    var message = String.format(
        "%s: %s",
        logObject.getType(),
        logObject.getMessage()
    );

    switch (logObject.getLevel()) {
      case ERROR:
        mavenLog.error(message);
        break;
      case WARNING:
        mavenLog.warn(message);
        break;
      case INFO:
        mavenLog.info(message);
        break;
      case DEBUG:
      case TRACE:
        mavenLog.debug(message);
        break;
    }
  }
}
