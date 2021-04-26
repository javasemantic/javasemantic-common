package com.github.javasemantic.domain.model;

import com.github.javasemantic.domain.DomainFactory;
import com.github.javasemantic.domain.model.common.Version;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProjectData {

    private final Version projectVersion = DomainFactory.getVersion();
    private final List<Commit> commits = new ArrayList<>();

}
