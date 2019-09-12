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

import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.vaadin.flow.component.textfield.TextField;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;


@PageTitle("Provincia")
@Route("Provincia")
public class UIProvinciaView extends VerticalLayout implements HasUrlParameter<String> {

	private ProvinciaService service;		

	// Binder
	private Provincia item;
	private Binder<Provincia> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private TextField nombre;
	private TextField abreviatura;
	private NumberField numeroAFIP;
	private NumberField numeroIngresosBrutos;
	private NumberField numeroRENATEA;
	private ComboBox<Pais> pais;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIProvinciaView() throws Exception {
		service = new ProvinciaService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new Provincia();
		binder = new Binder<>(Provincia.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildNumero();
		buildNombre();
		buildAbreviatura();
		buildNumeroAFIP();
		buildNumeroIngresosBrutos();
		buildNumeroRENATEA();
		buildPais();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(nombre);
		form.add(abreviatura);
		form.add(numeroAFIP);
		form.add(numeroIngresosBrutos);
		form.add(numeroRENATEA);
		form.add(pais);
		
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
	

	private void buildNumero() throws Exception {
		// Nº provincia
		numero = new NumberField();
		numero.setLabel("Nº provincia");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº provincia es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Provincia::getNumero, Provincia::setNumero);
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
			.bind(Provincia::getNombre, Provincia::setNombre);
	}

	private void buildAbreviatura() throws Exception {
		// Abreviatura
		abreviatura = new TextField();
		abreviatura.setLabel("Abreviatura");
		abreviatura.setWidthFull();
		abreviatura.setClearButtonVisible(true);
		abreviatura.setAutoselect(true);
		abreviatura.setRequired(true);
		binder.forField(abreviatura)
			.asRequired("Abreviatura es requerido.")		
			.withValidator(value -> (value != null) ? value.length() <= 5 : true, "El valor tiene que contener menos de 5 caracteres")
			.bind(Provincia::getAbreviatura, Provincia::setAbreviatura);
	}

	private void buildNumeroAFIP() throws Exception {
		// Nº provincia AFIP
		numeroAFIP = new NumberField();
		numeroAFIP.setLabel("Nº provincia AFIP");
		numeroAFIP.setWidthFull();
		numeroAFIP.setClearButtonVisible(true);
		numeroAFIP.setMin(1);
		numeroAFIP.setMax(Integer.MAX_VALUE);
		binder.forField(numeroAFIP)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Provincia::getNumeroAFIP, Provincia::setNumeroAFIP);
	}

	private void buildNumeroIngresosBrutos() throws Exception {
		// Nº provincia ingresos brutos
		numeroIngresosBrutos = new NumberField();
		numeroIngresosBrutos.setLabel("Nº provincia ingresos brutos");
		numeroIngresosBrutos.setWidthFull();
		numeroIngresosBrutos.setClearButtonVisible(true);
		numeroIngresosBrutos.setMin(1);
		numeroIngresosBrutos.setMax(Integer.MAX_VALUE);
		binder.forField(numeroIngresosBrutos)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Provincia::getNumeroIngresosBrutos, Provincia::setNumeroIngresosBrutos);
	}

	private void buildNumeroRENATEA() throws Exception {
		// Nº provincia RENATEA
		numeroRENATEA = new NumberField();
		numeroRENATEA.setLabel("Nº provincia RENATEA");
		numeroRENATEA.setWidthFull();
		numeroRENATEA.setClearButtonVisible(true);
		numeroRENATEA.setMin(1);
		numeroRENATEA.setMax(Integer.MAX_VALUE);
		binder.forField(numeroRENATEA)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Provincia::getNumeroRENATEA, Provincia::setNumeroRENATEA);
	}

	private void buildPais() throws Exception {
		// País
		pais = new ComboBox<>();
		pais.setLabel("País");
		pais.setWidthFull();
		pais.setRequired(true);
		List<Pais> items = new PaisService().find();
		pais.setItems(items);
		binder.forField(pais)
			.asRequired("País es requerido.")		
			.bind(Provincia::getPais, Provincia::setPais);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<Provincia> validate = binder.validate();
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
				BinderValidationStatus<Provincia> validate = binder.validate();
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