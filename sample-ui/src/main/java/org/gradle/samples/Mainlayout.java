package org.gradle.samples;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.mpr.LegacyWrapper;

public class Mainlayout extends VerticalLayout implements RouterLayout {

	public Mainlayout() {
        add(new LegacyWrapper(new MainMenu()));
    }
}
