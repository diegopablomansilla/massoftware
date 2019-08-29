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

import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;


@PageTitle("Código postal")
@Route("CodigoPostal")
public class UICodigoPostalView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private CodigoPostal item;
	private Binder<CodigoPostal> binder;

	// Filter control
	private FormLayout form;

	
	private TextField codigo;
	private NumberField numero;
	private TextField nombreCalle;
	private TextField numeroCalle;
	private ComboBox<Ciudad> ciudad;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UICodigoPostalView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new CodigoPostal();
		binder = new Binder<>(CodigoPostal.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Código
		codigo = new TextField();
		codigo.setRequired(true);
		codigo.setPlaceholder("Código");
		codigo.setPrefixComponent(VaadinIcon.SEARCH.create());
		codigo.setWidthFull();
		codigo.setClearButtonVisible(true);
		codigo.setAutoselect(true);
		binder.forField(codigo)
			.asRequired("Código es requerido.")		
			.bind(CodigoPostal::getCodigo, CodigoPostal::setCodigo);

		//-------------------------------------------------------------------
		// Secuencia ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Secuencia ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Secuencia es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(CodigoPostal::getNumero, CodigoPostal::setNumero);

		//-------------------------------------------------------------------
		// Calle
		nombreCalle = new TextField();
		nombreCalle.setRequired(true);
		nombreCalle.setPlaceholder("Calle");
		nombreCalle.setPrefixComponent(VaadinIcon.SEARCH.create());
		nombreCalle.setWidthFull();
		nombreCalle.setClearButtonVisible(true);
		nombreCalle.setAutoselect(true);
		binder.forField(nombreCalle)
			.asRequired("Calle es requerido.")		
			.bind(CodigoPostal::getNombreCalle, CodigoPostal::setNombreCalle);

		//-------------------------------------------------------------------
		// Número calle
		numeroCalle = new TextField();
		numeroCalle.setRequired(true);
		numeroCalle.setPlaceholder("Número calle");
		numeroCalle.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroCalle.setWidthFull();
		numeroCalle.setClearButtonVisible(true);
		numeroCalle.setAutoselect(true);
		binder.forField(numeroCalle)
			.asRequired("Número calle es requerido.")		
			.bind(CodigoPostal::getNumeroCalle, CodigoPostal::setNumeroCalle);

		//-------------------------------------------------------------------
		// Ciudad
		ciudad = new ComboBox<>();
		ciudad.setRequired(true);
		ciudad.setPlaceholder("Ciudad");
		binder.forField(ciudad)
			.asRequired("Ciudad es requerido.")		
			.bind(CodigoPostal::getCiudad, CodigoPostal::setCiudad);
	

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
		form.add(codigo, numero, nombreCalle, numeroCalle, ciudad);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			CodigoPostalService service = new CodigoPostalService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}