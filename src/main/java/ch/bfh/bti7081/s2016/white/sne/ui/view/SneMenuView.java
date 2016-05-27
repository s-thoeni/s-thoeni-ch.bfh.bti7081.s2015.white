package ch.bfh.bti7081.s2016.white.sne.ui.view;

import org.vaadin.thomas.slidemenu.SlideMenu;
import org.vaadin.thomas.slidemenu.SlideMenu.SlideMenuListener;
import org.vaadin.thomas.slidemenu.SlideMenuView;

import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2016.white.sne.bl.ConfigurationFacade;
import ch.bfh.bti7081.s2016.white.sne.bl.ConfigurationFacadeImpl;
import ch.bfh.bti7081.s2016.white.sne.data.Configuration;
import ch.bfh.bti7081.s2016.white.sne.data.User;
import ch.bfh.bti7081.s2016.white.sne.ui.model.ConfigurationProvider;
import ch.bfh.bti7081.s2016.white.sne.ui.model.DashboardProvider;
import ch.bfh.bti7081.s2016.white.sne.ui.presenter.ConfigurationPresenter;
import ch.bfh.bti7081.s2016.white.sne.ui.presenter.DashboardPresenter;


@SuppressWarnings("serial")
public class SneMenuView extends SlideMenuView {

	private static final String USER = "T_Boy!";
	
	// Get the user-config: 
	Configuration config;
	
	public SneMenuView(Configuration config) {
		this.config = config;
		
		// add menu items
		buildMenu();

		// We can also set the width of the popup, default is 80%
		getMenu().setWidth("70%");
	}
	
	private void buildMenu() {

		// Just a normal Vaadin button
		final Button close = new Button("close menu");
		close.setWidth(null);
		close.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// Programmatic closing of the menu
				getMenu().close();
			}
		});
		getMenu().addComponent(close);

		Label user = new Label("Hi! " + USER);
		user.addStyleName(SlideMenu.STYLENAME_SECTIONLABEL);
		getMenu().addComponent(user);


		// Buttons with styling (slightly smaller with left-aligned text)
		Button b = new Button("Dashboard");
		b.addStyleName(SlideMenu.STYLENAME_BUTTON);
		getMenu().addComponent(b);

		b.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				// TODO automate with the nav listener
				getMenu().close();
				if(SneMenuView.this instanceof DashboardViewImpl){
					// im allready a dashboard. no need to create a new
					return;
				}
				DashboardPresenter db = new DashboardPresenter(new DashboardProvider(config), new DashboardViewImpl(config));
				// Only this button actually does something in the menu. Here we
				// navigate to a dummy view.
				//UiLayout.this.setContent(db.getView());
				getNavigationManager().navigateTo(db.getView());
			}
		});
		
		// Section labels have a bolded style
		Label l = new Label("Human Resources");
		l.addStyleName(SlideMenu.STYLENAME_SECTIONLABEL);
		getMenu().addComponent(l);
				
		// add more buttons for a more realistic look.
		b = new Button("Report HR");
		b.addStyleName(SlideMenu.STYLENAME_BUTTON);
		getMenu().addComponent(b);

		l = new Label("Patients / Health care");
		l.addStyleName(SlideMenu.STYLENAME_SECTIONLABEL);
		getMenu().addComponent(l);
		
		b = new Button("Report P1");
		b.addStyleName(SlideMenu.STYLENAME_BUTTON);
		getMenu().addComponent(b);
		
		b = new Button("Report P2");
		b.addStyleName(SlideMenu.STYLENAME_BUTTON);
		getMenu().addComponent(b);

		l = new Label("Finance");
		l.addStyleName(SlideMenu.STYLENAME_SECTIONLABEL);
		getMenu().addComponent(l);
		
		b = new Button("Report F1");
		b.addStyleName(SlideMenu.STYLENAME_BUTTON);
		getMenu().addComponent(b);
		
		b = new Button("Report F2");
		b.addStyleName(SlideMenu.STYLENAME_BUTTON);
		getMenu().addComponent(b);
		
		l = new Label("Settings:");
		l.addStyleName(SlideMenu.STYLENAME_SECTIONLABEL);
		getMenu().addComponent(l);			

		b = new Button("Options");
		b.addStyleName(SlideMenu.STYLENAME_BUTTON);
		getMenu().addComponent(b);		
		
		b.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				// TODO automate with the nav listener
				getMenu().close();				
				ConfigurationProvider prov = new ConfigurationProvider(new User(USER));
				ConfigurationView view = new ConfigurationViewImpl();
				ConfigurationPresenter cv = new ConfigurationPresenter(prov,view);
				// Only this button actually does something in the menu. Here we
				// navigate to a dummy view.
				
				getNavigationManager().navigateTo(cv.getView());
			}
		});
		
	}
	
	 public NavigationManager getNavigationManager() {
		 return super.getNavigationManager();
	 }
}
