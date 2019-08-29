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
import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;


@PageTitle("Motivo bloqueo a cliente")
@Route("MotivoBloqueoCliente")
public class UIMotivoBloqueoClienteView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private MotivoBloqueoCliente item;
	private Binder<MotivoBloqueoCliente> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private ComboBox<ClasificacionCliente> clasificacionCliente;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIMotivoBloqueoClienteView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new MotivoBloqueoCliente();
		binder = new Binder<>(MotivoBloqueoCliente.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº motivo ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº motivo ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº motivo es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(MotivoBloqueoCliente::getNumero, MotivoBloqueoCliente::setNumero);

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
			.bind(MotivoBloqueoCliente::getNombre, MotivoBloqueoCliente::setNombre);

		//-------------------------------------------------------------------
		// Clasificación de cliente
		clasificacionCliente = new ComboBox<>();
		clasificacionCliente.setRequired(true);
		clasificacionCliente.setPlaceholder("Clasificación de cliente");
		binder.forField(clasificacionCliente)
			.asRequired("Clasificación de cliente es requerido.")		
			.bind(MotivoBloqueoCliente::getClasificacionCliente, MotivoBloqueoCliente::setClasificacionCliente);
	

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
		form.add(numero, nombre, clasificacionCliente);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			MotivoBloqueoClienteService service = new MotivoBloqueoClienteService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}