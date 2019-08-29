package com.massoftware.service.fondos;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;
import com.massoftware.service.FBoolean;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.massoftware.ui.util.DoubleToLongConverter;


@PageTitle("Talonario")
@Route("Talonario")
public class UITalonarioView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private Talonario item;
	private Binder<Talonario> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private ComboBox<TalonarioLetra> talonarioLetra;
	private NumberField puntoVenta;
	private ComboBox<FBoolean> autonumeracion;
	private ComboBox<FBoolean> numeracionPreImpresa;
	private ComboBox<FBoolean> asociadoRG10098;
	private ComboBox<TalonarioControladorFizcal> talonarioControladorFizcal;
	private NumberField primerNumero;
	private NumberField proximoNumero;
	private NumberField ultimoNumero;
	private NumberField cantidadMinimaComprobantes;
	private DatePicker fecha;
	private NumberField numeroCAI;
	private DatePicker vencimiento;
	private NumberField diasAvisoVencimiento;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UITalonarioView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new Talonario();
		binder = new Binder<>(Talonario.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº talonario ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº talonario ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº talonario es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Talonario::getNumero, Talonario::setNumero);

		//-------------------------------------------------------------------
		// Nombre
		nombre = new TextField();
		nombre.setRequired(true);
		nombre.setPlaceholder("Nombre");
		nombre.setPrefixComponent(VaadinIcon.SEARCH.create());
		nombre.setWidthFull();
		nombre.setClearButtonVisible(true);
		nombre.setAutoselect(true);
		binder.forField(nombre)
			.asRequired("Nombre es requerido.")		
			.bind(Talonario::getNombre, Talonario::setNombre);

		//-------------------------------------------------------------------
		// Letra
		talonarioLetra = new ComboBox<>();
		talonarioLetra.setRequired(true);
		talonarioLetra.setPlaceholder("Letra");
		binder.forField(talonarioLetra)
			.asRequired("Letra es requerido.")		
			.bind(Talonario::getTalonarioLetra, Talonario::setTalonarioLetra);

		//-------------------------------------------------------------------
		// Punto de venta ()
		puntoVenta = new NumberField();
		puntoVenta.setMin(1);
		puntoVenta.setMax(9999);
		puntoVenta.setPlaceholder("Punto de venta ");
		puntoVenta.setPrefixComponent(VaadinIcon.SEARCH.create());
		puntoVenta.setClearButtonVisible(true);
		binder.forField(puntoVenta)
			.asRequired("Punto de venta es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= 9999 : true,"El valor tiene que ser <= " + 9999)
			.bind(Talonario::getPuntoVenta, Talonario::setPuntoVenta);

		//-------------------------------------------------------------------
		// Autonumeración

		//-------------------------------------------------------------------
		// Numeración pre-impresa

		//-------------------------------------------------------------------
		// Asociado al RG 100/98

		//-------------------------------------------------------------------
		// Asociado a controlador fizcal
		talonarioControladorFizcal = new ComboBox<>();
		talonarioControladorFizcal.setRequired(true);
		talonarioControladorFizcal.setPlaceholder("Asociado a controlador fizcal");
		binder.forField(talonarioControladorFizcal)
			.asRequired("Asociado a controlador fizcal es requerido.")		
			.bind(Talonario::getTalonarioControladorFizcal, Talonario::setTalonarioControladorFizcal);

		//-------------------------------------------------------------------
		// Primer nº ()
		primerNumero = new NumberField();
		primerNumero.setMin(1);
		primerNumero.setMax(Integer.MAX_VALUE);
		primerNumero.setPlaceholder("Primer nº ");
		primerNumero.setPrefixComponent(VaadinIcon.SEARCH.create());
		primerNumero.setClearButtonVisible(true);
		binder.forField(primerNumero)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Talonario::getPrimerNumero, Talonario::setPrimerNumero);

		//-------------------------------------------------------------------
		// Próximo nº ()
		proximoNumero = new NumberField();
		proximoNumero.setMin(1);
		proximoNumero.setMax(Integer.MAX_VALUE);
		proximoNumero.setPlaceholder("Próximo nº ");
		proximoNumero.setPrefixComponent(VaadinIcon.SEARCH.create());
		proximoNumero.setClearButtonVisible(true);
		binder.forField(proximoNumero)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Talonario::getProximoNumero, Talonario::setProximoNumero);

		//-------------------------------------------------------------------
		// Último nº ()
		ultimoNumero = new NumberField();
		ultimoNumero.setMin(1);
		ultimoNumero.setMax(Integer.MAX_VALUE);
		ultimoNumero.setPlaceholder("Último nº ");
		ultimoNumero.setPrefixComponent(VaadinIcon.SEARCH.create());
		ultimoNumero.setClearButtonVisible(true);
		binder.forField(ultimoNumero)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Talonario::getUltimoNumero, Talonario::setUltimoNumero);

		//-------------------------------------------------------------------
		// Cant. min. cbtes. ()
		cantidadMinimaComprobantes = new NumberField();
		cantidadMinimaComprobantes.setMin(1);
		cantidadMinimaComprobantes.setMax(Integer.MAX_VALUE);
		cantidadMinimaComprobantes.setPlaceholder("Cant. min. cbtes. ");
		cantidadMinimaComprobantes.setPrefixComponent(VaadinIcon.SEARCH.create());
		cantidadMinimaComprobantes.setClearButtonVisible(true);
		binder.forField(cantidadMinimaComprobantes)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Talonario::getCantidadMinimaComprobantes, Talonario::setCantidadMinimaComprobantes);

		//-------------------------------------------------------------------
		// Nº C.A.I ()
		numeroCAI = new NumberField();
		numeroCAI.setMin(1L);
		numeroCAI.setMax(99999999999999L);
		numeroCAI.setPlaceholder("Nº C.A.I ");
		numeroCAI.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroCAI.setClearButtonVisible(true);
		binder.forField(numeroCAI)
			.withConverter(new DoubleToLongConverter())
			.withValidator(value -> (value != null) ? value >= 1L : true, "El valor tiene que ser >= 1L")
			.withValidator(value -> (value != null) ? value <= 99999999999999L : true,"El valor tiene que ser <= " + 99999999999999L)
			.bind(Talonario::getNumeroCAI, Talonario::setNumeroCAI);

		//-------------------------------------------------------------------
		// Días aviso vto. ()
		diasAvisoVencimiento = new NumberField();
		diasAvisoVencimiento.setMin(1);
		diasAvisoVencimiento.setMax(Integer.MAX_VALUE);
		diasAvisoVencimiento.setPlaceholder("Días aviso vto. ");
		diasAvisoVencimiento.setPrefixComponent(VaadinIcon.SEARCH.create());
		diasAvisoVencimiento.setClearButtonVisible(true);
		binder.forField(diasAvisoVencimiento)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Talonario::getDiasAvisoVencimiento, Talonario::setDiasAvisoVencimiento);
	

		// -------------------------------------------------------------------

		// Button New ítem
//		newBTN = new Button();
//		UIUtils.setTooltip("Nuevo", newBTN);
//		newBTN.setIcon(VaadinIcon.PLUS.create());

		// Button Search ítem's
//		findBTN = new Button();
//		UIUtils.setTooltip("Buscar", findBTN);
//		findBTN.setIcon(VaadinIcon.SEARCH.create());
//		findBTN.addClickListener(event -> {
//			search();
//		});

		// Layout ------------------------

		form = new FormLayout();
		form.setWidthFull();

		add(form);

//		form.add(newBTN, numeroFrom, numeroTo, nombre, findBTN);
		form.add(numero, nombre, talonarioLetra, puntoVenta, autonumeracion, numeracionPreImpresa, asociadoRG10098, talonarioControladorFizcal, primerNumero, proximoNumero, ultimoNumero, cantidadMinimaComprobantes, fecha, numeroCAI, vencimiento, diasAvisoVencimiento);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			TalonarioService service = new TalonarioService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}