package com.massoftware.service.empresa;

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

import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;
import com.massoftware.service.contabilidad.EjercicioContable;
import com.massoftware.service.contabilidad.EjercicioContableService;
import com.vaadin.flow.component.datepicker.DatePicker;
import java.util.Locale;
import com.massoftware.service.UIDatePickerI18n_es_AR;


@PageTitle("Empresa")
@Route("Empresa")
public class UIEmpresaView extends VerticalLayout implements HasUrlParameter<String> {

	private EmpresaService service;		

	// Binder
	private Empresa item;
	private Binder<Empresa> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private ComboBox<EjercicioContable> ejercicioContable;
	private DatePicker fechaCierreVentas;
	private DatePicker fechaCierreStock;
	private DatePicker fechaCierreFondo;
	private DatePicker fechaCierreCompras;
	private DatePicker fechaCierreContabilidad;
	private DatePicker fechaCierreGarantiaDevoluciones;
	private DatePicker fechaCierreTambos;
	private DatePicker fechaCierreRRHH;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIEmpresaView() throws Exception {
		service = new EmpresaService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new Empresa();
		binder = new Binder<>(Empresa.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildEjercicioContable();
		buildFechaCierreVentas();
		buildFechaCierreStock();
		buildFechaCierreFondo();
		buildFechaCierreCompras();
		buildFechaCierreContabilidad();
		buildFechaCierreGarantiaDevoluciones();
		buildFechaCierreTambos();
		buildFechaCierreRRHH();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(ejercicioContable);
		form.add(fechaCierreVentas);
		form.add(fechaCierreStock);
		form.add(fechaCierreFondo);
		form.add(fechaCierreCompras);
		form.add(fechaCierreContabilidad);
		form.add(fechaCierreGarantiaDevoluciones);
		form.add(fechaCierreTambos);
		form.add(fechaCierreRRHH);
		
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
	

	private void buildEjercicioContable() throws Exception {
		// Ejercicio
		ejercicioContable = new ComboBox<>();
		ejercicioContable.setLabel("Ejercicio");
		ejercicioContable.setWidthFull();
		ejercicioContable.setRequired(true);
		List<EjercicioContable> items = new EjercicioContableService().find();
		ejercicioContable.setItems(items);
		binder.forField(ejercicioContable)
			.asRequired("Ejercicio es requerido.")		
			.bind(Empresa::getEjercicioContable, Empresa::setEjercicioContable);
	}

	private void buildFechaCierreVentas() throws Exception {
		// Fecha cierre ventas
		fechaCierreVentas = new DatePicker();
		fechaCierreVentas.setLabel("Fecha cierre ventas");
		fechaCierreVentas.setWidthFull();
		fechaCierreVentas.setLocale(new Locale("es_AR"));
		fechaCierreVentas.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(fechaCierreVentas)
			.bind(Empresa::getFechaCierreVentas, Empresa::setFechaCierreVentas);
	}

	private void buildFechaCierreStock() throws Exception {
		// Fecha cierre stock
		fechaCierreStock = new DatePicker();
		fechaCierreStock.setLabel("Fecha cierre stock");
		fechaCierreStock.setWidthFull();
		fechaCierreStock.setLocale(new Locale("es_AR"));
		fechaCierreStock.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(fechaCierreStock)
			.bind(Empresa::getFechaCierreStock, Empresa::setFechaCierreStock);
	}

	private void buildFechaCierreFondo() throws Exception {
		// Fecha cierre fondo
		fechaCierreFondo = new DatePicker();
		fechaCierreFondo.setLabel("Fecha cierre fondo");
		fechaCierreFondo.setWidthFull();
		fechaCierreFondo.setLocale(new Locale("es_AR"));
		fechaCierreFondo.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(fechaCierreFondo)
			.bind(Empresa::getFechaCierreFondo, Empresa::setFechaCierreFondo);
	}

	private void buildFechaCierreCompras() throws Exception {
		// Fecha cierre compras
		fechaCierreCompras = new DatePicker();
		fechaCierreCompras.setLabel("Fecha cierre compras");
		fechaCierreCompras.setWidthFull();
		fechaCierreCompras.setLocale(new Locale("es_AR"));
		fechaCierreCompras.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(fechaCierreCompras)
			.bind(Empresa::getFechaCierreCompras, Empresa::setFechaCierreCompras);
	}

	private void buildFechaCierreContabilidad() throws Exception {
		// Fecha cierre contabilidad
		fechaCierreContabilidad = new DatePicker();
		fechaCierreContabilidad.setLabel("Fecha cierre contabilidad");
		fechaCierreContabilidad.setWidthFull();
		fechaCierreContabilidad.setLocale(new Locale("es_AR"));
		fechaCierreContabilidad.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(fechaCierreContabilidad)
			.bind(Empresa::getFechaCierreContabilidad, Empresa::setFechaCierreContabilidad);
	}

	private void buildFechaCierreGarantiaDevoluciones() throws Exception {
		// Fecha cierre garantia y devoluciones
		fechaCierreGarantiaDevoluciones = new DatePicker();
		fechaCierreGarantiaDevoluciones.setLabel("Fecha cierre garantia y devoluciones");
		fechaCierreGarantiaDevoluciones.setWidthFull();
		fechaCierreGarantiaDevoluciones.setLocale(new Locale("es_AR"));
		fechaCierreGarantiaDevoluciones.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(fechaCierreGarantiaDevoluciones)
			.bind(Empresa::getFechaCierreGarantiaDevoluciones, Empresa::setFechaCierreGarantiaDevoluciones);
	}

	private void buildFechaCierreTambos() throws Exception {
		// Fecha cierre tambos
		fechaCierreTambos = new DatePicker();
		fechaCierreTambos.setLabel("Fecha cierre tambos");
		fechaCierreTambos.setWidthFull();
		fechaCierreTambos.setLocale(new Locale("es_AR"));
		fechaCierreTambos.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(fechaCierreTambos)
			.bind(Empresa::getFechaCierreTambos, Empresa::setFechaCierreTambos);
	}

	private void buildFechaCierreRRHH() throws Exception {
		// Fecha cierre RRHH
		fechaCierreRRHH = new DatePicker();
		fechaCierreRRHH.setLabel("Fecha cierre RRHH");
		fechaCierreRRHH.setWidthFull();
		fechaCierreRRHH.setLocale(new Locale("es_AR"));
		fechaCierreRRHH.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(fechaCierreRRHH)
			.bind(Empresa::getFechaCierreRRHH, Empresa::setFechaCierreRRHH);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<Empresa> validate = binder.validate();
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
				BinderValidationStatus<Empresa> validate = binder.validate();
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