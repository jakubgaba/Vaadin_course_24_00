package com.vaadin.training.layouting.exercises.ex2;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;
import com.vaadin.training.layouting.exercises.MainLayout;

@Route(value = UseFormLayout.ROUTE, layout = MainLayout.class)
public class UseFormLayout extends VerticalLayout {

    public static final String ROUTE = "ex2";
    public static final String TITLE = "Exercise 2";
    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private PasswordField passwordField1;
    private PasswordField passwordField2;
    private Checkbox checkBox;
    private FormLayout formLayout;
    private FormLayout formLayout2;

    public UseFormLayout() {
        setSizeFull();

        formLayout = new FormLayout();

        textField1 = new TextField();
        textField1.setWidth("100%");
        formLayout.addFormItem(textField1, "First Name");

        textField2 = new TextField();
        textField2.setWidth("100%");
        formLayout.addFormItem(textField2, "Last Name");

        textField3 = new TextField();
        textField3.setWidth("100%");
        formLayout.addFormItem(textField3, "Email").getElement().setAttribute("colspan", "2");

        FlexLayout Password = new FlexLayout();
        PasswordField password = new PasswordField();
        Checkbox checkbox = new Checkbox("Do not press");
        Password.setWidth("100%");
        Password.expand(password);
        Password.add(password, checkbox);
        Password.setAlignItems(Alignment.CENTER);
        formLayout.addFormItem(Password, "Password");

        formLayout.getElement().appendChild(ElementFactory.createBr());

        PasswordField passwordRepeat = new PasswordField();
        passwordRepeat.setWidth("100%");
        formLayout.addFormItem(passwordRepeat, "Repeat password");

        add(formLayout);
    }
}
