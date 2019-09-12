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

import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.vaadin.flow.component.textfield.TextField;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;
import com.massoftware.service.seguridad.SeguridadPuerta;
import com.massoftware.service.seguridad.SeguridadPuertaService;


@PageTitle("Depósito")
@Route("Deposito")
public class UIDepositoView extends VerticalLayout implements HasUrlParameter<String> {

	private DepositoService service;		

	// Binder
	private Deposito item;
	private Binder<Deposito> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private TextField nombre;
	private TextField abreviatura;
	private ComboBox<Sucursal> sucursal;
	private ComboBox<DepositoModulo> depositoModulo;
	private ComboBox<SeguridadPuerta> puertaOperativo;
	private ComboBox<SeguridadPuerta> puertaConsulta;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIDepositoView() throws Exception {
		service = new DepositoService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new Deposito();
		binder = new Binder<>(Deposito.class);
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
		buildSucursal();
		buildDepositoModulo();
		buildPuertaOperativo();
		buildPuertaConsulta();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(nombre);
		form.add(abreviatura);
		form.add(sucursal);
		form.add(depositoModulo);
		form.add(puertaOperativo);
		form.add(puertaConsulta);
		
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
		// Nº depósito
		numero = new NumberField();
		numero.setLabel("Nº depósito");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº depósito es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Deposito::getNumero, Deposito::setNumero);
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
			.bind(Deposito::getNombre, Deposito::setNombre);
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
			.bind(Deposito::getAbreviatura, Deposito::setAbreviatura);
	}

	private void buildSucursal() throws Exception {
		// Sucursal
		sucursal = new ComboBox<>();
		sucursal.setLabel("Sucursal");
		sucursal.setWidthFull();
		sucursal.setRequired(true);
		List<Sucursal> items = new SucursalService().find();
		sucursal.setItems(items);
		binder.forField(sucursal)
			.asRequired("Sucursal es requerido.")		
			.bind(Deposito::getSucursal, Deposito::setSucursal);
	}

	private void buildDepositoModulo() throws Exception {
		// Módulo
		depositoModulo = new ComboBox<>();
		depositoModulo.setLabel("Módulo");
		depositoModulo.setWidthFull();
		depositoModulo.setRequired(true);
		List<DepositoModulo> items = new DepositoModuloService().find();
		depositoModulo.setItems(items);
		binder.forField(depositoModulo)
			.asRequired("Módulo es requerido.")		
			.bind(Deposito::getDepositoModulo, Deposito::setDepositoModulo);
	}

	private void buildPuertaOperativo() throws Exception {
		// Puerta operativo
		puertaOperativo = new ComboBox<>();
		puertaOperativo.setLabel("Puerta operativo");
		puertaOperativo.setWidthFull();
		puertaOperativo.setRequired(true);
		List<SeguridadPuerta> items = new SeguridadPuertaService().find();
		puertaOperativo.setItems(items);
		binder.forField(puertaOperativo)
			.asRequired("Puerta operativo es requerido.")		
			.bind(Deposito::getPuertaOperativo, Deposito::setPuertaOperativo);
	}

	private void buildPuertaConsulta() throws Exception {
		// Puerta consulta
		puertaConsulta = new ComboBox<>();
		puertaConsulta.setLabel("Puerta consulta");
		puertaConsulta.setWidthFull();
		puertaConsulta.setRequired(true);
		List<SeguridadPuerta> items = new SeguridadPuertaService().find();
		puertaConsulta.setItems(items);
		binder.forField(puertaConsulta)
			.asRequired("Puerta consulta es requerido.")		
			.bind(Deposito::getPuertaConsulta, Deposito::setPuertaConsulta);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<Deposito> validate = binder.validate();
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
				BinderValidationStatus<Deposito> validate = binder.validate();
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