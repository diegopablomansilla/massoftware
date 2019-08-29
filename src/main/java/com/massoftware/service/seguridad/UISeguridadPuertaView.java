package com.massoftware.service.seguridad;

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


@PageTitle("Puerta")
@Route("SeguridadPuerta")
public class UISeguridadPuertaView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private SeguridadPuerta item;
	private Binder<SeguridadPuerta> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private TextField equate;
	private ComboBox<SeguridadModulo> seguridadModulo;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UISeguridadPuertaView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new SeguridadPuerta();
		binder = new Binder<>(SeguridadPuerta.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº puerta ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº puerta ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº puerta es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(SeguridadPuerta::getNumero, SeguridadPuerta::setNumero);

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
			.bind(SeguridadPuerta::getNombre, SeguridadPuerta::setNombre);

		//-------------------------------------------------------------------
		// I.D
		equate = new TextField();
		equate.setRequired(true);
		equate.setPlaceholder("I.D");
		equate.setPrefixComponent(VaadinIcon.SEARCH.create());
		equate.setWidthFull();
		equate.setClearButtonVisible(true);
		equate.setAutoselect(true);
		binder.forField(equate)
			.asRequired("I.D es requerido.")		
			.bind(SeguridadPuerta::getEquate, SeguridadPuerta::setEquate);

		//-------------------------------------------------------------------
		// Módulo
		seguridadModulo = new ComboBox<>();
		seguridadModulo.setRequired(true);
		seguridadModulo.setPlaceholder("Módulo");
		binder.forField(seguridadModulo)
			.asRequired("Módulo es requerido.")		
			.bind(SeguridadPuerta::getSeguridadModulo, SeguridadPuerta::setSeguridadModulo);
	

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
		form.add(numero, nombre, equate, seguridadModulo);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			SeguridadPuertaService service = new SeguridadPuertaService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}