package com.massoftware.service.logistica;

//import com.vaadin.flow.component.Key;
//import com.vaadin.flow.component.KeyModifier;
//import com.vaadin.flow.component.icon.VaadinIcon;
import java.util.Optional;
import java.util.stream.Collectors;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
//import com.vaadin.flow.data.validator.StringLengthValidator;
//import com.vaadin.flow.data.validator.IntegerRangeValidator;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;
import com.massoftware.service.geo.Ciudad;
import com.massoftware.service.geo.CiudadService;
import com.massoftware.ui.util.DoubleToBigDecimalConverter;


@PageTitle("Tarifa de transporte")
@Route("TransporteTarifa")
public class UITransporteTarifaView extends VerticalLayout implements HasUrlParameter<String> {

	private TransporteTarifaService service;		

	// Binder
	private TransporteTarifa item;
	private Binder<TransporteTarifa> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private ComboBox<Carga> carga;
	private ComboBox<Ciudad> ciudad;
	private NumberField precioFlete;
	private NumberField precioUnidadFacturacion;
	private NumberField precioUnidadStock;
	private NumberField precioBultos;
	private NumberField importeMinimoEntrega;
	private NumberField importeMinimoCarga;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UITransporteTarifaView() throws Exception {
		service = new TransporteTarifaService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new TransporteTarifa();
		binder = new Binder<>(TransporteTarifa.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildNumero();
		buildCarga();
		buildCiudad();
		buildPrecioFlete();
		buildPrecioUnidadFacturacion();
		buildPrecioUnidadStock();
		buildPrecioBultos();
		buildImporteMinimoEntrega();
		buildImporteMinimoCarga();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(carga);
		form.add(ciudad);
		form.add(precioFlete);
		form.add(precioUnidadFacturacion);
		form.add(precioUnidadStock);
		form.add(precioBultos);
		form.add(importeMinimoEntrega);
		form.add(importeMinimoCarga);
		
		actions = new HorizontalLayout();
		actions.add(save);
		add(actions);
				
		// -------------------------------------------------------------------
	}
	
	private void buildSave() throws Exception {		
		save = new Button("Guardar");
		save.addClickListener(event -> {
			save();
		});		
	}	
	

	private void buildNumero() throws Exception {
		// Nº opción
		numero = new NumberField();
		numero.setLabel("Nº opción");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº opción es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TransporteTarifa::getNumero, TransporteTarifa::setNumero);
	}

	private void buildCarga() throws Exception {
		// Carga
		carga = new ComboBox<>();
		carga.setLabel("Carga");
		carga.setWidthFull();
		carga.setRequired(true);
		List<Carga> items = new CargaService().find();
		carga.setItems(items);
		binder.forField(carga)
			.asRequired("Carga es requerido.")		
			.bind(TransporteTarifa::getCarga, TransporteTarifa::setCarga);
	}

	private void buildCiudad() throws Exception {
		// Ciudad
		ciudad = new ComboBox<>();
		ciudad.setLabel("Ciudad");
		ciudad.setWidthFull();
		ciudad.setRequired(true);
		List<Ciudad> items = new CiudadService().find();
		ciudad.setItems(items);
		binder.forField(ciudad)
			.asRequired("Ciudad es requerido.")		
			.bind(TransporteTarifa::getCiudad, TransporteTarifa::setCiudad);
	}

	private void buildPrecioFlete() throws Exception {
		// Precio flete
		precioFlete = new NumberField();
		precioFlete.setLabel("Precio flete");
		precioFlete.setWidthFull();
		precioFlete.setClearButtonVisible(true);
		precioFlete.setMin(-9999.9999);
		precioFlete.setMax(99999.9999);
		binder.forField(precioFlete)
			.asRequired("Precio flete es requerido.")		
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(TransporteTarifa::getPrecioFlete, TransporteTarifa::setPrecioFlete);
	}

	private void buildPrecioUnidadFacturacion() throws Exception {
		// Precio unidad facturación
		precioUnidadFacturacion = new NumberField();
		precioUnidadFacturacion.setLabel("Precio unidad facturación");
		precioUnidadFacturacion.setWidthFull();
		precioUnidadFacturacion.setClearButtonVisible(true);
		precioUnidadFacturacion.setMin(-9999.9999);
		precioUnidadFacturacion.setMax(99999.9999);
		binder.forField(precioUnidadFacturacion)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(TransporteTarifa::getPrecioUnidadFacturacion, TransporteTarifa::setPrecioUnidadFacturacion);
	}

	private void buildPrecioUnidadStock() throws Exception {
		// Precio unidad stock
		precioUnidadStock = new NumberField();
		precioUnidadStock.setLabel("Precio unidad stock");
		precioUnidadStock.setWidthFull();
		precioUnidadStock.setClearButtonVisible(true);
		precioUnidadStock.setMin(-9999.9999);
		precioUnidadStock.setMax(99999.9999);
		binder.forField(precioUnidadStock)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(TransporteTarifa::getPrecioUnidadStock, TransporteTarifa::setPrecioUnidadStock);
	}

	private void buildPrecioBultos() throws Exception {
		// Precio bultos
		precioBultos = new NumberField();
		precioBultos.setLabel("Precio bultos");
		precioBultos.setWidthFull();
		precioBultos.setClearButtonVisible(true);
		precioBultos.setMin(-9999.9999);
		precioBultos.setMax(99999.9999);
		binder.forField(precioBultos)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(TransporteTarifa::getPrecioBultos, TransporteTarifa::setPrecioBultos);
	}

	private void buildImporteMinimoEntrega() throws Exception {
		// Importe mínimo por entrega
		importeMinimoEntrega = new NumberField();
		importeMinimoEntrega.setLabel("Importe mínimo por entrega");
		importeMinimoEntrega.setWidthFull();
		importeMinimoEntrega.setClearButtonVisible(true);
		importeMinimoEntrega.setMin(-9999.9999);
		importeMinimoEntrega.setMax(99999.9999);
		binder.forField(importeMinimoEntrega)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(TransporteTarifa::getImporteMinimoEntrega, TransporteTarifa::setImporteMinimoEntrega);
	}

	private void buildImporteMinimoCarga() throws Exception {
		// Importe mínimo por carga
		importeMinimoCarga = new NumberField();
		importeMinimoCarga.setLabel("Importe mínimo por carga");
		importeMinimoCarga.setWidthFull();
		importeMinimoCarga.setClearButtonVisible(true);
		importeMinimoCarga.setMin(-9999.9999);
		importeMinimoCarga.setMax(99999.9999);
		binder.forField(importeMinimoCarga)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(TransporteTarifa::getImporteMinimoCarga, TransporteTarifa::setImporteMinimoCarga);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<TransporteTarifa> validate = binder.validate();
		        String errorText = validate.getFieldValidationStatuses()
		                .stream().filter(BindingValidationStatus::isError)
		                .map(BindingValidationStatus::getMessage)
		                .map(Optional::get).distinct()
		                .collect(Collectors.joining(", "));
		        
		        Notification.show("Uno o mas valores del ítem son incorrectos." + errorText);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}
	
	public void save() {

		try {

			binder.validate();

			if (binder.isValid()) {								
				item = service.update(item);
				Notification.show("El ítem '" + item + "' se guardo con éxito !");
				search(item.getId());
			} else {								
				BinderValidationStatus<TransporteTarifa> validate = binder.validate();
		        String errorText = validate.getFieldValidationStatuses()
		                .stream().filter(BindingValidationStatus::isError)
		                .map(BindingValidationStatus::getMessage)
		                .map(Optional::get).distinct()
		                .collect(Collectors.joining(", "));
		        
		        Notification.show("Uno o mas valores del ítem son incorrectos." + errorText);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo guardar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}