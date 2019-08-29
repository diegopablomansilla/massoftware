package com.massoftware.service.contabilidad;

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


@PageTitle("Centro de costo")
@Route("CentroCostoContable")
public class UICentroCostoContableView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private CentroCostoContable item;
	private Binder<CentroCostoContable> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private TextField abreviatura;
	private ComboBox<EjercicioContable> ejercicioContable;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UICentroCostoContableView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new CentroCostoContable();
		binder = new Binder<>(CentroCostoContable.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº cc ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº cc ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº cc es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(CentroCostoContable::getNumero, CentroCostoContable::setNumero);

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
			.bind(CentroCostoContable::getNombre, CentroCostoContable::setNombre);

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
			.bind(CentroCostoContable::getAbreviatura, CentroCostoContable::setAbreviatura);

		//-------------------------------------------------------------------
		// Ejercicio
		ejercicioContable = new ComboBox<>();
		ejercicioContable.setRequired(true);
		ejercicioContable.setPlaceholder("Ejercicio");
		binder.forField(ejercicioContable)
			.asRequired("Ejercicio es requerido.")		
			.bind(CentroCostoContable::getEjercicioContable, CentroCostoContable::setEjercicioContable);
	

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
		form.add(numero, nombre, abreviatura, ejercicioContable);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			CentroCostoContableService service = new CentroCostoContableService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}