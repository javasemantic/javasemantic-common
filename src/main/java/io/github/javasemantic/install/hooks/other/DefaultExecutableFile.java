package io.github.javasemantic.install.hooks.other;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class DefaultExecutableFile implements Executable {

  private static final String SHEBANG = "#!/bin/bash";

  private final Path file;

  public DefaultExecutableFile(Path file) throws IOException {

    this.file = file;

    if (!Files.exists(file)) {
      Files.createFile(file);
    }

    setPermissionsForFile(file);
  }

  private void setPermissionsForFile(Path file) throws IOException {
    Set<PosixFilePermission> permissions;
    try {
      permissions = Files.getPosixFilePermissions(file);
    } catch (UnsupportedOperationException ignored) {
      return;
    }

    permissions.add(PosixFilePermission.OWNER_EXECUTE);
    permissions.add(PosixFilePermission.GROUP_EXECUTE);
    permissions.add(PosixFilePermission.OTHERS_EXECUTE);

    Files.setPosixFilePermissions(file, permissions);
  }

  @Override
  public void truncate() throws IOException {
    Files.write(file, Collections.singleton(SHEBANG), StandardOpenOption.TRUNCATE_EXISTING);
  }

  @Override
  public Executable truncateWithTemplate(
      Supplier<InputStream> template, String sourceEncoding, Object... values) throws IOException {

    try (InputStream inputStream = template.get()) {
      String rawContent = IOUtils.toString(inputStream, sourceEncoding);
      Object[] refinedValues = Stream.of(values).map(this::unixifyPath).toArray();
      String content = String.format(rawContent, refinedValues);
      Files.write(file, content.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
    }

    return this;
  }

  @Override
  public Executable appendCommandCall(String commandCall) throws IOException {
    String unixCommandCall = unixifyPath(commandCall, true);
    boolean callExists =
        Files.readAllLines(file).stream().anyMatch(s -> s.contains(unixCommandCall));
    if (callExists) {
    } else {
      Files.write(file, Collections.singletonList(unixCommandCall), StandardOpenOption.APPEND);
    }
    return this;
  }

  @Override
  public Executable removeCommandCall(String commandCall) {
    String unixCommandCall = unixifyPath(commandCall, true);
    try {
      List<String> linesToKeep =
          Files.readAllLines(file).stream()
              .filter(line -> !unixCommandCall.equals(line))
              .collect(Collectors.toList());
      Files.write(file, linesToKeep, StandardOpenOption.TRUNCATE_EXISTING);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return this;
  }

  private String unixifyPath(Object o) {
    return unixifyPath(o, false);
  }

  private String unixifyPath(Object o, boolean force) {

    if (!force && !(o instanceof Path)) {
      return String.valueOf(o);
    }

    String result;
    if (o instanceof Path) {
      Path path = (Path) o;
      result = path.toAbsolutePath().toString();
    } else {
      result = String.valueOf(o);
    }
    return "\"" + StringUtils.replace(result, "\\", "/") + "\"";
  }

}
