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
import com.vaadin.flow.component.textfield.TextField;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;


@PageTitle("Punto equilibrio")
@Route("PuntoEquilibrio")
public class UIPuntoEquilibrioView extends VerticalLayout implements HasUrlParameter<String> {

	private PuntoEquilibrioService service;		

	// Binder
	private PuntoEquilibrio item;
	private Binder<PuntoEquilibrio> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private TextField nombre;
	private ComboBox<TipoPuntoEquilibrio> tipoPuntoEquilibrio;
	private ComboBox<EjercicioContable> ejercicioContable;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIPuntoEquilibrioView() throws Exception {
		service = new PuntoEquilibrioService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new PuntoEquilibrio();
		binder = new Binder<>(PuntoEquilibrio.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildNumero();
		buildNombre();
		buildTipoPuntoEquilibrio();
		buildEjercicioContable();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(nombre);
		form.add(tipoPuntoEquilibrio);
		form.add(ejercicioContable);
		
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
		// Nº cc
		numero = new NumberField();
		numero.setLabel("Nº cc");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº cc es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(PuntoEquilibrio::getNumero, PuntoEquilibrio::setNumero);
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
			.bind(PuntoEquilibrio::getNombre, PuntoEquilibrio::setNombre);
	}

	private void buildTipoPuntoEquilibrio() throws Exception {
		// Tipo
		tipoPuntoEquilibrio = new ComboBox<>();
		tipoPuntoEquilibrio.setLabel("Tipo");
		tipoPuntoEquilibrio.setWidthFull();
		tipoPuntoEquilibrio.setRequired(true);
		List<TipoPuntoEquilibrio> items = new TipoPuntoEquilibrioService().find();
		tipoPuntoEquilibrio.setItems(items);
		binder.forField(tipoPuntoEquilibrio)
			.asRequired("Tipo es requerido.")		
			.bind(PuntoEquilibrio::getTipoPuntoEquilibrio, PuntoEquilibrio::setTipoPuntoEquilibrio);
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
			.bind(PuntoEquilibrio::getEjercicioContable, PuntoEquilibrio::setEjercicioContable);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<PuntoEquilibrio> validate = binder.validate();
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
				BinderValidationStatus<PuntoEquilibrio> validate = binder.validate();
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