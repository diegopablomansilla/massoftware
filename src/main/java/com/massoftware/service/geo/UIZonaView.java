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


@PageTitle("Zona")
@Route("Zona")
public class UIZonaView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private Zona item;
	private Binder<Zona> binder;

	// Filter control
	private FormLayout form;

	
	private TextField codigo;
	private TextField nombre;
	private NumberField bonificacion;
	private NumberField recargo;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIZonaView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new Zona();
		binder = new Binder<>(Zona.class);
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
			.bind(Zona::getCodigo, Zona::setCodigo);

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
			.bind(Zona::getNombre, Zona::setNombre);

		//-------------------------------------------------------------------
		// Bonificación ()
		bonificacion = new NumberField();
		bonificacion.setMin(0.0);
		bonificacion.setMax(99999.9999);
		bonificacion.setPlaceholder("Bonificación ");
		bonificacion.setPrefixComponent(VaadinIcon.SEARCH.create());
		bonificacion.setClearButtonVisible(true);
		binder.forField(bonificacion)
			.withValidator(value -> (value != null) ? value >= 0.0 : true, "El valor tiene que ser >= 0.0")
			.withValidator(value -> (value != null) ? value <= 99999.9999 : true,"El valor tiene que ser <= " + 99999.9999)
			.bind(Zona::getBonificacion, Zona::setBonificacion);

		//-------------------------------------------------------------------
		// Recargo ()
		recargo = new NumberField();
		recargo.setMin(0.0);
		recargo.setMax(99999.9999);
		recargo.setPlaceholder("Recargo ");
		recargo.setPrefixComponent(VaadinIcon.SEARCH.create());
		recargo.setClearButtonVisible(true);
		binder.forField(recargo)
			.withValidator(value -> (value != null) ? value >= 0.0 : true, "El valor tiene que ser >= 0.0")
			.withValidator(value -> (value != null) ? value <= 99999.9999 : true,"El valor tiene que ser <= " + 99999.9999)
			.bind(Zona::getRecargo, Zona::setRecargo);
	

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
		form.add(codigo, nombre, bonificacion, recargo);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			ZonaService service = new ZonaService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}