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


@PageTitle("Chequera")
@Route("Chequera")
public class UIChequeraView extends VerticalLayout implements HasUrlParameter<String> {

	private ChequeraService service;		

	// Binder
	private Chequera item;
	private Binder<Chequera> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private TextField nombre;
	private ComboBox<CuentaFondo> cuentaFondo;
	private NumberField primerNumero;
	private NumberField ultimoNumero;
	private NumberField proximoNumero;
	private Checkbox bloqueado;
	private Checkbox impresionDiferida;
	private TextField formato;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIChequeraView() throws Exception {
		service = new ChequeraService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new Chequera();
		binder = new Binder<>(Chequera.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildNumero();
		buildNombre();
		buildCuentaFondo();
		buildPrimerNumero();
		buildUltimoNumero();
		buildProximoNumero();
		buildBloqueado();
		buildImpresionDiferida();
		buildFormato();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(nombre);
		form.add(cuentaFondo);
		form.add(primerNumero);
		form.add(ultimoNumero);
		form.add(proximoNumero);
		form.add(bloqueado);
		form.add(impresionDiferida);
		form.add(formato);
		
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
		// Nº chequera
		numero = new NumberField();
		numero.setLabel("Nº chequera");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº chequera es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Chequera::getNumero, Chequera::setNumero);
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
			.bind(Chequera::getNombre, Chequera::setNombre);
	}

	private void buildCuentaFondo() throws Exception {
		// Cuenta fondo
		cuentaFondo = new ComboBox<>();
		cuentaFondo.setLabel("Cuenta fondo");
		cuentaFondo.setWidthFull();
		cuentaFondo.setRequired(true);
		List<CuentaFondo> items = new CuentaFondoService().find();
		cuentaFondo.setItems(items);
		binder.forField(cuentaFondo)
			.asRequired("Cuenta fondo es requerido.")		
			.bind(Chequera::getCuentaFondo, Chequera::setCuentaFondo);
	}

	private void buildPrimerNumero() throws Exception {
		// Primer número
		primerNumero = new NumberField();
		primerNumero.setLabel("Primer número");
		primerNumero.setWidthFull();
		primerNumero.setClearButtonVisible(true);
		primerNumero.setMin(0);
		primerNumero.setMax(Integer.MAX_VALUE);
		binder.forField(primerNumero)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Chequera::getPrimerNumero, Chequera::setPrimerNumero);
	}

	private void buildUltimoNumero() throws Exception {
		// Último número
		ultimoNumero = new NumberField();
		ultimoNumero.setLabel("Último número");
		ultimoNumero.setWidthFull();
		ultimoNumero.setClearButtonVisible(true);
		ultimoNumero.setMin(0);
		ultimoNumero.setMax(Integer.MAX_VALUE);
		binder.forField(ultimoNumero)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Chequera::getUltimoNumero, Chequera::setUltimoNumero);
	}

	private void buildProximoNumero() throws Exception {
		// Próximo número
		proximoNumero = new NumberField();
		proximoNumero.setLabel("Próximo número");
		proximoNumero.setWidthFull();
		proximoNumero.setClearButtonVisible(true);
		proximoNumero.setMin(0);
		proximoNumero.setMax(Integer.MAX_VALUE);
		binder.forField(proximoNumero)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Chequera::getProximoNumero, Chequera::setProximoNumero);
	}

	private void buildBloqueado() throws Exception {
		// Obsoleto
		bloqueado = new Checkbox();
		bloqueado.setLabel("Obsoleto");
		bloqueado.setWidthFull();
		binder.forField(bloqueado)
			.bind(Chequera::getBloqueado, Chequera::setBloqueado);
	}

	private void buildImpresionDiferida() throws Exception {
		// Impresión diferida
		impresionDiferida = new Checkbox();
		impresionDiferida.setLabel("Impresión diferida");
		impresionDiferida.setWidthFull();
		binder.forField(impresionDiferida)
			.bind(Chequera::getImpresionDiferida, Chequera::setImpresionDiferida);
	}

	private void buildFormato() throws Exception {
		// Formato
		formato = new TextField();
		formato.setLabel("Formato");
		formato.setWidthFull();
		formato.setClearButtonVisible(true);
		formato.setAutoselect(true);
		binder.forField(formato)
			.withValidator(value -> (value != null) ? value.length() <= 50 : true, "El valor tiene que contener menos de 50 caracteres")
			.bind(Chequera::getFormato, Chequera::setFormato);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<Chequera> validate = binder.validate();
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
				BinderValidationStatus<Chequera> validate = binder.validate();
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