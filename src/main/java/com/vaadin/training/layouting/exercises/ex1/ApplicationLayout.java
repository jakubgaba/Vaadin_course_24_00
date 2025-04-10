package com.vaadin.training.layouting.exercises.ex1;

import java.io.Serial;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.training.layouting.exercises.MainLayout;



@Route(value = ApplicationLayout.ROUTE, layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class ApplicationLayout extends VerticalLayout {

	@Serial
	private static final long serialVersionUID = 1L;

	public static final String ROUTE = "ex1";
	public static final String TITLE = "Exercise 1";
	public HorizontalLayout layout;
	public ApplicationLayout() {
		setSizeFull();
		setPadding(false);
		setSpacing(false);
		setHorizontalComponentAlignment(Alignment.STRETCH);
		
		final Div header = new Div();
		header.setText("This is the header. My height is 150 pixels");
		header.getStyle().set("flexShrink", "0");          //Finally ! This think prevent from a resizing !
		header.setHeight("150px");
		header.setWidthFull();
		header.setClassName("header");

		layout = new HorizontalLayout();
		layout.setSpacing(false);
		layout.setWidth("100%");
		layout.setHeight("100%");
		layout.getStyle().set("flex-grow", "1");
		layout.setClassName("layout");
		layout.getStyle().set("overflow-y", "hidden");  //I set this because the scrollbar was over the page
		createTextLayout();

		final Div footer = new Div();
		footer.setText("This is the footer area. My height is 100 pixels");
		footer.setHeight("100px");
		footer.getStyle().set("flexShrink", "0");          //Finally ! This think prevent from a resizing !
		footer.setWidthFull();
		footer.setClassName("footer");

		add(header, layout, footer);
 
		expand(layout);        //Just sets flex grow for all on 1, Hard to explain it just fills the content
	}  

	private void createTextLayout(){
		final Div navigation = new Div();
		navigation.setClassName("navigation");
		navigation.setText("This is the navigation area. My width is 25% of the ApplicationLayout.");
		navigation.setWidth("25%");
		navigation.getStyle().set("flex-shrink", "0");
		

		final Div content = new Div();
		content.setWidth("75%");
		content.setHeightFull();
		content.setClassName("content");
		content.getStyle().set("display", "flex");
		content.getStyle().set("flex-wrap", "wrap");   // To stop the children elements to shrinking, instead of it will put them on a new line
		content.getStyle().set("overflow-y", "auto");  //This set scrollbar only into content class
		content.getStyle().set("alignContent", "start");
		for (int i = 0; i < 60; i++) {
			content.add(createBlock());
		}
		layout.add(navigation, content);
		layout.expand(content);            //Hard to explain it just fills the content
		layout.setDefaultVerticalComponentAlignment(Alignment.STRETCH);
	}
	/**
	 * Ignore this method for now.
	 *
	 * @return
	 */
	private Div createBlock() {
		final Div button = new Div();
		button.setText("Block");
		button.getStyle().set("background", "white");
		button.setHeight("100px");
		button.setWidth("100px");
		button.getStyle().set("margin", "2px");
		return button;
	}

}