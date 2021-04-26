package com.github.javasemantic.version.manager;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VersionManagerFactory {

    private static final Supplier<VersionManager> constructor = VersionManagerImpl::new;

    public static VersionManager get() {
        return constructor.get();
    }
}
