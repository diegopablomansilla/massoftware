package com.massoftware.service.monedas;

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
import com.massoftware.ui.util.DoubleToBigDecimalConverter;
import com.massoftware.service.UICustomDateTimePicker;
import java.util.Locale;
import com.massoftware.service.UIDatePickerI18n_es_AR;
import com.vaadin.flow.component.checkbox.Checkbox;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;
import com.massoftware.service.afip.MonedaAFIP;
import com.massoftware.service.afip.MonedaAFIPService;


@PageTitle("Moneda")
@Route("Moneda")
public class UIMonedaView extends VerticalLayout implements HasUrlParameter<String> {

	private MonedaService service;		

	// Binder
	private Moneda item;
	private Binder<Moneda> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private TextField nombre;
	private TextField abreviatura;
	private NumberField cotizacion;
	private UICustomDateTimePicker cotizacionFecha;
	private Checkbox controlActualizacion;
	private ComboBox<MonedaAFIP> monedaAFIP;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIMonedaView() throws Exception {
		service = new MonedaService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new Moneda();
		binder = new Binder<>(Moneda.class);
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
		buildCotizacion();
		buildCotizacionFecha();
		buildControlActualizacion();
		buildMonedaAFIP();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(nombre);
		form.add(abreviatura);
		form.add(cotizacion);
		form.add(cotizacionFecha);
		form.add(controlActualizacion);
		form.add(monedaAFIP);
		
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
		// Nº moneda
		numero = new NumberField();
		numero.setLabel("Nº moneda");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº moneda es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Moneda::getNumero, Moneda::setNumero);
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
			.bind(Moneda::getNombre, Moneda::setNombre);
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
			.bind(Moneda::getAbreviatura, Moneda::setAbreviatura);
	}

	private void buildCotizacion() throws Exception {
		// Cotización
		cotizacion = new NumberField();
		cotizacion.setLabel("Cotización");
		cotizacion.setWidthFull();
		cotizacion.setReadOnly(true);
		cotizacion.setClearButtonVisible(true);
		cotizacion.setMin(-9999.9999);
		cotizacion.setMax(99999.9999);
		binder.forField(cotizacion)
			.asRequired("Cotización es requerido.")		
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(Moneda::getCotizacion, Moneda::setCotizacion);
	}

	private void buildCotizacionFecha() throws Exception {
		// Fecha cotización
		cotizacionFecha = new UICustomDateTimePicker();
		cotizacionFecha.setLabel("Fecha cotización");
		cotizacionFecha.setWidthFull();
		cotizacionFecha.setReadOnly(true);
		cotizacionFecha.setRequired(true);
		cotizacionFecha.setLocale(new Locale("es_AR"));
		cotizacionFecha.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(cotizacionFecha)
			.asRequired("Fecha cotización es requerido.")		
			.bind(Moneda::getCotizacionFecha, Moneda::setCotizacionFecha);
	}

	private void buildControlActualizacion() throws Exception {
		// Control de actualizacion
		controlActualizacion = new Checkbox();
		controlActualizacion.setLabel("Control de actualizacion");
		controlActualizacion.setWidthFull();
		binder.forField(controlActualizacion)
			.bind(Moneda::getControlActualizacion, Moneda::setControlActualizacion);
	}

	private void buildMonedaAFIP() throws Exception {
		// Moneda AFIP
		monedaAFIP = new ComboBox<>();
		monedaAFIP.setLabel("Moneda AFIP");
		monedaAFIP.setWidthFull();
		monedaAFIP.setRequired(true);
		List<MonedaAFIP> items = new MonedaAFIPService().find();
		monedaAFIP.setItems(items);
		binder.forField(monedaAFIP)
			.asRequired("Moneda AFIP es requerido.")		
			.bind(Moneda::getMonedaAFIP, Moneda::setMonedaAFIP);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<Moneda> validate = binder.validate();
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
				BinderValidationStatus<Moneda> validate = binder.validate();
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