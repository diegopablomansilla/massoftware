package com.massoftware.service.fondos;

//import com.vaadin.flow.component.Key;
//import com.vaadin.flow.component.KeyModifier;
//import com.vaadin.flow.component.icon.VaadinIcon;
import java.util.Optional;
import java.util.stream.Collectors;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
//import com.vaadin.flow.data.validator.StringLengthValidator;
//import com.vaadin.flow.data.validator.IntegerRangeValidator;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.component.textfield.TextField;


@PageTitle("Controlador fizcal")
@Route("TalonarioControladorFizcal")
public class UITalonarioControladorFizcalView extends VerticalLayout implements HasUrlParameter<String> {

	private TalonarioControladorFizcalService service;		

	// Binder
	private TalonarioControladorFizcal item;
	private Binder<TalonarioControladorFizcal> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private TextField codigo;
	private TextField nombre;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UITalonarioControladorFizcalView() throws Exception {
		service = new TalonarioControladorFizcalService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new TalonarioControladorFizcal();
		binder = new Binder<>(TalonarioControladorFizcal.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildCodigo();
		buildNombre();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(codigo);
		form.add(nombre);
		
		actions = new HorizontalLayout();
		actions.add(save);
		add(actions);
				
		// -------------------------------------------------------------------
	}
	
	private void buildSave() throws Exception {		
		save = new Button("Guardar");
		save.addClickListener(event -> {
			save();
		});		
	}	
	

	private void buildCodigo() throws Exception {
		// Nº controlador
		codigo = new TextField();
		codigo.setLabel("Nº controlador");
		codigo.setWidthFull();
		codigo.setClearButtonVisible(true);
		codigo.setAutoselect(true);
		codigo.setRequired(true);
		binder.forField(codigo)
			.asRequired("Nº controlador es requerido.")		
			.withValidator(value -> (value != null) ? value.length() <= 10 : true, "El valor tiene que contener menos de 10 caracteres")
			.bind(TalonarioControladorFizcal::getCodigo, TalonarioControladorFizcal::setCodigo);
	}

	private void buildNombre() throws Exception {
		// Nombre
		nombre = new TextField();
		nombre.setLabel("Nombre");
		nombre.setWidthFull();
		nombre.setClearButtonVisible(true);
		nombre.setAutoselect(true);
		nombre.setRequired(true);
		binder.forField(nombre)
			.asRequired("Nombre es requerido.")		
			.withValidator(value -> (value != null) ? value.length() <= 50 : true, "El valor tiene que contener menos de 50 caracteres")
			.bind(TalonarioControladorFizcal::getNombre, TalonarioControladorFizcal::setNombre);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<TalonarioControladorFizcal> validate = binder.validate();
		        String errorText = validate.getFieldValidationStatuses()
		                .stream().filter(BindingValidationStatus::isError)
		                .map(BindingValidationStatus::getMessage)
		                .map(Optional::get).distinct()
		                .collect(Collectors.joining(", "));
		        
		        Notification.show("Uno o mas valores del ítem son incorrectos." + errorText);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}
	
	public void save() {

		try {

			binder.validate();

			if (binder.isValid()) {								
				item = service.update(item);
				Notification.show("El ítem '" + item + "' se guardo con éxito !");
				search(item.getId());
			} else {								
				BinderValidationStatus<TalonarioControladorFizcal> validate = binder.validate();
		        String errorText = validate.getFieldValidationStatuses()
		                .stream().filter(BindingValidationStatus::isError)
		                .map(BindingValidationStatus::getMessage)
		                .map(Optional::get).distinct()
		                .collect(Collectors.joining(", "));
		        
		        Notification.show("Uno o mas valores del ítem son incorrectos." + errorText);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo guardar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}