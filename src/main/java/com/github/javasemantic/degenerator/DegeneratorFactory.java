package com.github.javasemantic.degenerator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DegeneratorFactory {

    private static final Supplier<Degenerator> constructor = DegeneratorImpl::new;

    public static Degenerator get() {
        return constructor.get();
    }
}
