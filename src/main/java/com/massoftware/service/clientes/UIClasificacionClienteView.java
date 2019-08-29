package com.massoftware.service.clientes;

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


@PageTitle("Clasificación de cliente")
@Route("ClasificacionCliente")
public class UIClasificacionClienteView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private ClasificacionCliente item;
	private Binder<ClasificacionCliente> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private NumberField color;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIClasificacionClienteView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new ClasificacionCliente();
		binder = new Binder<>(ClasificacionCliente.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº clasificación ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº clasificación ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº clasificación es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(ClasificacionCliente::getNumero, ClasificacionCliente::setNumero);

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
			.bind(ClasificacionCliente::getNombre, ClasificacionCliente::setNombre);

		//-------------------------------------------------------------------
		// Color ()
		color = new NumberField();
		color.setMin(1);
		color.setMax(Integer.MAX_VALUE);
		color.setPlaceholder("Color ");
		color.setPrefixComponent(VaadinIcon.SEARCH.create());
		color.setClearButtonVisible(true);
		binder.forField(color)
			.asRequired("Color es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(ClasificacionCliente::getColor, ClasificacionCliente::setColor);
	

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
		form.add(numero, nombre, color);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			ClasificacionClienteService service = new ClasificacionClienteService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}