package com.github.fengshch.mybatis.ext

import com.github.fengshch.mybatis.config.MyBatisConfig;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.model.ObjectFactory;

import javax.inject.Inject;

class MyBatisExtension {

    private final NamedDomainObjectContainer<MyBatisConfig> configurations;

    @Inject
    MyBatisExtension(ObjectFactory objects) {
        this.configurations = objects.domainObjectContainer(MyBatisConfig.class, name -> objects.newInstance(MyBatisConfig.class, name))
    }

    NamedDomainObjectContainer<MyBatisConfig> getConfigurations() {
        return configurations
    }
}
