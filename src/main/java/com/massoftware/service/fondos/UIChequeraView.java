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


@PageTitle("Chequera")
@Route("Chequera")
public class UIChequeraView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private Chequera item;
	private Binder<Chequera> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private ComboBox<CuentaFondo> cuentaFondo;
	private NumberField primerNumero;
	private NumberField ultimoNumero;
	private NumberField proximoNumero;
	private ComboBox<FBoolean> bloqueado;
	private ComboBox<FBoolean> impresionDiferida;
	private TextField formato;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIChequeraView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new Chequera();
		binder = new Binder<>(Chequera.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº chequera ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº chequera ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº chequera es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Chequera::getNumero, Chequera::setNumero);

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
			.bind(Chequera::getNombre, Chequera::setNombre);

		//-------------------------------------------------------------------
		// Cuenta fondo
		cuentaFondo = new ComboBox<>();
		cuentaFondo.setRequired(true);
		cuentaFondo.setPlaceholder("Cuenta fondo");
		binder.forField(cuentaFondo)
			.asRequired("Cuenta fondo es requerido.")		
			.bind(Chequera::getCuentaFondo, Chequera::setCuentaFondo);

		//-------------------------------------------------------------------
		// Primer número ()
		primerNumero = new NumberField();
		primerNumero.setMin(0);
		primerNumero.setMax(Integer.MAX_VALUE);
		primerNumero.setPlaceholder("Primer número ");
		primerNumero.setPrefixComponent(VaadinIcon.SEARCH.create());
		primerNumero.setClearButtonVisible(true);
		binder.forField(primerNumero)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Chequera::getPrimerNumero, Chequera::setPrimerNumero);

		//-------------------------------------------------------------------
		// Último número ()
		ultimoNumero = new NumberField();
		ultimoNumero.setMin(0);
		ultimoNumero.setMax(Integer.MAX_VALUE);
		ultimoNumero.setPlaceholder("Último número ");
		ultimoNumero.setPrefixComponent(VaadinIcon.SEARCH.create());
		ultimoNumero.setClearButtonVisible(true);
		binder.forField(ultimoNumero)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Chequera::getUltimoNumero, Chequera::setUltimoNumero);

		//-------------------------------------------------------------------
		// Próximo número ()
		proximoNumero = new NumberField();
		proximoNumero.setMin(0);
		proximoNumero.setMax(Integer.MAX_VALUE);
		proximoNumero.setPlaceholder("Próximo número ");
		proximoNumero.setPrefixComponent(VaadinIcon.SEARCH.create());
		proximoNumero.setClearButtonVisible(true);
		binder.forField(proximoNumero)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Chequera::getProximoNumero, Chequera::setProximoNumero);

		//-------------------------------------------------------------------
		// Obsoleto

		//-------------------------------------------------------------------
		// Impresión diferida

		//-------------------------------------------------------------------
		// Formato
		formato = new TextField();
		formato.setPlaceholder("Formato");
		formato.setPrefixComponent(VaadinIcon.SEARCH.create());
		formato.setWidthFull();
		formato.setClearButtonVisible(true);
		formato.setAutoselect(true);
		binder.forField(formato)
			.bind(Chequera::getFormato, Chequera::setFormato);
	

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
		form.add(numero, nombre, cuentaFondo, primerNumero, ultimoNumero, proximoNumero, bloqueado, impresionDiferida, formato);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			ChequeraService service = new ChequeraService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}