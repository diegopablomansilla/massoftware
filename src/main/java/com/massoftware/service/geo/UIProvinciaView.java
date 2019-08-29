package com.massoftware.service.geo;

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


@PageTitle("Provincia")
@Route("Provincia")
public class UIProvinciaView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private Provincia item;
	private Binder<Provincia> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private TextField abreviatura;
	private NumberField numeroAFIP;
	private NumberField numeroIngresosBrutos;
	private NumberField numeroRENATEA;
	private ComboBox<Pais> pais;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIProvinciaView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new Provincia();
		binder = new Binder<>(Provincia.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº provincia ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº provincia ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº provincia es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Provincia::getNumero, Provincia::setNumero);

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
			.bind(Provincia::getNombre, Provincia::setNombre);

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
			.bind(Provincia::getAbreviatura, Provincia::setAbreviatura);

		//-------------------------------------------------------------------
		// Nº provincia AFIP ()
		numeroAFIP = new NumberField();
		numeroAFIP.setMin(1);
		numeroAFIP.setMax(Integer.MAX_VALUE);
		numeroAFIP.setPlaceholder("Nº provincia AFIP ");
		numeroAFIP.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroAFIP.setClearButtonVisible(true);
		binder.forField(numeroAFIP)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Provincia::getNumeroAFIP, Provincia::setNumeroAFIP);

		//-------------------------------------------------------------------
		// Nº provincia ingresos brutos ()
		numeroIngresosBrutos = new NumberField();
		numeroIngresosBrutos.setMin(1);
		numeroIngresosBrutos.setMax(Integer.MAX_VALUE);
		numeroIngresosBrutos.setPlaceholder("Nº provincia ingresos brutos ");
		numeroIngresosBrutos.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroIngresosBrutos.setClearButtonVisible(true);
		binder.forField(numeroIngresosBrutos)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Provincia::getNumeroIngresosBrutos, Provincia::setNumeroIngresosBrutos);

		//-------------------------------------------------------------------
		// Nº provincia RENATEA ()
		numeroRENATEA = new NumberField();
		numeroRENATEA.setMin(1);
		numeroRENATEA.setMax(Integer.MAX_VALUE);
		numeroRENATEA.setPlaceholder("Nº provincia RENATEA ");
		numeroRENATEA.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroRENATEA.setClearButtonVisible(true);
		binder.forField(numeroRENATEA)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Provincia::getNumeroRENATEA, Provincia::setNumeroRENATEA);

		//-------------------------------------------------------------------
		// País
		pais = new ComboBox<>();
		pais.setRequired(true);
		pais.setPlaceholder("País");
		binder.forField(pais)
			.asRequired("País es requerido.")		
			.bind(Provincia::getPais, Provincia::setPais);
	

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
		form.add(numero, nombre, abreviatura, numeroAFIP, numeroIngresosBrutos, numeroRENATEA, pais);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			ProvinciaService service = new ProvinciaService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}