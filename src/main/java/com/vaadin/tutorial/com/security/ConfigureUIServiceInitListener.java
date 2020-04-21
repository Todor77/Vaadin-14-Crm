package com.vaadin.tutorial.com.security;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.tutorial.com.ui.views.login.LoginView;

public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {
	@Override
	public void serviceInit(ServiceInitEvent event) {
		event.getSource().addUIInitListener(uiEvent -> {
			final UI ui = uiEvent.getUI();
			ui.addBeforeEnterListener(this::beforeEnter);
		});
	}

	private void beforeEnter(BeforeEnterEvent event) {
		if(!LoginView.class.equals(event.getNavigationTarget())
				&& !SecurityUtils.isUserLoggedIn()) {
			event.rerouteTo(LoginView.class);
		}
	}
}
