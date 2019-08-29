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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;
import com.massoftware.service.empresa.Sucursal;


@PageTitle("Asiento contable")
@Route("AsientoContable")
public class UIAsientoContableView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private AsientoContable item;
	private Binder<AsientoContable> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private DatePicker fecha;
	private TextField detalle;
	private ComboBox<EjercicioContable> ejercicioContable;
	private ComboBox<MinutaContable> minutaContable;
	private ComboBox<Sucursal> sucursal;
	private ComboBox<AsientoContableModulo> asientoContableModulo;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIAsientoContableView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new AsientoContable();
		binder = new Binder<>(AsientoContable.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº asiento ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº asiento ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº asiento es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(AsientoContable::getNumero, AsientoContable::setNumero);

		//-------------------------------------------------------------------
		// Detalle
		detalle = new TextField();
		detalle.setPlaceholder("Detalle");
		detalle.setPrefixComponent(VaadinIcon.SEARCH.create());
		detalle.setWidthFull();
		detalle.setClearButtonVisible(true);
		detalle.setAutoselect(true);
		binder.forField(detalle)
			.bind(AsientoContable::getDetalle, AsientoContable::setDetalle);

		//-------------------------------------------------------------------
		// Ejercicio
		ejercicioContable = new ComboBox<>();
		ejercicioContable.setRequired(true);
		ejercicioContable.setPlaceholder("Ejercicio");
		binder.forField(ejercicioContable)
			.asRequired("Ejercicio es requerido.")		
			.bind(AsientoContable::getEjercicioContable, AsientoContable::setEjercicioContable);

		//-------------------------------------------------------------------
		// Minuta contable
		minutaContable = new ComboBox<>();
		minutaContable.setRequired(true);
		minutaContable.setPlaceholder("Minuta contable");
		binder.forField(minutaContable)
			.asRequired("Minuta contable es requerido.")		
			.bind(AsientoContable::getMinutaContable, AsientoContable::setMinutaContable);

		//-------------------------------------------------------------------
		// Sucursal
		sucursal = new ComboBox<>();
		sucursal.setRequired(true);
		sucursal.setPlaceholder("Sucursal");
		binder.forField(sucursal)
			.asRequired("Sucursal es requerido.")		
			.bind(AsientoContable::getSucursal, AsientoContable::setSucursal);

		//-------------------------------------------------------------------
		// Módulo
		asientoContableModulo = new ComboBox<>();
		asientoContableModulo.setRequired(true);
		asientoContableModulo.setPlaceholder("Módulo");
		binder.forField(asientoContableModulo)
			.asRequired("Módulo es requerido.")		
			.bind(AsientoContable::getAsientoContableModulo, AsientoContable::setAsientoContableModulo);
	

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
		form.add(numero, fecha, detalle, ejercicioContable, minutaContable, sucursal, asientoContableModulo);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			AsientoContableService service = new AsientoContableService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}