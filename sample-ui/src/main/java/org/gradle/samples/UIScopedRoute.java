package org.gradle.samples;

import com.vaadin.flow.router.Route;
import com.vaadin.mpr.MprRouteAdapter;

@Route(value = "ui", layout = Mainlayout.class)
public class UIScopedRoute extends MprRouteAdapter<UIScopedView> {

}
