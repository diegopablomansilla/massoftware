package com.massoftware.service.logistica;

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
import com.massoftware.service.geo.Ciudad;
import com.massoftware.ui.util.DoubleToBigDecimalConverter;


@PageTitle("Tarifa de transporte")
@Route("TransporteTarifa")
public class UITransporteTarifaView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private TransporteTarifa item;
	private Binder<TransporteTarifa> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private ComboBox<Carga> carga;
	private ComboBox<Ciudad> ciudad;
	private NumberField precioFlete;
	private NumberField precioUnidadFacturacion;
	private NumberField precioUnidadStock;
	private NumberField precioBultos;
	private NumberField importeMinimoEntrega;
	private NumberField importeMinimoCarga;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UITransporteTarifaView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new TransporteTarifa();
		binder = new Binder<>(TransporteTarifa.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº opción ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº opción ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº opción es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TransporteTarifa::getNumero, TransporteTarifa::setNumero);

		//-------------------------------------------------------------------
		// Carga
		carga = new ComboBox<>();
		carga.setRequired(true);
		carga.setPlaceholder("Carga");
		binder.forField(carga)
			.asRequired("Carga es requerido.")		
			.bind(TransporteTarifa::getCarga, TransporteTarifa::setCarga);

		//-------------------------------------------------------------------
		// Ciudad
		ciudad = new ComboBox<>();
		ciudad.setRequired(true);
		ciudad.setPlaceholder("Ciudad");
		binder.forField(ciudad)
			.asRequired("Ciudad es requerido.")		
			.bind(TransporteTarifa::getCiudad, TransporteTarifa::setCiudad);

		//-------------------------------------------------------------------
		// Precio flete ()
		precioFlete = new NumberField();
		precioFlete.setMin(-9999.9999);
		precioFlete.setMax(99999.9999);
		precioFlete.setPlaceholder("Precio flete ");
		precioFlete.setPrefixComponent(VaadinIcon.SEARCH.create());
		precioFlete.setClearButtonVisible(true);
		binder.forField(precioFlete)
			.asRequired("Precio flete es requerido.")		
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(TransporteTarifa::getPrecioFlete, TransporteTarifa::setPrecioFlete);

		//-------------------------------------------------------------------
		// Precio unidad facturación ()
		precioUnidadFacturacion = new NumberField();
		precioUnidadFacturacion.setMin(-9999.9999);
		precioUnidadFacturacion.setMax(99999.9999);
		precioUnidadFacturacion.setPlaceholder("Precio unidad facturación ");
		precioUnidadFacturacion.setPrefixComponent(VaadinIcon.SEARCH.create());
		precioUnidadFacturacion.setClearButtonVisible(true);
		binder.forField(precioUnidadFacturacion)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(TransporteTarifa::getPrecioUnidadFacturacion, TransporteTarifa::setPrecioUnidadFacturacion);

		//-------------------------------------------------------------------
		// Precio unidad stock ()
		precioUnidadStock = new NumberField();
		precioUnidadStock.setMin(-9999.9999);
		precioUnidadStock.setMax(99999.9999);
		precioUnidadStock.setPlaceholder("Precio unidad stock ");
		precioUnidadStock.setPrefixComponent(VaadinIcon.SEARCH.create());
		precioUnidadStock.setClearButtonVisible(true);
		binder.forField(precioUnidadStock)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(TransporteTarifa::getPrecioUnidadStock, TransporteTarifa::setPrecioUnidadStock);

		//-------------------------------------------------------------------
		// Precio bultos ()
		precioBultos = new NumberField();
		precioBultos.setMin(-9999.9999);
		precioBultos.setMax(99999.9999);
		precioBultos.setPlaceholder("Precio bultos ");
		precioBultos.setPrefixComponent(VaadinIcon.SEARCH.create());
		precioBultos.setClearButtonVisible(true);
		binder.forField(precioBultos)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(TransporteTarifa::getPrecioBultos, TransporteTarifa::setPrecioBultos);

		//-------------------------------------------------------------------
		// Importe mínimo por entrega ()
		importeMinimoEntrega = new NumberField();
		importeMinimoEntrega.setMin(-9999.9999);
		importeMinimoEntrega.setMax(99999.9999);
		importeMinimoEntrega.setPlaceholder("Importe mínimo por entrega ");
		importeMinimoEntrega.setPrefixComponent(VaadinIcon.SEARCH.create());
		importeMinimoEntrega.setClearButtonVisible(true);
		binder.forField(importeMinimoEntrega)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(TransporteTarifa::getImporteMinimoEntrega, TransporteTarifa::setImporteMinimoEntrega);

		//-------------------------------------------------------------------
		// Importe mínimo por carga ()
		importeMinimoCarga = new NumberField();
		importeMinimoCarga.setMin(-9999.9999);
		importeMinimoCarga.setMax(99999.9999);
		importeMinimoCarga.setPlaceholder("Importe mínimo por carga ");
		importeMinimoCarga.setPrefixComponent(VaadinIcon.SEARCH.create());
		importeMinimoCarga.setClearButtonVisible(true);
		binder.forField(importeMinimoCarga)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(TransporteTarifa::getImporteMinimoCarga, TransporteTarifa::setImporteMinimoCarga);
	

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
		form.add(numero, carga, ciudad, precioFlete, precioUnidadFacturacion, precioUnidadStock, precioBultos, importeMinimoEntrega, importeMinimoCarga);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			TransporteTarifaService service = new TransporteTarifaService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}