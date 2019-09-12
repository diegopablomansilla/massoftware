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

import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.vaadin.flow.component.textfield.TextField;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.checkbox.Checkbox;


@PageTitle("Ticket modelo")
@Route("TicketModelo")
public class UITicketModeloView extends VerticalLayout implements HasUrlParameter<String> {

	private TicketModeloService service;		

	// Binder
	private TicketModelo item;
	private Binder<TicketModelo> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private TextField nombre;
	private ComboBox<Ticket> ticket;
	private TextField pruebaLectura;
	private Checkbox activo;
	private NumberField longitudLectura;
	private NumberField identificacionPosicion;
	private NumberField identificacion;
	private NumberField importePosicion;
	private NumberField longitud;
	private NumberField cantidadDecimales;
	private NumberField numeroPosicion;
	private NumberField numeroLongitud;
	private TextField prefijoIdentificacion;
	private NumberField posicionPrefijo;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UITicketModeloView() throws Exception {
		service = new TicketModeloService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new TicketModelo();
		binder = new Binder<>(TicketModelo.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildNumero();
		buildNombre();
		buildTicket();
		buildPruebaLectura();
		buildActivo();
		buildLongitudLectura();
		buildIdentificacionPosicion();
		buildIdentificacion();
		buildImportePosicion();
		buildLongitud();
		buildCantidadDecimales();
		buildNumeroPosicion();
		buildNumeroLongitud();
		buildPrefijoIdentificacion();
		buildPosicionPrefijo();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(nombre);
		form.add(ticket);
		form.add(pruebaLectura);
		form.add(activo);
		form.add(longitudLectura);
		form.add(identificacionPosicion);
		form.add(identificacion);
		form.add(importePosicion);
		form.add(longitud);
		form.add(cantidadDecimales);
		form.add(numeroPosicion);
		form.add(numeroLongitud);
		form.add(prefijoIdentificacion);
		form.add(posicionPrefijo);
		
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
		// Nº modelo
		numero = new NumberField();
		numero.setLabel("Nº modelo");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº modelo es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getNumero, TicketModelo::setNumero);
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
			.bind(TicketModelo::getNombre, TicketModelo::setNombre);
	}

	private void buildTicket() throws Exception {
		// ticket
		ticket = new ComboBox<>();
		ticket.setLabel("ticket");
		ticket.setWidthFull();
		ticket.setRequired(true);
		List<Ticket> items = new TicketService().find();
		ticket.setItems(items);
		binder.forField(ticket)
			.asRequired("ticket es requerido.")		
			.bind(TicketModelo::getTicket, TicketModelo::setTicket);
	}

	private void buildPruebaLectura() throws Exception {
		// Prueba lectura
		pruebaLectura = new TextField();
		pruebaLectura.setLabel("Prueba lectura");
		pruebaLectura.setWidthFull();
		pruebaLectura.setClearButtonVisible(true);
		pruebaLectura.setAutoselect(true);
		binder.forField(pruebaLectura)
			.withValidator(value -> (value != null) ? value.length() <= 50 : true, "El valor tiene que contener menos de 50 caracteres")
			.bind(TicketModelo::getPruebaLectura, TicketModelo::setPruebaLectura);
	}

	private void buildActivo() throws Exception {
		// activo
		activo = new Checkbox();
		activo.setLabel("activo");
		activo.setWidthFull();
		binder.forField(activo)
			.bind(TicketModelo::getActivo, TicketModelo::setActivo);
	}

	private void buildLongitudLectura() throws Exception {
		// Longitud lectura
		longitudLectura = new NumberField();
		longitudLectura.setLabel("Longitud lectura");
		longitudLectura.setWidthFull();
		longitudLectura.setClearButtonVisible(true);
		longitudLectura.setMin(0);
		longitudLectura.setMax(Integer.MAX_VALUE);
		binder.forField(longitudLectura)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getLongitudLectura, TicketModelo::setLongitudLectura);
	}

	private void buildIdentificacionPosicion() throws Exception {
		// Posición
		identificacionPosicion = new NumberField();
		identificacionPosicion.setLabel("Posición");
		identificacionPosicion.setWidthFull();
		identificacionPosicion.setClearButtonVisible(true);
		identificacionPosicion.setMin(0);
		identificacionPosicion.setMax(Integer.MAX_VALUE);
		binder.forField(identificacionPosicion)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getIdentificacionPosicion, TicketModelo::setIdentificacionPosicion);
	}

	private void buildIdentificacion() throws Exception {
		// Identificación
		identificacion = new NumberField();
		identificacion.setLabel("Identificación");
		identificacion.setWidthFull();
		identificacion.setClearButtonVisible(true);
		identificacion.setMin(0);
		identificacion.setMax(Integer.MAX_VALUE);
		binder.forField(identificacion)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getIdentificacion, TicketModelo::setIdentificacion);
	}

	private void buildImportePosicion() throws Exception {
		// Posición
		importePosicion = new NumberField();
		importePosicion.setLabel("Posición");
		importePosicion.setWidthFull();
		importePosicion.setClearButtonVisible(true);
		importePosicion.setMin(0);
		importePosicion.setMax(Integer.MAX_VALUE);
		binder.forField(importePosicion)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getImportePosicion, TicketModelo::setImportePosicion);
	}

	private void buildLongitud() throws Exception {
		// Longitud
		longitud = new NumberField();
		longitud.setLabel("Longitud");
		longitud.setWidthFull();
		longitud.setClearButtonVisible(true);
		longitud.setMin(0);
		longitud.setMax(Integer.MAX_VALUE);
		binder.forField(longitud)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getLongitud, TicketModelo::setLongitud);
	}

	private void buildCantidadDecimales() throws Exception {
		// Cantidad decimales
		cantidadDecimales = new NumberField();
		cantidadDecimales.setLabel("Cantidad decimales");
		cantidadDecimales.setWidthFull();
		cantidadDecimales.setClearButtonVisible(true);
		cantidadDecimales.setMin(0);
		cantidadDecimales.setMax(Integer.MAX_VALUE);
		binder.forField(cantidadDecimales)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getCantidadDecimales, TicketModelo::setCantidadDecimales);
	}

	private void buildNumeroPosicion() throws Exception {
		// Número posición
		numeroPosicion = new NumberField();
		numeroPosicion.setLabel("Número posición");
		numeroPosicion.setWidthFull();
		numeroPosicion.setClearButtonVisible(true);
		numeroPosicion.setMin(0);
		numeroPosicion.setMax(Integer.MAX_VALUE);
		binder.forField(numeroPosicion)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getNumeroPosicion, TicketModelo::setNumeroPosicion);
	}

	private void buildNumeroLongitud() throws Exception {
		// Número longitud
		numeroLongitud = new NumberField();
		numeroLongitud.setLabel("Número longitud");
		numeroLongitud.setWidthFull();
		numeroLongitud.setClearButtonVisible(true);
		numeroLongitud.setMin(0);
		numeroLongitud.setMax(Integer.MAX_VALUE);
		binder.forField(numeroLongitud)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getNumeroLongitud, TicketModelo::setNumeroLongitud);
	}

	private void buildPrefijoIdentificacion() throws Exception {
		// Prefijo identificación importación
		prefijoIdentificacion = new TextField();
		prefijoIdentificacion.setLabel("Prefijo identificación importación");
		prefijoIdentificacion.setWidthFull();
		prefijoIdentificacion.setClearButtonVisible(true);
		prefijoIdentificacion.setAutoselect(true);
		binder.forField(prefijoIdentificacion)
			.withValidator(value -> (value != null) ? value.length() <= 10 : true, "El valor tiene que contener menos de 10 caracteres")
			.bind(TicketModelo::getPrefijoIdentificacion, TicketModelo::setPrefijoIdentificacion);
	}

	private void buildPosicionPrefijo() throws Exception {
		// Posición prefijo
		posicionPrefijo = new NumberField();
		posicionPrefijo.setLabel("Posición prefijo");
		posicionPrefijo.setWidthFull();
		posicionPrefijo.setClearButtonVisible(true);
		posicionPrefijo.setMin(0);
		posicionPrefijo.setMax(Integer.MAX_VALUE);
		binder.forField(posicionPrefijo)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getPosicionPrefijo, TicketModelo::setPosicionPrefijo);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<TicketModelo> validate = binder.validate();
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
				BinderValidationStatus<TicketModelo> validate = binder.validate();
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