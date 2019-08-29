package com.massoftware.service.monedas;

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
import com.massoftware.ui.util.DoubleToBigDecimalConverter;
import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;
import com.massoftware.service.seguridad.Usuario;


@PageTitle("Cotización de moneda")
@Route("MonedaCotizacion")
public class UIMonedaCotizacionView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private MonedaCotizacion item;
	private Binder<MonedaCotizacion> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField compra;
	private NumberField venta;
	private ComboBox<Moneda> moneda;
	private ComboBox<Usuario> usuario;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UIMonedaCotizacionView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new MonedaCotizacion();
		binder = new Binder<>(MonedaCotizacion.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Compra ()
		compra = new NumberField();
		compra.setMin(-9999.9999);
		compra.setMax(99999.9999);
		compra.setPlaceholder("Compra ");
		compra.setPrefixComponent(VaadinIcon.SEARCH.create());
		compra.setClearButtonVisible(true);
		binder.forField(compra)
			.asRequired("Compra es requerido.")		
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(MonedaCotizacion::getCompra, MonedaCotizacion::setCompra);

		//-------------------------------------------------------------------
		// Venta ()
		venta = new NumberField();
		venta.setMin(-9999.9999);
		venta.setMax(99999.9999);
		venta.setPlaceholder("Venta ");
		venta.setPrefixComponent(VaadinIcon.SEARCH.create());
		venta.setClearButtonVisible(true);
		binder.forField(venta)
			.asRequired("Venta es requerido.")		
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(MonedaCotizacion::getVenta, MonedaCotizacion::setVenta);

		//-------------------------------------------------------------------
		// Moneda
		moneda = new ComboBox<>();
		moneda.setRequired(true);
		moneda.setPlaceholder("Moneda");
		binder.forField(moneda)
			.asRequired("Moneda es requerido.")		
			.bind(MonedaCotizacion::getMoneda, MonedaCotizacion::setMoneda);

		//-------------------------------------------------------------------
		// Usuario
		usuario = new ComboBox<>();
		usuario.setRequired(true);
		usuario.setPlaceholder("Usuario");
		binder.forField(usuario)
			.asRequired("Usuario es requerido.")		
			.bind(MonedaCotizacion::getUsuario, MonedaCotizacion::setUsuario);
	

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
		form.add(compra, venta, moneda, usuario);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			MonedaCotizacionService service = new MonedaCotizacionService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}