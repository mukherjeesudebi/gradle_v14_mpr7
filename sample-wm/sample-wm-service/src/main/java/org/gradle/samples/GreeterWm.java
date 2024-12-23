package org.gradle.samples;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class GreeterWm {
    public String sayHello() {
        return "Hello from bean " + toString();
    }
}
