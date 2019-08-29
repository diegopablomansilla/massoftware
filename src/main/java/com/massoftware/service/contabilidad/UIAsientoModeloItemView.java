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
import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;


@PageTitle("Item de asiento modelo")
@Route("AsientoModeloItem")
public class UIAsientoModeloItemView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private AsientoModeloItem item;
	private Binder<AsientoModeloItem> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private ComboBox<AsientoModelo> asientoModelo;
	private ComboBox<CuentaContable> cuentaContable;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIAsientoModeloItemView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new AsientoModeloItem();
		binder = new Binder<>(AsientoModeloItem.class);
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
			.bind(AsientoModeloItem::getNumero, AsientoModeloItem::setNumero);

		//-------------------------------------------------------------------
		// Asiento modelo
		asientoModelo = new ComboBox<>();
		asientoModelo.setRequired(true);
		asientoModelo.setPlaceholder("Asiento modelo");
		binder.forField(asientoModelo)
			.asRequired("Asiento modelo es requerido.")		
			.bind(AsientoModeloItem::getAsientoModelo, AsientoModeloItem::setAsientoModelo);

		//-------------------------------------------------------------------
		// Cuenta contable
		cuentaContable = new ComboBox<>();
		cuentaContable.setRequired(true);
		cuentaContable.setPlaceholder("Cuenta contable");
		binder.forField(cuentaContable)
			.asRequired("Cuenta contable es requerido.")		
			.bind(AsientoModeloItem::getCuentaContable, AsientoModeloItem::setCuentaContable);
	

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
		form.add(numero, asientoModelo, cuentaContable);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			AsientoModeloItemService service = new AsientoModeloItemService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}