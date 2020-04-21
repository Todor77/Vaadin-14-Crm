package com.vaadin.tutorial.com.ui.views.dashboad;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.com.backend.service.CompanyService;
import com.vaadin.tutorial.com.backend.service.ContactService;
import com.vaadin.tutorial.com.ui.MainLayout;

@Route(value = "dashboad", layout = MainLayout.class)
@PageTitle("Dashboar | Vaadin CRM")
public class DashboadView extends VerticalLayout {

	private final ContactService contactService;
	private final CompanyService companyService;

	public DashboadView(ContactService contactService, CompanyService companyService) {
		this.contactService = contactService;
		this.companyService = companyService;

		addClassName("dashboard-view");
		setDefaultHorizontalComponentAlignment(Alignment.CENTER);

		add(
			getContactStats()
//			getCompaniesChart()
		);
	}

//	private Component getCompaniesChart() {
//		Chart chart= new Chart(ChartType.PIE);
//
//		DataSeries dataSeries = new DataSeries();
//
//		Map<String, Integer> stats = companyService.getStats();
//		stats.forEach((name, number) ->
//				dataSeries.add(new DataSeriesItem(name, number)));
//
//		chart.getConfiguration().setSeries(dataSeries);
//		return chart;
//	}

	private Span getContactStats() {
		Span stats = new Span(contactService.count() + " contacts");
		stats.addClassName("contact-stats");

		return stats;
	}
}
