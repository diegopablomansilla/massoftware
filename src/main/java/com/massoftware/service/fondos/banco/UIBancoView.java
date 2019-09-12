package com.massoftware.service.fondos.banco;

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
import com.vaadin.flow.component.checkbox.Checkbox;


@PageTitle("Banco")
@Route("Banco")
public class UIBancoView extends VerticalLayout implements HasUrlParameter<String> {

	private BancoService service;		

	// Binder
	private Banco item;
	private Binder<Banco> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private TextField nombre;
	private NumberField cuit;
	private Checkbox vigente;
	private NumberField hoja;
	private NumberField primeraFila;
	private NumberField ultimaFila;
	private TextField fecha;
	private TextField descripcion;
	private TextField referencia1;
	private TextField importe;
	private TextField referencia2;
	private TextField saldo;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIBancoView() throws Exception {
		service = new BancoService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new Banco();
		binder = new Binder<>(Banco.class);
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
		buildVigente();
		buildHoja();
		buildPrimeraFila();
		buildUltimaFila();
		buildFecha();
		buildDescripcion();
		buildReferencia1();
		buildImporte();
		buildReferencia2();
		buildSaldo();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(nombre);
		form.add(cuit);
		form.add(vigente);
		form.add(hoja);
		form.add(primeraFila);
		form.add(ultimaFila);
		form.add(fecha);
		form.add(descripcion);
		form.add(referencia1);
		form.add(importe);
		form.add(referencia2);
		form.add(saldo);
		
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
		// Nº banco
		numero = new NumberField();
		numero.setLabel("Nº banco");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº banco es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Banco::getNumero, Banco::setNumero);
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
			.bind(Banco::getNombre, Banco::setNombre);
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
			.bind(Banco::getCuit, Banco::setCuit);
	}

	private void buildVigente() throws Exception {
		// Vigente
		vigente = new Checkbox();
		vigente.setLabel("Vigente");
		vigente.setWidthFull();
		binder.forField(vigente)
			.bind(Banco::getVigente, Banco::setVigente);
	}

	private void buildHoja() throws Exception {
		// Hoja
		hoja = new NumberField();
		hoja.setLabel("Hoja");
		hoja.setWidthFull();
		hoja.setClearButtonVisible(true);
		hoja.setMin(1);
		hoja.setMax(100);
		binder.forField(hoja)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= 100 : true,"El valor tiene que ser <= " + 100)
			.bind(Banco::getHoja, Banco::setHoja);
	}

	private void buildPrimeraFila() throws Exception {
		// Primera fila
		primeraFila = new NumberField();
		primeraFila.setLabel("Primera fila");
		primeraFila.setWidthFull();
		primeraFila.setClearButtonVisible(true);
		primeraFila.setMin(1);
		primeraFila.setMax(1000);
		binder.forField(primeraFila)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= 1000 : true,"El valor tiene que ser <= " + 1000)
			.bind(Banco::getPrimeraFila, Banco::setPrimeraFila);
	}

	private void buildUltimaFila() throws Exception {
		// Última fila
		ultimaFila = new NumberField();
		ultimaFila.setLabel("Última fila");
		ultimaFila.setWidthFull();
		ultimaFila.setClearButtonVisible(true);
		ultimaFila.setMin(1);
		ultimaFila.setMax(1000);
		binder.forField(ultimaFila)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= 1000 : true,"El valor tiene que ser <= " + 1000)
			.bind(Banco::getUltimaFila, Banco::setUltimaFila);
	}

	private void buildFecha() throws Exception {
		// Fecha
		fecha = new TextField();
		fecha.setLabel("Fecha");
		fecha.setWidthFull();
		fecha.setClearButtonVisible(true);
		fecha.setAutoselect(true);
		binder.forField(fecha)
			.withValidator(value -> (value != null) ? value.length() <= 3 : true, "El valor tiene que contener menos de 3 caracteres")
			.bind(Banco::getFecha, Banco::setFecha);
	}

	private void buildDescripcion() throws Exception {
		// Descripción
		descripcion = new TextField();
		descripcion.setLabel("Descripción");
		descripcion.setWidthFull();
		descripcion.setClearButtonVisible(true);
		descripcion.setAutoselect(true);
		binder.forField(descripcion)
			.withValidator(value -> (value != null) ? value.length() <= 3 : true, "El valor tiene que contener menos de 3 caracteres")
			.bind(Banco::getDescripcion, Banco::setDescripcion);
	}

	private void buildReferencia1() throws Exception {
		// Referencia 1
		referencia1 = new TextField();
		referencia1.setLabel("Referencia 1");
		referencia1.setWidthFull();
		referencia1.setClearButtonVisible(true);
		referencia1.setAutoselect(true);
		binder.forField(referencia1)
			.withValidator(value -> (value != null) ? value.length() <= 3 : true, "El valor tiene que contener menos de 3 caracteres")
			.bind(Banco::getReferencia1, Banco::setReferencia1);
	}

	private void buildImporte() throws Exception {
		// Importe
		importe = new TextField();
		importe.setLabel("Importe");
		importe.setWidthFull();
		importe.setClearButtonVisible(true);
		importe.setAutoselect(true);
		binder.forField(importe)
			.withValidator(value -> (value != null) ? value.length() <= 3 : true, "El valor tiene que contener menos de 3 caracteres")
			.bind(Banco::getImporte, Banco::setImporte);
	}

	private void buildReferencia2() throws Exception {
		// Referencia 2
		referencia2 = new TextField();
		referencia2.setLabel("Referencia 2");
		referencia2.setWidthFull();
		referencia2.setClearButtonVisible(true);
		referencia2.setAutoselect(true);
		binder.forField(referencia2)
			.withValidator(value -> (value != null) ? value.length() <= 3 : true, "El valor tiene que contener menos de 3 caracteres")
			.bind(Banco::getReferencia2, Banco::setReferencia2);
	}

	private void buildSaldo() throws Exception {
		// Saldo
		saldo = new TextField();
		saldo.setLabel("Saldo");
		saldo.setWidthFull();
		saldo.setClearButtonVisible(true);
		saldo.setAutoselect(true);
		binder.forField(saldo)
			.withValidator(value -> (value != null) ? value.length() <= 3 : true, "El valor tiene que contener menos de 3 caracteres")
			.bind(Banco::getSaldo, Banco::setSaldo);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<Banco> validate = binder.validate();
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
				BinderValidationStatus<Banco> validate = binder.validate();
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