package org.gradle.samples;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class MainMenu extends HorizontalLayout{
	public MainMenu() {
        Button ui = new Button("UI Scoped View",
                event -> getUI().getNavigator().navigateTo("ui"));
        ui.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        Button view = new Button("View Scoped View",
                event -> getUI().getNavigator().navigateTo("view"));
        view.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        addComponents(ui, view);
    }
}
