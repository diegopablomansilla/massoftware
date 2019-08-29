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
import com.massoftware.ui.util.DoubleToBigDecimalConverter;


@PageTitle("Item de asiento contable")
@Route("AsientoContableItem")
public class UIAsientoContableItemView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private AsientoContableItem item;
	private Binder<AsientoContableItem> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private DatePicker fecha;
	private TextField detalle;
	private ComboBox<AsientoContable> asientoContable;
	private ComboBox<CuentaContable> cuentaContable;
	private NumberField debe;
	private NumberField haber;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIAsientoContableItemView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new AsientoContableItem();
		binder = new Binder<>(AsientoContableItem.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº item ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº item ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº item es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(AsientoContableItem::getNumero, AsientoContableItem::setNumero);

		//-------------------------------------------------------------------
		// Detalle
		detalle = new TextField();
		detalle.setPlaceholder("Detalle");
		detalle.setPrefixComponent(VaadinIcon.SEARCH.create());
		detalle.setWidthFull();
		detalle.setClearButtonVisible(true);
		detalle.setAutoselect(true);
		binder.forField(detalle)
			.bind(AsientoContableItem::getDetalle, AsientoContableItem::setDetalle);

		//-------------------------------------------------------------------
		// Asiento contable
		asientoContable = new ComboBox<>();
		asientoContable.setRequired(true);
		asientoContable.setPlaceholder("Asiento contable");
		binder.forField(asientoContable)
			.asRequired("Asiento contable es requerido.")		
			.bind(AsientoContableItem::getAsientoContable, AsientoContableItem::setAsientoContable);

		//-------------------------------------------------------------------
		// Cuenta contable
		cuentaContable = new ComboBox<>();
		cuentaContable.setRequired(true);
		cuentaContable.setPlaceholder("Cuenta contable");
		binder.forField(cuentaContable)
			.asRequired("Cuenta contable es requerido.")		
			.bind(AsientoContableItem::getCuentaContable, AsientoContableItem::setCuentaContable);

		//-------------------------------------------------------------------
		// Debe ()
		debe = new NumberField();
		debe.setPlaceholder("Debe ");
		debe.setPrefixComponent(VaadinIcon.SEARCH.create());
		debe.setClearButtonVisible(true);
		binder.forField(debe)
			.asRequired("Debe es requerido.")		
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(AsientoContableItem::getDebe, AsientoContableItem::setDebe);

		//-------------------------------------------------------------------
		// Haber ()
		haber = new NumberField();
		haber.setPlaceholder("Haber ");
		haber.setPrefixComponent(VaadinIcon.SEARCH.create());
		haber.setClearButtonVisible(true);
		binder.forField(haber)
			.asRequired("Haber es requerido.")		
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(AsientoContableItem::getHaber, AsientoContableItem::setHaber);
	

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
		form.add(numero, fecha, detalle, asientoContable, cuentaContable, debe, haber);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			AsientoContableItemService service = new AsientoContableItemService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}