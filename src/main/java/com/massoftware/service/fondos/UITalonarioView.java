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
import com.vaadin.flow.component.datepicker.DatePicker;
import java.util.Locale;
import com.massoftware.service.UIDatePickerI18n_es_AR;
import com.massoftware.ui.util.DoubleToLongConverter;


@PageTitle("Talonario")
@Route("Talonario")
public class UITalonarioView extends VerticalLayout implements HasUrlParameter<String> {

	private TalonarioService service;		

	// Binder
	private Talonario item;
	private Binder<Talonario> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private TextField nombre;
	private ComboBox<TalonarioLetra> talonarioLetra;
	private NumberField puntoVenta;
	private Checkbox autonumeracion;
	private Checkbox numeracionPreImpresa;
	private Checkbox asociadoRG10098;
	private ComboBox<TalonarioControladorFizcal> talonarioControladorFizcal;
	private NumberField primerNumero;
	private NumberField proximoNumero;
	private NumberField ultimoNumero;
	private NumberField cantidadMinimaComprobantes;
	private DatePicker fecha;
	private NumberField numeroCAI;
	private DatePicker vencimiento;
	private NumberField diasAvisoVencimiento;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UITalonarioView() throws Exception {
		service = new TalonarioService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new Talonario();
		binder = new Binder<>(Talonario.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildNumero();
		buildNombre();
		buildTalonarioLetra();
		buildPuntoVenta();
		buildAutonumeracion();
		buildNumeracionPreImpresa();
		buildAsociadoRG10098();
		buildTalonarioControladorFizcal();
		buildPrimerNumero();
		buildProximoNumero();
		buildUltimoNumero();
		buildCantidadMinimaComprobantes();
		buildFecha();
		buildNumeroCAI();
		buildVencimiento();
		buildDiasAvisoVencimiento();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(nombre);
		form.add(talonarioLetra);
		form.add(puntoVenta);
		form.add(autonumeracion);
		form.add(numeracionPreImpresa);
		form.add(asociadoRG10098);
		form.add(talonarioControladorFizcal);
		form.add(primerNumero);
		form.add(proximoNumero);
		form.add(ultimoNumero);
		form.add(cantidadMinimaComprobantes);
		form.add(fecha);
		form.add(numeroCAI);
		form.add(vencimiento);
		form.add(diasAvisoVencimiento);
		
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
		// Nº talonario
		numero = new NumberField();
		numero.setLabel("Nº talonario");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº talonario es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Talonario::getNumero, Talonario::setNumero);
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
			.bind(Talonario::getNombre, Talonario::setNombre);
	}

	private void buildTalonarioLetra() throws Exception {
		// Letra
		talonarioLetra = new ComboBox<>();
		talonarioLetra.setLabel("Letra");
		talonarioLetra.setWidthFull();
		talonarioLetra.setRequired(true);
		List<TalonarioLetra> items = new TalonarioLetraService().find();
		talonarioLetra.setItems(items);
		binder.forField(talonarioLetra)
			.asRequired("Letra es requerido.")		
			.bind(Talonario::getTalonarioLetra, Talonario::setTalonarioLetra);
	}

	private void buildPuntoVenta() throws Exception {
		// Punto de venta
		puntoVenta = new NumberField();
		puntoVenta.setLabel("Punto de venta");
		puntoVenta.setWidthFull();
		puntoVenta.setClearButtonVisible(true);
		puntoVenta.setMin(1);
		puntoVenta.setMax(9999);
		binder.forField(puntoVenta)
			.asRequired("Punto de venta es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= 9999 : true,"El valor tiene que ser <= " + 9999)
			.bind(Talonario::getPuntoVenta, Talonario::setPuntoVenta);
	}

	private void buildAutonumeracion() throws Exception {
		// Autonumeración
		autonumeracion = new Checkbox();
		autonumeracion.setLabel("Autonumeración");
		autonumeracion.setWidthFull();
		binder.forField(autonumeracion)
			.bind(Talonario::getAutonumeracion, Talonario::setAutonumeracion);
	}

	private void buildNumeracionPreImpresa() throws Exception {
		// Numeración pre-impresa
		numeracionPreImpresa = new Checkbox();
		numeracionPreImpresa.setLabel("Numeración pre-impresa");
		numeracionPreImpresa.setWidthFull();
		binder.forField(numeracionPreImpresa)
			.bind(Talonario::getNumeracionPreImpresa, Talonario::setNumeracionPreImpresa);
	}

	private void buildAsociadoRG10098() throws Exception {
		// Asociado al RG 100/98
		asociadoRG10098 = new Checkbox();
		asociadoRG10098.setLabel("Asociado al RG 100/98");
		asociadoRG10098.setWidthFull();
		binder.forField(asociadoRG10098)
			.bind(Talonario::getAsociadoRG10098, Talonario::setAsociadoRG10098);
	}

	private void buildTalonarioControladorFizcal() throws Exception {
		// Asociado a controlador fizcal
		talonarioControladorFizcal = new ComboBox<>();
		talonarioControladorFizcal.setLabel("Asociado a controlador fizcal");
		talonarioControladorFizcal.setWidthFull();
		talonarioControladorFizcal.setRequired(true);
		List<TalonarioControladorFizcal> items = new TalonarioControladorFizcalService().find();
		talonarioControladorFizcal.setItems(items);
		binder.forField(talonarioControladorFizcal)
			.asRequired("Asociado a controlador fizcal es requerido.")		
			.bind(Talonario::getTalonarioControladorFizcal, Talonario::setTalonarioControladorFizcal);
	}

	private void buildPrimerNumero() throws Exception {
		// Primer nº
		primerNumero = new NumberField();
		primerNumero.setLabel("Primer nº");
		primerNumero.setWidthFull();
		primerNumero.setClearButtonVisible(true);
		primerNumero.setMin(1);
		primerNumero.setMax(Integer.MAX_VALUE);
		binder.forField(primerNumero)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Talonario::getPrimerNumero, Talonario::setPrimerNumero);
	}

	private void buildProximoNumero() throws Exception {
		// Próximo nº
		proximoNumero = new NumberField();
		proximoNumero.setLabel("Próximo nº");
		proximoNumero.setWidthFull();
		proximoNumero.setClearButtonVisible(true);
		proximoNumero.setMin(1);
		proximoNumero.setMax(Integer.MAX_VALUE);
		binder.forField(proximoNumero)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Talonario::getProximoNumero, Talonario::setProximoNumero);
	}

	private void buildUltimoNumero() throws Exception {
		// Último nº
		ultimoNumero = new NumberField();
		ultimoNumero.setLabel("Último nº");
		ultimoNumero.setWidthFull();
		ultimoNumero.setClearButtonVisible(true);
		ultimoNumero.setMin(1);
		ultimoNumero.setMax(Integer.MAX_VALUE);
		binder.forField(ultimoNumero)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Talonario::getUltimoNumero, Talonario::setUltimoNumero);
	}

	private void buildCantidadMinimaComprobantes() throws Exception {
		// Cant. min. cbtes.
		cantidadMinimaComprobantes = new NumberField();
		cantidadMinimaComprobantes.setLabel("Cant. min. cbtes.");
		cantidadMinimaComprobantes.setWidthFull();
		cantidadMinimaComprobantes.setClearButtonVisible(true);
		cantidadMinimaComprobantes.setMin(1);
		cantidadMinimaComprobantes.setMax(Integer.MAX_VALUE);
		binder.forField(cantidadMinimaComprobantes)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Talonario::getCantidadMinimaComprobantes, Talonario::setCantidadMinimaComprobantes);
	}

	private void buildFecha() throws Exception {
		// Fecha
		fecha = new DatePicker();
		fecha.setLabel("Fecha");
		fecha.setWidthFull();
		fecha.setLocale(new Locale("es_AR"));
		fecha.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(fecha)
			.bind(Talonario::getFecha, Talonario::setFecha);
	}

	private void buildNumeroCAI() throws Exception {
		// Nº C.A.I
		numeroCAI = new NumberField();
		numeroCAI.setLabel("Nº C.A.I");
		numeroCAI.setWidthFull();
		numeroCAI.setClearButtonVisible(true);
		numeroCAI.setMin(1L);
		numeroCAI.setMax(99999999999999L);
		binder.forField(numeroCAI)
			.withConverter(new DoubleToLongConverter())
			.withValidator(value -> (value != null) ? value >= 1L : true, "El valor tiene que ser >= 1L")
			.withValidator(value -> (value != null) ? value <= 99999999999999L : true,"El valor tiene que ser <= " + 99999999999999L)
			.bind(Talonario::getNumeroCAI, Talonario::setNumeroCAI);
	}

	private void buildVencimiento() throws Exception {
		// Vencimiento C.A.I
		vencimiento = new DatePicker();
		vencimiento.setLabel("Vencimiento C.A.I");
		vencimiento.setWidthFull();
		vencimiento.setLocale(new Locale("es_AR"));
		vencimiento.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(vencimiento)
			.bind(Talonario::getVencimiento, Talonario::setVencimiento);
	}

	private void buildDiasAvisoVencimiento() throws Exception {
		// Días aviso vto.
		diasAvisoVencimiento = new NumberField();
		diasAvisoVencimiento.setLabel("Días aviso vto.");
		diasAvisoVencimiento.setWidthFull();
		diasAvisoVencimiento.setClearButtonVisible(true);
		diasAvisoVencimiento.setMin(1);
		diasAvisoVencimiento.setMax(Integer.MAX_VALUE);
		binder.forField(diasAvisoVencimiento)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Talonario::getDiasAvisoVencimiento, Talonario::setDiasAvisoVencimiento);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<Talonario> validate = binder.validate();
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
				BinderValidationStatus<Talonario> validate = binder.validate();
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