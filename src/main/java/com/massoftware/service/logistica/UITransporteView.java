package com.massoftware.service.logistica;

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
import com.massoftware.ui.util.DoubleToLongConverter;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;
import com.massoftware.service.geo.CodigoPostal;
import com.massoftware.service.geo.CodigoPostalService;
import com.vaadin.flow.component.textfield.TextArea;


@PageTitle("Transporte")
@Route("Transporte")
public class UITransporteView extends VerticalLayout implements HasUrlParameter<String> {

	private TransporteService service;		

	// Binder
	private Transporte item;
	private Binder<Transporte> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private TextField nombre;
	private NumberField cuit;
	private TextField ingresosBrutos;
	private TextField telefono;
	private TextField fax;
	private ComboBox<CodigoPostal> codigoPostal;
	private TextArea domicilio;
	private TextArea comentario;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UITransporteView() throws Exception {
		service = new TransporteService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new Transporte();
		binder = new Binder<>(Transporte.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildNumero();
		buildNombre();
		buildCuit();
		buildIngresosBrutos();
		buildTelefono();
		buildFax();
		buildCodigoPostal();
		buildDomicilio();
		buildComentario();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(nombre);
		form.add(cuit);
		form.add(ingresosBrutos);
		form.add(telefono);
		form.add(fax);
		form.add(codigoPostal);
		form.add(domicilio);
		form.add(comentario);
		
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
		// Nº transporte
		numero = new NumberField();
		numero.setLabel("Nº transporte");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº transporte es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Transporte::getNumero, Transporte::setNumero);
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
			.bind(Transporte::getNombre, Transporte::setNombre);
	}

	private void buildCuit() throws Exception {
		// CUIT
		cuit = new NumberField();
		cuit.setLabel("CUIT");
		cuit.setWidthFull();
		cuit.setClearButtonVisible(true);
		cuit.setMin(1L);
		cuit.setMax(99999999999L);
		binder.forField(cuit)
			.asRequired("CUIT es requerido.")		
			.withConverter(new DoubleToLongConverter())
			.withValidator(value -> (value != null) ? value >= 1L : true, "El valor tiene que ser >= 1L")
			.withValidator(value -> (value != null) ? value <= 99999999999L : true,"El valor tiene que ser <= " + 99999999999L)
			.bind(Transporte::getCuit, Transporte::setCuit);
	}

	private void buildIngresosBrutos() throws Exception {
		// Ingresos brutos
		ingresosBrutos = new TextField();
		ingresosBrutos.setLabel("Ingresos brutos");
		ingresosBrutos.setWidthFull();
		ingresosBrutos.setClearButtonVisible(true);
		ingresosBrutos.setAutoselect(true);
		binder.forField(ingresosBrutos)
			.withValidator(value -> (value != null) ? value.length() <= 13 : true, "El valor tiene que contener menos de 13 caracteres")
			.bind(Transporte::getIngresosBrutos, Transporte::setIngresosBrutos);
	}

	private void buildTelefono() throws Exception {
		// Teléfono
		telefono = new TextField();
		telefono.setLabel("Teléfono");
		telefono.setWidthFull();
		telefono.setClearButtonVisible(true);
		telefono.setAutoselect(true);
		binder.forField(telefono)
			.withValidator(value -> (value != null) ? value.length() <= 50 : true, "El valor tiene que contener menos de 50 caracteres")
			.bind(Transporte::getTelefono, Transporte::setTelefono);
	}

	private void buildFax() throws Exception {
		// Fax
		fax = new TextField();
		fax.setLabel("Fax");
		fax.setWidthFull();
		fax.setClearButtonVisible(true);
		fax.setAutoselect(true);
		binder.forField(fax)
			.withValidator(value -> (value != null) ? value.length() <= 50 : true, "El valor tiene que contener menos de 50 caracteres")
			.bind(Transporte::getFax, Transporte::setFax);
	}

	private void buildCodigoPostal() throws Exception {
		// Código postal
		codigoPostal = new ComboBox<>();
		codigoPostal.setLabel("Código postal");
		codigoPostal.setWidthFull();
		codigoPostal.setRequired(true);
		List<CodigoPostal> items = new CodigoPostalService().find();
		codigoPostal.setItems(items);
		binder.forField(codigoPostal)
			.asRequired("Código postal es requerido.")		
			.bind(Transporte::getCodigoPostal, Transporte::setCodigoPostal);
	}

	private void buildDomicilio() throws Exception {
		// Domicilio
		domicilio = new TextArea();
		domicilio.setLabel("Domicilio");
		domicilio.setWidthFull();
		domicilio.setClearButtonVisible(true);
		domicilio.setAutoselect(true);
		binder.forField(domicilio)
			.withValidator(value -> (value != null) ? value.length() <= 150 : true, "El valor tiene que contener menos de 150 caracteres")
			.bind(Transporte::getDomicilio, Transporte::setDomicilio);
	}

	private void buildComentario() throws Exception {
		// Comentario
		comentario = new TextArea();
		comentario.setLabel("Comentario");
		comentario.setWidthFull();
		comentario.setClearButtonVisible(true);
		comentario.setAutoselect(true);
		binder.forField(comentario)
			.withValidator(value -> (value != null) ? value.length() <= 300 : true, "El valor tiene que contener menos de 300 caracteres")
			.bind(Transporte::getComentario, Transporte::setComentario);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<Transporte> validate = binder.validate();
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
				BinderValidationStatus<Transporte> validate = binder.validate();
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