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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;
import com.massoftware.service.FBoolean;


@PageTitle("Ticket modelo")
@Route("TicketModelo")
public class UITicketModeloView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private TicketModelo item;
	private Binder<TicketModelo> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private ComboBox<Ticket> ticket;
	private TextField pruebaLectura;
	private ComboBox<FBoolean> activo;
	private NumberField longitudLectura;
	private NumberField identificacionPosicion;
	private NumberField identificacion;
	private NumberField importePosicion;
	private NumberField longitud;
	private NumberField cantidadDecimales;
	private NumberField numeroPosicion;
	private NumberField numeroLongitud;
	private TextField prefijoIdentificacion;
	private NumberField posicionPrefijo;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UITicketModeloView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new TicketModelo();
		binder = new Binder<>(TicketModelo.class);
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
			.bind(TicketModelo::getNumero, TicketModelo::setNumero);

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
			.bind(TicketModelo::getNombre, TicketModelo::setNombre);

		//-------------------------------------------------------------------
		// ticket
		ticket = new ComboBox<>();
		ticket.setRequired(true);
		ticket.setPlaceholder("ticket");
		binder.forField(ticket)
			.asRequired("ticket es requerido.")		
			.bind(TicketModelo::getTicket, TicketModelo::setTicket);

		//-------------------------------------------------------------------
		// Prueba lectura
		pruebaLectura = new TextField();
		pruebaLectura.setPlaceholder("Prueba lectura");
		pruebaLectura.setPrefixComponent(VaadinIcon.SEARCH.create());
		pruebaLectura.setWidthFull();
		pruebaLectura.setClearButtonVisible(true);
		pruebaLectura.setAutoselect(true);
		binder.forField(pruebaLectura)
			.bind(TicketModelo::getPruebaLectura, TicketModelo::setPruebaLectura);

		//-------------------------------------------------------------------
		// activo

		//-------------------------------------------------------------------
		// Longitud lectura ()
		longitudLectura = new NumberField();
		longitudLectura.setMin(0);
		longitudLectura.setMax(Integer.MAX_VALUE);
		longitudLectura.setPlaceholder("Longitud lectura ");
		longitudLectura.setPrefixComponent(VaadinIcon.SEARCH.create());
		longitudLectura.setClearButtonVisible(true);
		binder.forField(longitudLectura)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getLongitudLectura, TicketModelo::setLongitudLectura);

		//-------------------------------------------------------------------
		// Posición ()
		identificacionPosicion = new NumberField();
		identificacionPosicion.setMin(0);
		identificacionPosicion.setMax(Integer.MAX_VALUE);
		identificacionPosicion.setPlaceholder("Posición ");
		identificacionPosicion.setPrefixComponent(VaadinIcon.SEARCH.create());
		identificacionPosicion.setClearButtonVisible(true);
		binder.forField(identificacionPosicion)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getIdentificacionPosicion, TicketModelo::setIdentificacionPosicion);

		//-------------------------------------------------------------------
		// Identificación ()
		identificacion = new NumberField();
		identificacion.setMin(0);
		identificacion.setMax(Integer.MAX_VALUE);
		identificacion.setPlaceholder("Identificación ");
		identificacion.setPrefixComponent(VaadinIcon.SEARCH.create());
		identificacion.setClearButtonVisible(true);
		binder.forField(identificacion)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getIdentificacion, TicketModelo::setIdentificacion);

		//-------------------------------------------------------------------
		// Posición ()
		importePosicion = new NumberField();
		importePosicion.setMin(0);
		importePosicion.setMax(Integer.MAX_VALUE);
		importePosicion.setPlaceholder("Posición ");
		importePosicion.setPrefixComponent(VaadinIcon.SEARCH.create());
		importePosicion.setClearButtonVisible(true);
		binder.forField(importePosicion)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getImportePosicion, TicketModelo::setImportePosicion);

		//-------------------------------------------------------------------
		// Longitud ()
		longitud = new NumberField();
		longitud.setMin(0);
		longitud.setMax(Integer.MAX_VALUE);
		longitud.setPlaceholder("Longitud ");
		longitud.setPrefixComponent(VaadinIcon.SEARCH.create());
		longitud.setClearButtonVisible(true);
		binder.forField(longitud)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getLongitud, TicketModelo::setLongitud);

		//-------------------------------------------------------------------
		// Cantidad decimales ()
		cantidadDecimales = new NumberField();
		cantidadDecimales.setMin(0);
		cantidadDecimales.setMax(Integer.MAX_VALUE);
		cantidadDecimales.setPlaceholder("Cantidad decimales ");
		cantidadDecimales.setPrefixComponent(VaadinIcon.SEARCH.create());
		cantidadDecimales.setClearButtonVisible(true);
		binder.forField(cantidadDecimales)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getCantidadDecimales, TicketModelo::setCantidadDecimales);

		//-------------------------------------------------------------------
		// Número posición ()
		numeroPosicion = new NumberField();
		numeroPosicion.setMin(0);
		numeroPosicion.setMax(Integer.MAX_VALUE);
		numeroPosicion.setPlaceholder("Número posición ");
		numeroPosicion.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroPosicion.setClearButtonVisible(true);
		binder.forField(numeroPosicion)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getNumeroPosicion, TicketModelo::setNumeroPosicion);

		//-------------------------------------------------------------------
		// Número longitud ()
		numeroLongitud = new NumberField();
		numeroLongitud.setMin(0);
		numeroLongitud.setMax(Integer.MAX_VALUE);
		numeroLongitud.setPlaceholder("Número longitud ");
		numeroLongitud.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroLongitud.setClearButtonVisible(true);
		binder.forField(numeroLongitud)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getNumeroLongitud, TicketModelo::setNumeroLongitud);

		//-------------------------------------------------------------------
		// Prefijo identificación importación
		prefijoIdentificacion = new TextField();
		prefijoIdentificacion.setPlaceholder("Prefijo identificación importación");
		prefijoIdentificacion.setPrefixComponent(VaadinIcon.SEARCH.create());
		prefijoIdentificacion.setWidthFull();
		prefijoIdentificacion.setClearButtonVisible(true);
		prefijoIdentificacion.setAutoselect(true);
		binder.forField(prefijoIdentificacion)
			.bind(TicketModelo::getPrefijoIdentificacion, TicketModelo::setPrefijoIdentificacion);

		//-------------------------------------------------------------------
		// Posición prefijo ()
		posicionPrefijo = new NumberField();
		posicionPrefijo.setMin(0);
		posicionPrefijo.setMax(Integer.MAX_VALUE);
		posicionPrefijo.setPlaceholder("Posición prefijo ");
		posicionPrefijo.setPrefixComponent(VaadinIcon.SEARCH.create());
		posicionPrefijo.setClearButtonVisible(true);
		binder.forField(posicionPrefijo)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 0 : true, "El valor tiene que ser >= 0")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(TicketModelo::getPosicionPrefijo, TicketModelo::setPosicionPrefijo);
	

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
		form.add(numero, nombre, ticket, pruebaLectura, activo, longitudLectura, identificacionPosicion, identificacion, importePosicion, longitud, cantidadDecimales, numeroPosicion, numeroLongitud, prefijoIdentificacion, posicionPrefijo);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			TicketModeloService service = new TicketModeloService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}