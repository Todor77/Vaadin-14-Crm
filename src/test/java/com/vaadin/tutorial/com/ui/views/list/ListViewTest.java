package com.vaadin.tutorial.com.ui.views.list;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.tutorial.com.backend.entity.Contact;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListViewTest {

	@Autowired
	private ListView listView;

	@Test
	public void formShownWhenContactSelected() {

		Grid<Contact> grid = listView.grid;
		Contact firsContact = getFirstContact(grid);

		ContactForm form = listView.contactForm;

		Assert.assertFalse(form.isVisible());
		grid.asSingleSelect().setValue(firsContact);
		Assert.assertTrue(form.isVisible());
		Assert.assertEquals(firsContact, form.binder.getBean());
	}

	private Contact getFirstContact(Grid<Contact> grid) {
		return ((ListDataProvider<Contact>) grid.getDataProvider()).getItems().iterator().next();
	}

}
