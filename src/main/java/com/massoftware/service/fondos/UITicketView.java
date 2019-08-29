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
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;
import com.massoftware.ui.util.DoubleToBigDecimalConverter;


@PageTitle("Ticket")
@Route("Ticket")
public class UITicketView extends VerticalLayout implements HasUrlParameter<String> {

	// Binder
	private Ticket item;
	private Binder<Ticket> binder;

	// Filter control
	private FormLayout form;

	
	private NumberField numero;
	private TextField nombre;
	private DatePicker fechaActualizacion;
	private NumberField cantidadPorLotes;
	private ComboBox<TicketControlDenunciados> ticketControlDenunciados;
	private NumberField valorMaximo;


//	private Button newBTN;
//	private Button findBTN;	

	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UITicketView() throws Exception {
		buildBinder();
		buildForm();
		this.setHeightFull();
//		this.search();
	}

	private void buildBinder() {
		item = new Ticket();
		binder = new Binder<>(Ticket.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº ticket ()
		numero = new NumberField();
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		numero.setPlaceholder("Nº ticket ");
		numero.setPrefixComponent(VaadinIcon.SEARCH.create());
		numero.setClearButtonVisible(true);
		binder.forField(numero)
			.asRequired("Nº ticket es requerido.")		
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Ticket::getNumero, Ticket::setNumero);

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
			.bind(Ticket::getNombre, Ticket::setNombre);

		//-------------------------------------------------------------------
		// Cantidad por lotes ()
		cantidadPorLotes = new NumberField();
		cantidadPorLotes.setMin(1);
		cantidadPorLotes.setMax(Integer.MAX_VALUE);
		cantidadPorLotes.setPlaceholder("Cantidad por lotes ");
		cantidadPorLotes.setPrefixComponent(VaadinIcon.SEARCH.create());
		cantidadPorLotes.setClearButtonVisible(true);
		binder.forField(cantidadPorLotes)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Ticket::getCantidadPorLotes, Ticket::setCantidadPorLotes);

		//-------------------------------------------------------------------
		// Control denunciados
		ticketControlDenunciados = new ComboBox<>();
		ticketControlDenunciados.setRequired(true);
		ticketControlDenunciados.setPlaceholder("Control denunciados");
		binder.forField(ticketControlDenunciados)
			.asRequired("Control denunciados es requerido.")		
			.bind(Ticket::getTicketControlDenunciados, Ticket::setTicketControlDenunciados);

		//-------------------------------------------------------------------
		// Valor máximo ()
		valorMaximo = new NumberField();
		valorMaximo.setMin(0);
		valorMaximo.setMax(99999.9999);
		valorMaximo.setPlaceholder("Valor máximo ");
		valorMaximo.setPrefixComponent(VaadinIcon.SEARCH.create());
		valorMaximo.setClearButtonVisible(true);
		binder.forField(valorMaximo)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(Ticket::getValorMaximo, Ticket::setValorMaximo);
	

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
		form.add(numero, nombre, fechaActualizacion, cantidadPorLotes, ticketControlDenunciados, valorMaximo);

		// -------------------------------------------------------------------
	}

	public void search(String id) {

		try {

			TicketService service = new TicketService();
			item = service.findById(id);
			binder.setBean(item);

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar el ítem !!");
		}

	}

	private static final long serialVersionUID = 882456696439273826L;

}