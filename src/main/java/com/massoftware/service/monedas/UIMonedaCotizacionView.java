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

import com.massoftware.service.UICustomDateTimePicker;
import java.util.Locale;
import com.massoftware.service.UIDatePickerI18n_es_AR;
import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToBigDecimalConverter;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;
import com.massoftware.service.seguridad.Usuario;
import com.massoftware.service.seguridad.UsuarioService;


@PageTitle("Cotización de moneda")
@Route("MonedaCotizacion")
public class UIMonedaCotizacionView extends VerticalLayout implements HasUrlParameter<String> {

	private MonedaCotizacionService service;		

	// Binder
	private MonedaCotizacion item;
	private Binder<MonedaCotizacion> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private UICustomDateTimePicker cotizacionFecha;
	private NumberField compra;
	private NumberField venta;
	private UICustomDateTimePicker cotizacionFechaAuditoria;
	private ComboBox<Moneda> moneda;
	private ComboBox<Usuario> usuario;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIMonedaCotizacionView() throws Exception {
		service = new MonedaCotizacionService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new MonedaCotizacion();
		binder = new Binder<>(MonedaCotizacion.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildCotizacionFecha();
		buildCompra();
		buildVenta();
		buildCotizacionFechaAuditoria();
		buildMoneda();
		buildUsuario();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(cotizacionFecha);
		form.add(compra);
		form.add(venta);
		form.add(cotizacionFechaAuditoria);
		form.add(moneda);
		form.add(usuario);
		
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
	

	private void buildCotizacionFecha() throws Exception {
		// Fecha cotización
		cotizacionFecha = new UICustomDateTimePicker();
		cotizacionFecha.setLabel("Fecha cotización");
		cotizacionFecha.setWidthFull();
		cotizacionFecha.setRequired(true);
		cotizacionFecha.setLocale(new Locale("es_AR"));
		cotizacionFecha.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(cotizacionFecha)
			.asRequired("Fecha cotización es requerido.")		
			.bind(MonedaCotizacion::getCotizacionFecha, MonedaCotizacion::setCotizacionFecha);
	}

	private void buildCompra() throws Exception {
		// Compra
		compra = new NumberField();
		compra.setLabel("Compra");
		compra.setWidthFull();
		compra.setClearButtonVisible(true);
		compra.setMin(-9999.9999);
		compra.setMax(99999.9999);
		binder.forField(compra)
			.asRequired("Compra es requerido.")		
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(MonedaCotizacion::getCompra, MonedaCotizacion::setCompra);
	}

	private void buildVenta() throws Exception {
		// Venta
		venta = new NumberField();
		venta.setLabel("Venta");
		venta.setWidthFull();
		venta.setClearButtonVisible(true);
		venta.setMin(-9999.9999);
		venta.setMax(99999.9999);
		binder.forField(venta)
			.asRequired("Venta es requerido.")		
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(MonedaCotizacion::getVenta, MonedaCotizacion::setVenta);
	}

	private void buildCotizacionFechaAuditoria() throws Exception {
		// Fecha cotización (Auditoria)
		cotizacionFechaAuditoria = new UICustomDateTimePicker();
		cotizacionFechaAuditoria.setLabel("Fecha cotización (Auditoria)");
		cotizacionFechaAuditoria.setWidthFull();
		cotizacionFechaAuditoria.setReadOnly(true);
		cotizacionFechaAuditoria.setRequired(true);
		cotizacionFechaAuditoria.setLocale(new Locale("es_AR"));
		cotizacionFechaAuditoria.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(cotizacionFechaAuditoria)
			.asRequired("Fecha cotización (Auditoria) es requerido.")		
			.bind(MonedaCotizacion::getCotizacionFechaAuditoria, MonedaCotizacion::setCotizacionFechaAuditoria);
	}

	private void buildMoneda() throws Exception {
		// Moneda
		moneda = new ComboBox<>();
		moneda.setLabel("Moneda");
		moneda.setWidthFull();
		moneda.setRequired(true);
		List<Moneda> items = new MonedaService().find();
		moneda.setItems(items);
		binder.forField(moneda)
			.asRequired("Moneda es requerido.")		
			.bind(MonedaCotizacion::getMoneda, MonedaCotizacion::setMoneda);
	}

	private void buildUsuario() throws Exception {
		// Usuario
		usuario = new ComboBox<>();
		usuario.setLabel("Usuario");
		usuario.setWidthFull();
		usuario.setRequired(true);
		List<Usuario> items = new UsuarioService().find();
		usuario.setItems(items);
		binder.forField(usuario)
			.asRequired("Usuario es requerido.")		
			.bind(MonedaCotizacion::getUsuario, MonedaCotizacion::setUsuario);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<MonedaCotizacion> validate = binder.validate();
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
				BinderValidationStatus<MonedaCotizacion> validate = binder.validate();
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