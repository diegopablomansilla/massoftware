package com.massoftware.service.monedas;

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
import com.massoftware.ui.util.DoubleToBigDecimalConverter;
import com.vaadin.flow.component.combobox.ComboBox;
import com.massoftware.service.FBoolean;
import java.util.List;
import com.massoftware.service.afip.MonedaAFIP;


@PageTitle("Moneda")
@Route("Moneda")
public class UIMonedaView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private Moneda item;
	private Binder<Moneda> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private TextField abreviatura;
	private NumberField cotizacion;
	private ComboBox<FBoolean> controlActualizacion;
	private ComboBox<MonedaAFIP> monedaAFIP;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIMonedaView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new Moneda();
		binder = new Binder<>(Moneda.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº moneda ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº moneda ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº moneda es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Moneda::getNumero, Moneda::setNumero);

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
			.bind(Moneda::getNombre, Moneda::setNombre);

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
			.bind(Moneda::getAbreviatura, Moneda::setAbreviatura);

		//-------------------------------------------------------------------
		// Cotización ()
		cotizacion = new NumberField();
		cotizacion.setMin(-9999.9999);
		cotizacion.setMax(99999.9999);
		cotizacion.setPlaceholder("Cotización ");
		cotizacion.setPrefixComponent(VaadinIcon.SEARCH.create());
		cotizacion.setClearButtonVisible(true);
		binder.forField(cotizacion)
			.asRequired("Cotización es requerido.")		
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(Moneda::getCotizacion, Moneda::setCotizacion);

		//-------------------------------------------------------------------
		// Control de actualizacion

		//-------------------------------------------------------------------
		// Moneda AFIP
		monedaAFIP = new ComboBox<>();
		monedaAFIP.setRequired(true);
		monedaAFIP.setPlaceholder("Moneda AFIP");
		binder.forField(monedaAFIP)
			.asRequired("Moneda AFIP es requerido.")		
			.bind(Moneda::getMonedaAFIP, Moneda::setMonedaAFIP);
	

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
		form.add(numero, nombre, abreviatura, cotizacion, controlActualizacion, monedaAFIP);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			MonedaService service = new MonedaService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}