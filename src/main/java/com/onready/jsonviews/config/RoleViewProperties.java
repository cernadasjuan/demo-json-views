package com.onready.jsonviews.config;

import com.onready.jsonviews.view.RoleView;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Component
@ConfigurationProperties(prefix = "view")
public class RoleViewProperties {

    private static final List<Class> viewClasses = Arrays.asList(RoleView.class.getDeclaredClasses());
    private final Properties role = new Properties();

    public Properties getRole() {
        return role;
    }

    public Class getView(String key) throws ClassNotFoundException {
        String roleName = role.getProperty(key.split("_")[1]);
        return viewClasses.stream().filter(viewClass -> viewClass.getSimpleName().equals(roleName)).findFirst().get();
    }

}
