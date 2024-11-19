package org.gradle.samples;

import javax.annotation.PostConstruct;

import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

// Pay attention to the order of annotations
@UIScope
@Route(value = "ui", layout = Mainlayout.class)
public class UIScopedView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "ui";

    @Autowired
    private Greeter greeter;

    @PostConstruct
    void init() {
        addComponent(new Label("This is a UI scoped view. Greeter says: "
                + greeter.sayHello()));
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}
