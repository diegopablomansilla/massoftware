package com.massoftware.service.contabilidad;

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
import com.vaadin.flow.component.datepicker.DatePicker;
import java.util.Locale;
import com.massoftware.service.UIDatePickerI18n_es_AR;
import com.vaadin.flow.component.textfield.TextField;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;
import com.massoftware.service.empresa.Sucursal;
import com.massoftware.service.empresa.SucursalService;


@PageTitle("Asiento contable")
@Route("AsientoContable")
public class UIAsientoContableView extends VerticalLayout implements HasUrlParameter<String> {

	private AsientoContableService service;		

	// Binder
	private AsientoContable item;
	private Binder<AsientoContable> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private DatePicker fecha;
	private TextField detalle;
	private ComboBox<EjercicioContable> ejercicioContable;
	private ComboBox<MinutaContable> minutaContable;
	private ComboBox<Sucursal> sucursal;
	private ComboBox<AsientoContableModulo> asientoContableModulo;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIAsientoContableView() throws Exception {
		service = new AsientoContableService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new AsientoContable();
		binder = new Binder<>(AsientoContable.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildNumero();
		buildFecha();
		buildDetalle();
		buildEjercicioContable();
		buildMinutaContable();
		buildSucursal();
		buildAsientoContableModulo();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(fecha);
		form.add(detalle);
		form.add(ejercicioContable);
		form.add(minutaContable);
		form.add(sucursal);
		form.add(asientoContableModulo);
		
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
		// Nº asiento
		numero = new NumberField();
		numero.setLabel("Nº asiento");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº asiento es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(AsientoContable::getNumero, AsientoContable::setNumero);
	}

	private void buildFecha() throws Exception {
		// Fecha
		fecha = new DatePicker();
		fecha.setLabel("Fecha");
		fecha.setWidthFull();
		fecha.setRequired(true);
		fecha.setLocale(new Locale("es_AR"));
		fecha.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(fecha)
			.asRequired("Fecha es requerido.")		
			.bind(AsientoContable::getFecha, AsientoContable::setFecha);
	}

	private void buildDetalle() throws Exception {
		// Detalle
		detalle = new TextField();
		detalle.setLabel("Detalle");
		detalle.setWidthFull();
		detalle.setClearButtonVisible(true);
		detalle.setAutoselect(true);
		binder.forField(detalle)
			.withValidator(value -> (value != null) ? value.length() <= 100 : true, "El valor tiene que contener menos de 100 caracteres")
			.bind(AsientoContable::getDetalle, AsientoContable::setDetalle);
	}

	private void buildEjercicioContable() throws Exception {
		// Ejercicio
		ejercicioContable = new ComboBox<>();
		ejercicioContable.setLabel("Ejercicio");
		ejercicioContable.setWidthFull();
		ejercicioContable.setReadOnly(true);
		ejercicioContable.setRequired(true);
		List<EjercicioContable> items = new EjercicioContableService().find();
		ejercicioContable.setItems(items);
		binder.forField(ejercicioContable)
			.asRequired("Ejercicio es requerido.")		
			.bind(AsientoContable::getEjercicioContable, AsientoContable::setEjercicioContable);
	}

	private void buildMinutaContable() throws Exception {
		// Minuta contable
		minutaContable = new ComboBox<>();
		minutaContable.setLabel("Minuta contable");
		minutaContable.setWidthFull();
		minutaContable.setReadOnly(true);
		minutaContable.setRequired(true);
		List<MinutaContable> items = new MinutaContableService().find();
		minutaContable.setItems(items);
		binder.forField(minutaContable)
			.asRequired("Minuta contable es requerido.")		
			.bind(AsientoContable::getMinutaContable, AsientoContable::setMinutaContable);
	}

	private void buildSucursal() throws Exception {
		// Sucursal
		sucursal = new ComboBox<>();
		sucursal.setLabel("Sucursal");
		sucursal.setWidthFull();
		sucursal.setReadOnly(true);
		sucursal.setRequired(true);
		List<Sucursal> items = new SucursalService().find();
		sucursal.setItems(items);
		binder.forField(sucursal)
			.asRequired("Sucursal es requerido.")		
			.bind(AsientoContable::getSucursal, AsientoContable::setSucursal);
	}

	private void buildAsientoContableModulo() throws Exception {
		// Módulo
		asientoContableModulo = new ComboBox<>();
		asientoContableModulo.setLabel("Módulo");
		asientoContableModulo.setWidthFull();
		asientoContableModulo.setReadOnly(true);
		asientoContableModulo.setRequired(true);
		List<AsientoContableModulo> items = new AsientoContableModuloService().find();
		asientoContableModulo.setItems(items);
		binder.forField(asientoContableModulo)
			.asRequired("Módulo es requerido.")		
			.bind(AsientoContable::getAsientoContableModulo, AsientoContable::setAsientoContableModulo);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<AsientoContable> validate = binder.validate();
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
				BinderValidationStatus<AsientoContable> validate = binder.validate();
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