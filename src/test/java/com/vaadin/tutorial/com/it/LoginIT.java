package com.vaadin.tutorial.com.it;

import org.junit.Test;

public class LoginIT extends AbstractTest{
	protected LoginIT() {
		super("");
	}

	@Test
	public void loginAsValidUserSucceeds() {
		LoginViewElement loginViewElement = $(LoginViewElement.class).onPage().first();
//		Assert.assertTrue(loginViewElement.login("user", "password"));
	}

	@Test
	public void loginAsInvalidUserFails() {
		LoginViewElement loginViewElement = $(LoginViewElement.class).onPage().first();
//		Assert.assertFalse(loginViewElement.login("user", "invalid"));
	}
}
