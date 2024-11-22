package org.gradle.samples;

import com.vaadin.flow.router.Route;
import com.vaadin.mpr.MprNavigatorRoute;
import com.vaadin.mpr.core.MprTheme;
import com.vaadin.mpr.core.MprWidgetset;
import com.vaadin.navigator.Navigator;

@Route(value = "", layout = Mainlayout.class)
public class MyNavigatorRoute extends MprNavigatorRoute{

	@Override
	public void configureNavigator(Navigator navigator) {
		 navigator.addView("UI Scoped View", UIScopedView.class);
		 navigator.addView("View Scoped View", ViewScopedView.class);
		
	}

}
