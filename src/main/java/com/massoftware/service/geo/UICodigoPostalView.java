package com.massoftware.service.geo;

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
import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.vaadin.flow.component.textfield.TextArea;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;


@PageTitle("Código postal")
@Route("CodigoPostal")
public class UICodigoPostalView extends VerticalLayout implements HasUrlParameter<String> {

	private CodigoPostalService service;		

	// Binder
	private CodigoPostal item;
	private Binder<CodigoPostal> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private TextField codigo;
	private NumberField numero;
	private TextArea nombreCalle;
	private TextField numeroCalle;
	private ComboBox<Ciudad> ciudad;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UICodigoPostalView() throws Exception {
		service = new CodigoPostalService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new CodigoPostal();
		binder = new Binder<>(CodigoPostal.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildCodigo();
		buildNumero();
		buildNombreCalle();
		buildNumeroCalle();
		buildCiudad();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(codigo);
		form.add(numero);
		form.add(nombreCalle);
		form.add(numeroCalle);
		form.add(ciudad);
		
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
		// Código
		codigo = new TextField();
		codigo.setLabel("Código");
		codigo.setWidthFull();
		codigo.setClearButtonVisible(true);
		codigo.setAutoselect(true);
		codigo.setRequired(true);
		binder.forField(codigo)
			.asRequired("Código es requerido.")		
			.withValidator(value -> (value != null) ? value.length() <= 12 : true, "El valor tiene que contener menos de 12 caracteres")
			.bind(CodigoPostal::getCodigo, CodigoPostal::setCodigo);
	}

	private void buildNumero() throws Exception {
		// Secuencia
		numero = new NumberField();
		numero.setLabel("Secuencia");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Secuencia es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(CodigoPostal::getNumero, CodigoPostal::setNumero);
	}

	private void buildNombreCalle() throws Exception {
		// Calle
		nombreCalle = new TextArea();
		nombreCalle.setLabel("Calle");
		nombreCalle.setWidthFull();
		nombreCalle.setClearButtonVisible(true);
		nombreCalle.setAutoselect(true);
		nombreCalle.setRequired(true);
		binder.forField(nombreCalle)
			.asRequired("Calle es requerido.")		
			.withValidator(value -> (value != null) ? value.length() <= 200 : true, "El valor tiene que contener menos de 200 caracteres")
			.bind(CodigoPostal::getNombreCalle, CodigoPostal::setNombreCalle);
	}

	private void buildNumeroCalle() throws Exception {
		// Número calle
		numeroCalle = new TextField();
		numeroCalle.setLabel("Número calle");
		numeroCalle.setWidthFull();
		numeroCalle.setClearButtonVisible(true);
		numeroCalle.setAutoselect(true);
		numeroCalle.setRequired(true);
		binder.forField(numeroCalle)
			.asRequired("Número calle es requerido.")		
			.withValidator(value -> (value != null) ? value.length() <= 20 : true, "El valor tiene que contener menos de 20 caracteres")
			.bind(CodigoPostal::getNumeroCalle, CodigoPostal::setNumeroCalle);
	}

	private void buildCiudad() throws Exception {
		// Ciudad
		ciudad = new ComboBox<>();
		ciudad.setLabel("Ciudad");
		ciudad.setWidthFull();
		ciudad.setRequired(true);
		List<Ciudad> items = new CiudadService().find();
		ciudad.setItems(items);
		binder.forField(ciudad)
			.asRequired("Ciudad es requerido.")		
			.bind(CodigoPostal::getCiudad, CodigoPostal::setCiudad);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<CodigoPostal> validate = binder.validate();
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
				BinderValidationStatus<CodigoPostal> validate = binder.validate();
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