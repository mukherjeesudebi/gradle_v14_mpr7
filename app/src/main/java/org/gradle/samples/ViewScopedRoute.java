package org.gradle.samples;

import com.vaadin.flow.router.Route;
import com.vaadin.mpr.MprRouteAdapter;

@Route(value = "view", layout = Mainlayout.class)
public class ViewScopedRoute extends MprRouteAdapter<ViewScopedView> {

}
