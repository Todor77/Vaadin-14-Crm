package com.vaadin.tutorial.com.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.tutorial.com.ui.views.dashboad.DashboadView;
import com.vaadin.tutorial.com.ui.views.list.ListView;


@CssImport("./styles/shared-styles.css")
@PWA(
		name = "Vaadin CRM",
		shortName = "CRM",
		offlineResources = {
				"./styles/offline.css",
				"./images/offline.png"
		},
		enableInstallPrompt = false
)
public class MainLayout extends AppLayout {

	public MainLayout() {
		createHeader();
		createDrawer();

	}

	private void createDrawer() {
		RouterLink listLink = new RouterLink("List", ListView.class);
		listLink.setHighlightCondition(HighlightConditions.sameLocation());

		RouterLink dashBoardLink = new RouterLink("Dashboard", DashboadView.class);
		addToDrawer(new VerticalLayout(
				listLink,
				dashBoardLink
		));
	}

	private void createHeader() {
		H1 logo = new H1("Vaadin CRM");
		logo.addClassName("logo");

		Anchor log_out = new Anchor("/logout", "Log out");

		HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, log_out);
		header.addClassName("header");
		header.setWidth("100%");
		header.expand(logo);
		header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

		addToNavbar(header);
	}
}
