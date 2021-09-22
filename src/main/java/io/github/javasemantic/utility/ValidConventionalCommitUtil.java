package io.github.javasemantic.utility;

import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidConventionalCommitUtil {

  public static boolean isValid(final String message) {
    return Pattern.matches(
        "^(build|chore|ci|docs|feat|feature|fix|perf|refactor|revert|style|test)?!?(\\([a-z ]+\\))?: .*",
        message);
  }

  public static String VALID_LOG_MESSAGE = "The commit message meets the Conventional Commit standard.";

  public static String INVALID_LOG_MESSAGE = "\nThe commit message does not meet the Conventional " +
                                             "Commit standard\nAn example of a valid message is:" +
                                             "\n\tfeat(login): add the 'remember me' button\nMore " +
                                             "details at: https://www.conventionalcommits.org/en/v1.0.0/#summary";

}
