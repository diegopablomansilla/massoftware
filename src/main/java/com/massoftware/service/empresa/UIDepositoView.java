package com.massoftware.service.empresa;

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
import com.massoftware.service.seguridad.SeguridadPuerta;


@PageTitle("Depósito")
@Route("Deposito")
public class UIDepositoView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private Deposito item;
	private Binder<Deposito> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private TextField abreviatura;
	private ComboBox<Sucursal> sucursal;
	private ComboBox<DepositoModulo> depositoModulo;
	private ComboBox<SeguridadPuerta> puertaOperativo;
	private ComboBox<SeguridadPuerta> puertaConsulta;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIDepositoView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new Deposito();
		binder = new Binder<>(Deposito.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº depósito ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº depósito ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº depósito es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Deposito::getNumero, Deposito::setNumero);

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
			.bind(Deposito::getNombre, Deposito::setNombre);

		//-------------------------------------------------------------------
		// Abreviatura
		abreviatura = new TextField();
		abreviatura.setRequired(true);
		abreviatura.setPlaceholder("Abreviatura");
		abreviatura.setPrefixComponent(VaadinIcon.SEARCH.create());
		abreviatura.setWidthFull();
		abreviatura.setClearButtonVisible(true);
		abreviatura.setAutoselect(true);
		binder.forField(abreviatura)
			.asRequired("Abreviatura es requerido.")		
			.bind(Deposito::getAbreviatura, Deposito::setAbreviatura);

		//-------------------------------------------------------------------
		// Sucursal
		sucursal = new ComboBox<>();
		sucursal.setRequired(true);
		sucursal.setPlaceholder("Sucursal");
		binder.forField(sucursal)
			.asRequired("Sucursal es requerido.")		
			.bind(Deposito::getSucursal, Deposito::setSucursal);

		//-------------------------------------------------------------------
		// Módulo
		depositoModulo = new ComboBox<>();
		depositoModulo.setRequired(true);
		depositoModulo.setPlaceholder("Módulo");
		binder.forField(depositoModulo)
			.asRequired("Módulo es requerido.")		
			.bind(Deposito::getDepositoModulo, Deposito::setDepositoModulo);

		//-------------------------------------------------------------------
		// Puerta operativo
		puertaOperativo = new ComboBox<>();
		puertaOperativo.setRequired(true);
		puertaOperativo.setPlaceholder("Puerta operativo");
		binder.forField(puertaOperativo)
			.asRequired("Puerta operativo es requerido.")		
			.bind(Deposito::getPuertaOperativo, Deposito::setPuertaOperativo);

		//-------------------------------------------------------------------
		// Puerta consulta
		puertaConsulta = new ComboBox<>();
		puertaConsulta.setRequired(true);
		puertaConsulta.setPlaceholder("Puerta consulta");
		binder.forField(puertaConsulta)
			.asRequired("Puerta consulta es requerido.")		
			.bind(Deposito::getPuertaConsulta, Deposito::setPuertaConsulta);
	

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
		form.add(numero, nombre, abreviatura, sucursal, depositoModulo, puertaOperativo, puertaConsulta);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			DepositoService service = new DepositoService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}