package com.massoftware.service.fondos;

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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.datepicker.DatePicker;
import java.util.Locale;
import com.massoftware.service.UIDatePickerI18n_es_AR;
import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;
import com.massoftware.ui.util.DoubleToBigDecimalConverter;


@PageTitle("Ticket")
@Route("Ticket")
public class UITicketView extends VerticalLayout implements HasUrlParameter<String> {

	private TicketService service;		

	// Binder
	private Ticket item;
	private Binder<Ticket> binder;

	// Control's
	private FormLayout form;
	private HorizontalLayout actions;
	private Button save;
	
	private NumberField numero;
	private TextField nombre;
	private DatePicker fechaActualizacion;
	private NumberField cantidadPorLotes;
	private ComboBox<TicketControlDenunciados> ticketControlDenunciados;
	private NumberField valorMaximo;
	
	@Override
	public void setParameter(BeforeEvent event, String id) {
		this.search(id);
	}

	public UITicketView() throws Exception {
		service = new TicketService();		
		buildBinder();
		buildForm();
		this.setHeightFull();
	}

	private void buildBinder() {
		item = new Ticket();
		binder = new Binder<>(Ticket.class);
		binder.setBean(item);
	}

	private void buildForm() throws Exception {

		// -------------------------------------------------------------------
		// Controls 
		// -------------------------------------------------------------------
		
		buildSave();
		
		buildNumero();
		buildNombre();
		buildFechaActualizacion();
		buildCantidadPorLotes();
		buildTicketControlDenunciados();
		buildValorMaximo();
		
		// -------------------------------------------------------------------
		// Layout's
		// ------------------------------------------------------------------- 

		form = new FormLayout();
		form.setWidthFull();

		add(form);
		
		form.add(numero);
		form.add(nombre);
		form.add(fechaActualizacion);
		form.add(cantidadPorLotes);
		form.add(ticketControlDenunciados);
		form.add(valorMaximo);
		
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
		// Nº ticket
		numero = new NumberField();
		numero.setLabel("Nº ticket");
		numero.setWidthFull();
		numero.setClearButtonVisible(true);
		numero.setMin(1);
		numero.setMax(Integer.MAX_VALUE);
		binder.forField(numero)
			.asRequired("Nº ticket es requerido.")		
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Ticket::getNumero, Ticket::setNumero);
	}

	private void buildNombre() throws Exception {
		// Nombre
		nombre = new TextField();
		nombre.setLabel("Nombre");
		nombre.setWidthFull();
		nombre.setClearButtonVisible(true);
		nombre.setAutoselect(true);
		nombre.setRequired(true);
		binder.forField(nombre)
			.asRequired("Nombre es requerido.")		
			.withValidator(value -> (value != null) ? value.length() <= 50 : true, "El valor tiene que contener menos de 50 caracteres")
			.bind(Ticket::getNombre, Ticket::setNombre);
	}

	private void buildFechaActualizacion() throws Exception {
		// Fecha actualización
		fechaActualizacion = new DatePicker();
		fechaActualizacion.setLabel("Fecha actualización");
		fechaActualizacion.setWidthFull();
		fechaActualizacion.setLocale(new Locale("es_AR"));
		fechaActualizacion.setI18n(new UIDatePickerI18n_es_AR());
		binder.forField(fechaActualizacion)
			.bind(Ticket::getFechaActualizacion, Ticket::setFechaActualizacion);
	}

	private void buildCantidadPorLotes() throws Exception {
		// Cantidad por lotes
		cantidadPorLotes = new NumberField();
		cantidadPorLotes.setLabel("Cantidad por lotes");
		cantidadPorLotes.setWidthFull();
		cantidadPorLotes.setClearButtonVisible(true);
		cantidadPorLotes.setMin(1);
		cantidadPorLotes.setMax(Integer.MAX_VALUE);
		binder.forField(cantidadPorLotes)
			.withValidator(value -> (value != null) ? value % 1 == 0 : true, "El valor tiene que ser entero")
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(Ticket::getCantidadPorLotes, Ticket::setCantidadPorLotes);
	}

	private void buildTicketControlDenunciados() throws Exception {
		// Control denunciados
		ticketControlDenunciados = new ComboBox<>();
		ticketControlDenunciados.setLabel("Control denunciados");
		ticketControlDenunciados.setWidthFull();
		ticketControlDenunciados.setRequired(true);
		List<TicketControlDenunciados> items = new TicketControlDenunciadosService().find();
		ticketControlDenunciados.setItems(items);
		binder.forField(ticketControlDenunciados)
			.asRequired("Control denunciados es requerido.")		
			.bind(Ticket::getTicketControlDenunciados, Ticket::setTicketControlDenunciados);
	}

	private void buildValorMaximo() throws Exception {
		// Valor máximo
		valorMaximo = new NumberField();
		valorMaximo.setLabel("Valor máximo");
		valorMaximo.setWidthFull();
		valorMaximo.setClearButtonVisible(true);
		valorMaximo.setMin(0);
		valorMaximo.setMax(99999.9999);
		binder.forField(valorMaximo)
			.withConverter(new DoubleToBigDecimalConverter())
			.bind(Ticket::getValorMaximo, Ticket::setValorMaximo);
	}

	public void search(String id) {

		try {
			
			item = service.findById(id);
			binder.setBean(item);
			
			binder.validate();

			if (binder.isValid()) {											
				Notification.show("El ítem '" + item + "' se cargó con éxito !");				
			} else {								
				BinderValidationStatus<Ticket> validate = binder.validate();
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
				BinderValidationStatus<Ticket> validate = binder.validate();
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