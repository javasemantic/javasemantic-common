package io.github.javasemantic.install.hooks.other;

import java.util.function.UnaryOperator;

public class TheOriginalFuckUp {
  // File names for hooks:
  private static final String BASE_PLUGIN_PRE_COMMIT_HOOK = "commit-msg";
  private static final String COMMIT_MSG_HOOK_BASE_SCRIPT = "commit-msg";
  // Hook directory name:

  // ?
  private static final String MAVEN_HOME_PROP = "maven.home";

  private final UnaryOperator<String> systemProperties = System::getProperty;

  // Use factory for this:
//  private Executable getOrCreateExecutableScript(Path file) throws IOException {
//    return new DefaultExecutableFile( file);
//  }

//  public void execute() throws MojoExecutionException {
//    // Don't execute if this is not executed in the project's root directory:
//    if (!isExecutionRoot()) {
//      getLog().debug("Not in execution root. Do not execute.");
//      return;
//    }
//    // Install hook:
//    try {
//      getLog().info("Installing git hooks.");
//      doExecute();
//      getLog().info("Installed git hooks.");
//    } catch (Exception e) {
//      throw new MojoExecutionException(e.getMessage(), e);
//    }
//  }

//  private void doExecute() throws IOException {
//    // This uses multiple method to get the jgit repository and then get/create the hooks directory
//    Path hooksDirectory = prepareHooksDirectory();
//    // Write hook files in hook directory
//    writePluginHooks(hooksDirectory, pluginPreCommitHookFileName());
//    writePluginHooks(hooksDirectory, COMMIT_MSG_HOOK_BASE_SCRIPT);
//    //
//    configureHookBaseScripts(hooksDirectory);
//  }

//  private void configureHookBaseScripts(Path hooksDirectory) {
//    getLog().info("Commit message script: " + hooksDirectory
//        .resolve(pluginPreCommitHookFileName()).
//        toFile());
//  }
//
//  private void writePluginHooks(Path hooksDirectory, String fileName) throws IOException {
//    getLog().debug("Writing plugin pre commit hook file");
//    this
//        // This doesn't make sense override always:
//        .getOrCreateExecutableScript(hooksDirectory.resolve(fileName))
//        // Inject values for git hook script
//        // Todo: see how this works:
//        .truncateWithTemplate(
//            () -> getClass().getResourceAsStream("/" + BASE_PLUGIN_PRE_COMMIT_HOOK),
//            StandardCharsets.UTF_8.toString(),
//            this.getMavenExecutable().toAbsolutePath(),
//            pomFile().toAbsolutePath(),
//            mavenCliArguments());
//    getLog().debug("Written plugin pre commit hook file: " + fileName);
//  }

//  private String mavenCliArguments() {
//    Stream<String> propagatedProperties =
//        ofNullable(// inject properties: STring[]]).map(Arrays::asList).orElse(Collections.emptyList())
//            .stream()
//            .filter(prop -> System.getProperty(prop) != null)
//            .map(prop -> "-D" + prop + "=" + System.getProperty(prop));
//
//    Stream<String> properties = Stream.concat(propagatedProperties, Stream.of(// inject properties to add: propertiesToAdd));
//    if (// preCommitHookPipeline inject != null && !// preCommitHookPipeline inject.isEmpty()) {
//      properties = Stream.concat(properties, Stream.of(// preCommitHookPipeline inject));
//    }
//    return properties.collect(Collectors.joining(" "));
//  }
//
//  // Log and get/create hooks directory
//  private Path prepareHooksDirectory() {
//    getLog().debug("Preparing git hook directory");
//    // Get hooks directory
//    Path hooksDirectory = getOrCreateHooksDirectory();
//    getLog().debug("Prepared git hook directory");
//    return hooksDirectory;
//  }
//
//  private String pluginPreCommitHookFileName() {
//    return artifactId() + "." + BASE_PLUGIN_PRE_COMMIT_HOOK;
//  }
//
//  // Uses jgit repository to determine if hooks directory is available otherwise it will create it:
//  private Path getOrCreateHooksDirectory() {
//
//  }

//  public Path getMavenExecutable() {
//    Path mavenHome = Paths.get(systemProperties.apply(MAVEN_HOME_PROP));
//    getLog().info("maven.home=" + mavenHome);
//    Path mavenBinDirectory = mavenHome.resolve("bin");
//    getLog().info(mavenBinDirectory.toString());
//    List<List<NewExecutable>> executableCandidates =
//        Arrays.asList(
//            Arrays.asList(
//                new NewExecutable(mavenBinDirectory, Extension.NONE),
//                new NewExecutable(null, Extension.NONE)),
//            Arrays.asList(
//                new NewExecutable(mavenBinDirectory, Extension.CMD),
//                new NewExecutable(null, Extension.CMD)));
//
//    if (OS.isFamilyWindows()) {
//      Collections.reverse(executableCandidates);
//    }
//
//    return executableCandidates.stream()
//        .flatMap(Collection::stream)
//        .filter(NewExecutable::isValid)
//        .findFirst()
//        .map(NewExecutable::path)
//        .orElseThrow(() -> new RuntimeException("No valid maven executable found !"));
//  }
//
//  private enum Extension {
//    NONE(null),
//    CMD("cmd");
//    private final String value;
//
//    Extension(String value) {
//      this.value = value;
//    }
//  }
//
//  private class NewExecutable {
//
//    private final Path path;
//
//    private NewExecutable(Path prefix, Extension extension) {
//      String name = "mvn";
//
//      if (extension != Extension.NONE) {
//        name += "." + extension.value;
//      }
//      if (prefix != null) {
//        path = prefix.resolve(name);
//      } else {
//        path = Paths.get(name);
//      }
//    }
//
//    Path path() {
//      return path;
//    }
//
//    boolean isValid() {
//      try {
//        getLog().info("Checking if maven is valid: " + path.toString());
//        CommandRunner commandRunner = new DefaultCommandRunner(getLog());
//        commandRunner.run(null, path.toString(), "--version");
//        return true;
//      } catch (Exception e) {
//        getLog().debug(e.getMessage());
//      }
//      return false;
//    }
//  }



}
