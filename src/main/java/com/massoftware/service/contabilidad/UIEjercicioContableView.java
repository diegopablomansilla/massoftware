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
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.combobox.ComboBox;
import com.massoftware.service.FBoolean;
import com.vaadin.flow.component.textfield.TextField;


@PageTitle("Ejercicio")
@Route("EjercicioContable")
public class UIEjercicioContableView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private EjercicioContable item;
	private Binder<EjercicioContable> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private DatePicker apertura;
	private DatePicker cierre;
	private ComboBox<FBoolean> cerrado;
	private ComboBox<FBoolean> cerradoModulos;
	private TextField comentario;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIEjercicioContableView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new EjercicioContable();
		binder = new Binder<>(EjercicioContable.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº ejercicio ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº ejercicio ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº ejercicio es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(EjercicioContable::getNumero, EjercicioContable::setNumero);

		//-------------------------------------------------------------------
		// Cerrado

		//-------------------------------------------------------------------
		// Cerrado módulos

		//-------------------------------------------------------------------
		// Coemntario
		comentario = new TextField();
		comentario.setPlaceholder("Coemntario");
		comentario.setPrefixComponent(VaadinIcon.SEARCH.create());
		comentario.setWidthFull();
		comentario.setClearButtonVisible(true);
		comentario.setAutoselect(true);
		binder.forField(comentario)
			.bind(EjercicioContable::getComentario, EjercicioContable::setComentario);
	

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
		form.add(numero, apertura, cierre, cerrado, cerradoModulos, comentario);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			EjercicioContableService service = new EjercicioContableService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}