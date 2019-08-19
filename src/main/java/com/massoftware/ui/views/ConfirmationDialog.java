package com.massoftware.ui.views;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ConfirmationDialog extends Dialog {

	private Label title;
	private Label question;
	private Button confirm;

	public ConfirmationDialog() {
		createHeader();
		createContent();
		createFooter();
	}

	public ConfirmationDialog(String title, String content,
			@SuppressWarnings("rawtypes") ComponentEventListener listener) {
		this();
		setTitle(title);
		setQuestion(content);
		addConfirmationListener(listener);
	}

	public void setTitle(String title) {
		this.title.setText(title);
	}

	public void setQuestion(String question) {
		this.question.setText(question);
	}

	@SuppressWarnings("unchecked")
	public void addConfirmationListener(@SuppressWarnings("rawtypes") ComponentEventListener listener) {
		confirm.addClickListener(listener);
	}
	
//	@SuppressWarnings("unchecked")
//	public void addAbortListener(@SuppressWarnings("rawtypes") ComponentEventListener listener) {
//		confirm.addClickListener(listener);
//	}

	private void createHeader() {
		this.title = new Label();
		Button close = new Button();
		close.setIcon(VaadinIcon.CLOSE.create());
		close.addClickListener(buttonClickEvent -> close());

		HorizontalLayout header = new HorizontalLayout();
		header.add(this.title, close);
		header.setFlexGrow(1, this.title);
		header.setAlignItems(FlexComponent.Alignment.CENTER);
//		header.getStyle().set("background-color", "green");
		add(header);
	}

	private void createContent() {
		question = new Label();

		VerticalLayout content = new VerticalLayout();
		content.add(question);
		content.setPadding(false);
//		content.getStyle().set("background-color", "red");
		add(content);
	}

	private void createFooter() {
		Button abort = new Button("Cancelar");
		abort.addClickListener(buttonClickEvent -> close());
		
		confirm = new Button("Borrar");
		confirm.addClickListener(buttonClickEvent -> close());
		confirm.addThemeVariants(ButtonVariant.LUMO_ERROR);

		HorizontalLayout footer = new HorizontalLayout();
		footer.add(abort, confirm);
		footer.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
//		footer.getStyle().set("background-color", "yellow");
		add(footer);
	}

	@Override
	public void open() {
		super.open();
		confirm.focus();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 40152453846491114L;
}
