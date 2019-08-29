package com.massoftware.service.fondos;

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
import com.massoftware.service.FBoolean;
import java.util.List;


@PageTitle("Modelo de comprobante de fondo")
@Route("ComprobanteFondoModeloItem")
public class UIComprobanteFondoModeloItemView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private ComprobanteFondoModeloItem item;
	private Binder<ComprobanteFondoModeloItem> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private ComboBox<FBoolean> debe;
	private ComboBox<ComprobanteFondoModelo> comprobanteFondoModelo;
	private ComboBox<CuentaFondo> cuentaFondo;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIComprobanteFondoModeloItemView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new ComprobanteFondoModeloItem();
		binder = new Binder<>(ComprobanteFondoModeloItem.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº modelo ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº modelo ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº modelo es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(ComprobanteFondoModeloItem::getNumero, ComprobanteFondoModeloItem::setNumero);

		//-------------------------------------------------------------------
		// Debe

		//-------------------------------------------------------------------
		// Modelo
		comprobanteFondoModelo = new ComboBox<>();
		comprobanteFondoModelo.setRequired(true);
		comprobanteFondoModelo.setPlaceholder("Modelo");
		binder.forField(comprobanteFondoModelo)
			.asRequired("Modelo es requerido.")		
			.bind(ComprobanteFondoModeloItem::getComprobanteFondoModelo, ComprobanteFondoModeloItem::setComprobanteFondoModelo);

		//-------------------------------------------------------------------
		// Cuenta fondo
		cuentaFondo = new ComboBox<>();
		cuentaFondo.setRequired(true);
		cuentaFondo.setPlaceholder("Cuenta fondo");
		binder.forField(cuentaFondo)
			.asRequired("Cuenta fondo es requerido.")		
			.bind(ComprobanteFondoModeloItem::getCuentaFondo, ComprobanteFondoModeloItem::setCuentaFondo);
	

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
		form.add(numero, debe, comprobanteFondoModelo, cuentaFondo);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			ComprobanteFondoModeloItemService service = new ComprobanteFondoModeloItemService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}