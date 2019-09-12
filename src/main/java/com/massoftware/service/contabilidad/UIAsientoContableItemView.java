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
import com.massoftware.ui.util.DoubleToBigDecimalConverter;


@PageTitle("Item de asiento contable")
@Route("AsientoContableItem")
public class UIAsientoContableItemView extends VerticalLayout implements HasUrlParameter<String> {

	private AsientoContableItemService service;		

	// Binder
	private AsientoContableItem item;
	private Binder<AsientoContableItem> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private DatePicker fecha;
	private TextField detalle;
	private ComboBox<AsientoContable> asientoContable;
	private ComboBox<CuentaContable> cuentaContable;
	private NumberField debe;
	private NumberField haber;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIAsientoContableItemView() throws Exception {
		service = new AsientoContableItemService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new AsientoContableItem();
		binder = new Binder<>(AsientoContableItem.class);
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
		buildAsientoContable();
		buildCuentaContable();
		buildDebe();
		buildHaber();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(fecha);
		form.add(detalle);
		form.add(asientoContable);
		form.add(cuentaContable);
		form.add(debe);
		form.add(haber);
		
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
		// Nº item
		numero = new NumberField();
		numero.setLabel("Nº item");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº item es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(AsientoContableItem::getNumero, AsientoContableItem::setNumero);
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
			.bind(AsientoContableItem::getFecha, AsientoContableItem::setFecha);
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
			.bind(AsientoContableItem::getDetalle, AsientoContableItem::setDetalle);
	}

	private void buildAsientoContable() throws Exception {
		// Asiento contable
		asientoContable = new ComboBox<>();
		asientoContable.setLabel("Asiento contable");
		asientoContable.setWidthFull();
		asientoContable.setReadOnly(true);
		asientoContable.setRequired(true);
		List<AsientoContable> items = new AsientoContableService().find();
		asientoContable.setItems(items);
		binder.forField(asientoContable)
			.asRequired("Asiento contable es requerido.")		
			.bind(AsientoContableItem::getAsientoContable, AsientoContableItem::setAsientoContable);
	}

	private void buildCuentaContable() throws Exception {
		// Cuenta contable
		cuentaContable = new ComboBox<>();
		cuentaContable.setLabel("Cuenta contable");
		cuentaContable.setWidthFull();
		cuentaContable.setRequired(true);
		List<CuentaContable> items = new CuentaContableService().find();
		cuentaContable.setItems(items);
		binder.forField(cuentaContable)
			.asRequired("Cuenta contable es requerido.")		
			.bind(AsientoContableItem::getCuentaContable, AsientoContableItem::setCuentaContable);
	}

	private void buildDebe() throws Exception {
		// Debe
		debe = new NumberField();
		debe.setLabel("Debe");
		debe.setWidthFull();
		debe.setClearButtonVisible(true);
		binder.forField(debe)
			.asRequired("Debe es requerido.")		
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(AsientoContableItem::getDebe, AsientoContableItem::setDebe);
	}

	private void buildHaber() throws Exception {
		// Haber
		haber = new NumberField();
		haber.setLabel("Haber");
		haber.setWidthFull();
		haber.setClearButtonVisible(true);
		binder.forField(haber)
			.asRequired("Haber es requerido.")		
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(AsientoContableItem::getHaber, AsientoContableItem::setHaber);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<AsientoContableItem> validate = binder.validate();
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
				BinderValidationStatus<AsientoContableItem> validate = binder.validate();
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