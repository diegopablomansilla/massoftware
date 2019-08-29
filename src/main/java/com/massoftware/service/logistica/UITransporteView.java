package com.massoftware.service.logistica;

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
import com.massoftware.ui.util.DoubleToLongConverter;
import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;
import com.massoftware.service.geo.CodigoPostal;


@PageTitle("Transporte")
@Route("Transporte")
public class UITransporteView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private Transporte item;
	private Binder<Transporte> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private NumberField cuit;
	private TextField ingresosBrutos;
	private TextField telefono;
	private TextField fax;
	private ComboBox<CodigoPostal> codigoPostal;
	private TextField domicilio;
	private TextField comentario;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UITransporteView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new Transporte();
		binder = new Binder<>(Transporte.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº transporte ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº transporte ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº transporte es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Transporte::getNumero, Transporte::setNumero);

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
			.bind(Transporte::getNombre, Transporte::setNombre);

		//-------------------------------------------------------------------
		// CUIT ()
		cuit = new NumberField();
		cuit.setMin(1L);
		cuit.setMax(99999999999L);
		cuit.setPlaceholder("CUIT ");
		cuit.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuit.setClearButtonVisible(true);
		binder.forField(cuit)
			.asRequired("CUIT es requerido.")		
			.withConverter(new DoubleToLongConverter())
			.withValidator(value -> (value != null) ? value >= 1L : true, "El valor tiene que ser >= 1L")
			.withValidator(value -> (value != null) ? value <= 99999999999L : true,"El valor tiene que ser <= " + 99999999999L)
			.bind(Transporte::getCuit, Transporte::setCuit);

		//-------------------------------------------------------------------
		// Ingresos brutos
		ingresosBrutos = new TextField();
		ingresosBrutos.setPlaceholder("Ingresos brutos");
		ingresosBrutos.setPrefixComponent(VaadinIcon.SEARCH.create());
		ingresosBrutos.setWidthFull();
		ingresosBrutos.setClearButtonVisible(true);
		ingresosBrutos.setAutoselect(true);
		binder.forField(ingresosBrutos)
			.bind(Transporte::getIngresosBrutos, Transporte::setIngresosBrutos);

		//-------------------------------------------------------------------
		// Teléfono
		telefono = new TextField();
		telefono.setPlaceholder("Teléfono");
		telefono.setPrefixComponent(VaadinIcon.SEARCH.create());
		telefono.setWidthFull();
		telefono.setClearButtonVisible(true);
		telefono.setAutoselect(true);
		binder.forField(telefono)
			.bind(Transporte::getTelefono, Transporte::setTelefono);

		//-------------------------------------------------------------------
		// Fax
		fax = new TextField();
		fax.setPlaceholder("Fax");
		fax.setPrefixComponent(VaadinIcon.SEARCH.create());
		fax.setWidthFull();
		fax.setClearButtonVisible(true);
		fax.setAutoselect(true);
		binder.forField(fax)
			.bind(Transporte::getFax, Transporte::setFax);

		//-------------------------------------------------------------------
		// Código postal
		codigoPostal = new ComboBox<>();
		codigoPostal.setRequired(true);
		codigoPostal.setPlaceholder("Código postal");
		binder.forField(codigoPostal)
			.asRequired("Código postal es requerido.")		
			.bind(Transporte::getCodigoPostal, Transporte::setCodigoPostal);

		//-------------------------------------------------------------------
		// Domicilio
		domicilio = new TextField();
		domicilio.setPlaceholder("Domicilio");
		domicilio.setPrefixComponent(VaadinIcon.SEARCH.create());
		domicilio.setWidthFull();
		domicilio.setClearButtonVisible(true);
		domicilio.setAutoselect(true);
		binder.forField(domicilio)
			.bind(Transporte::getDomicilio, Transporte::setDomicilio);

		//-------------------------------------------------------------------
		// Comentario
		comentario = new TextField();
		comentario.setPlaceholder("Comentario");
		comentario.setPrefixComponent(VaadinIcon.SEARCH.create());
		comentario.setWidthFull();
		comentario.setClearButtonVisible(true);
		comentario.setAutoselect(true);
		binder.forField(comentario)
			.bind(Transporte::getComentario, Transporte::setComentario);
	

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
		form.add(numero, nombre, cuit, ingresosBrutos, telefono, fax, codigoPostal, domicilio, comentario);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			TransporteService service = new TransporteService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}