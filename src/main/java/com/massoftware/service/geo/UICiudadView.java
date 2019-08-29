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


@PageTitle("Ciudad")
@Route("Ciudad")
public class UICiudadView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private Ciudad item;
	private Binder<Ciudad> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private TextField departamento;
	private NumberField numeroAFIP;
	private ComboBox<Provincia> provincia;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UICiudadView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new Ciudad();
		binder = new Binder<>(Ciudad.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº ciudad ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº ciudad ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº ciudad es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Ciudad::getNumero, Ciudad::setNumero);

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
			.bind(Ciudad::getNombre, Ciudad::setNombre);

		//-------------------------------------------------------------------
		// Departamento
		departamento = new TextField();
		departamento.setPlaceholder("Departamento");
		departamento.setPrefixComponent(VaadinIcon.SEARCH.create());
		departamento.setWidthFull();
		departamento.setClearButtonVisible(true);
		departamento.setAutoselect(true);
		binder.forField(departamento)
			.bind(Ciudad::getDepartamento, Ciudad::setDepartamento);

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
			.bind(Ciudad::getNumeroAFIP, Ciudad::setNumeroAFIP);

		//-------------------------------------------------------------------
		// Provincia
		provincia = new ComboBox<>();
		provincia.setRequired(true);
		provincia.setPlaceholder("Provincia");
		binder.forField(provincia)
			.asRequired("Provincia es requerido.")		
			.bind(Ciudad::getProvincia, Ciudad::setProvincia);
	

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
		form.add(numero, nombre, departamento, numeroAFIP, provincia);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			CiudadService service = new CiudadService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}