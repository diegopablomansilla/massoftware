package com.massoftware.service.clientes;

import com.massoftware.ui.components.UIUtils;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;
import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.vaadin.flow.component.textfield.TextField;


@PageTitle("Motivos bloqueo a clientes")
@Route("MotivosBloqueosClientes")
public class UIMotivosBloqueosClientesView extends VerticalLayout {

//	autowidth
//	filtro en formlayout
// ctrol + b buscar -- en la view no en la grid
//	ctrol + n nuevo -- en la view no en la grid
//	boton info
//	tarjeta info
//	responsive
// botonera no ordenable no movible

	// Binder
	private MotivosBloqueosClientesFiltro lastFilter;
	private MotivosBloqueosClientesFiltro filter;
	private Binder<MotivosBloqueosClientesFiltro> binder;

	// Filter control
	private HorizontalLayout filterRow1;

	// EJEMPLOS
	//private NumberField numeroFrom;
	//private NumberField numeroTo;
	//private TextField nombre;
	
	private ComboBox<ClasificacionesClientes> clasificacionCliente;
	private NumberField numeroFrom;
	private NumberField numeroTo;
	private TextField nombre;

	private Button newBTN;
	private Button findBTN;

	// Grid
	private UIMotivosBloqueosClientesGrid grid;

	public UIMotivosBloqueosClientesView() throws Exception {
		buildBinder();
		buildFilterRows();
		buildGrid();
		this.setHeightFull();		
		this.search();
	}

	private void buildBinder() {
		filter = new MotivosBloqueosClientesFiltro();
		binder = new Binder<>(MotivosBloqueosClientesFiltro.class);
		binder.setBean(filter);
	}

	private void buildFilterRows() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Clasificación de cliente
		clasificacionCliente = new ComboBox<>();
		clasificacionCliente.setWidthFull();
		clasificacionCliente.setRequired(true);
		clasificacionCliente.setPlaceholder("Clasificación de cliente");
		ClasificacionClienteService clasificacionClienteService = new ClasificacionClienteService();
		ClasificacionesClientesFiltro clasificacionClienteFiltro = new ClasificacionesClientesFiltro();
		clasificacionClienteFiltro.setUnlimited(true);
		List<ClasificacionesClientes> clasificacionClienteItems = clasificacionClienteService.find(clasificacionClienteFiltro);
		clasificacionCliente.setItems(clasificacionClienteItems);
		binder.forField(clasificacionCliente)
			.asRequired("Clasificación de cliente es requerido.")		
			.bind(MotivosBloqueosClientesFiltro::getClasificacionCliente, MotivosBloqueosClientesFiltro::setClasificacionCliente);
		if(clasificacionClienteItems.size() > 0){
			clasificacionCliente.setValue(clasificacionClienteItems.get(0));
		}
		clasificacionCliente.addValueChangeListener(event -> {
			search();
		});
		clasificacionCliente.addBlurListener(event -> {
			search();
		});

		//-------------------------------------------------------------------
		// Nº motivo (desde)
		numeroFrom = new NumberField();
		numeroFrom.setMin(1);
		numeroFrom.setMax(Integer.MAX_VALUE);
		numeroFrom.setPlaceholder("Nº motivo desde ");
		numeroFrom.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroFrom.setClearButtonVisible(true);
		numeroFrom.addFocusShortcut(Key.DIGIT_2, KeyModifier.ALT);
		binder.forField(numeroFrom)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(MotivosBloqueosClientesFiltro::getNumeroFrom, MotivosBloqueosClientesFiltro::setNumeroFrom);
		numeroFrom.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		numeroFrom.addValueChangeListener(event -> {
		if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
			search();
		}
		});
		numeroFrom.addBlurListener(event -> {
			search();
		});

		//-------------------------------------------------------------------
		// Nº motivo (hasta)
		numeroTo = new NumberField();
		numeroTo.setMin(1);
		numeroTo.setMax(Integer.MAX_VALUE);
		numeroTo.setPlaceholder("Nº motivo hasta ");
		numeroTo.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroTo.setClearButtonVisible(true);
		numeroTo.addFocusShortcut(Key.DIGIT_3, KeyModifier.ALT);
		binder.forField(numeroTo)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(MotivosBloqueosClientesFiltro::getNumeroTo, MotivosBloqueosClientesFiltro::setNumeroTo);
		numeroTo.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		numeroTo.addValueChangeListener(event -> {
		if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
			search();
		}
		});
		numeroTo.addBlurListener(event -> {
			search();
		});

		//-------------------------------------------------------------------
		// Nombre
		nombre = new TextField();
		nombre.setPlaceholder("Nombre");
		nombre.setPrefixComponent(VaadinIcon.SEARCH.create());
		nombre.setWidthFull();
		nombre.setClearButtonVisible(true);
		nombre.setAutoselect(true);
		nombre.addFocusShortcut(Key.DIGIT_4, KeyModifier.ALT);
		binder.forField(nombre)
			.bind(MotivosBloqueosClientesFiltro::getNombre, MotivosBloqueosClientesFiltro::setNombre);
		nombre.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		nombre.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		nombre.addBlurListener(event -> {
			search();
		});


/* EJEMPLOS
		// Nº banco (desde)
		numeroFrom = new NumberField();
		numeroFrom.setMin(1);
		numeroFrom.setMax(Integer.MAX_VALUE);
		numeroFrom.setPlaceholder("nº desde");
		numeroFrom.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroFrom.setClearButtonVisible(true);
		numeroFrom.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);
		binder.forField(numeroFrom).withConverter(new DoubleToIntegerConverter())
				.withValidator(value -> (value != null) ? value > 1 : true, "El valor tiene que ser >= 1")
				.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,
						"El valor tiene que ser <= " + Integer.MAX_VALUE)
				.bind(BancosFiltro::getNumeroFrom, BancosFiltro::setNumeroFrom);
		numeroFrom.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		numeroFrom.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		numeroFrom.addBlurListener(event -> {
			search();
		});

		// Nº banco (hasta)
		numeroTo = new NumberField();
		numeroTo.setMin(1);
		numeroTo.setMax(Integer.MAX_VALUE);
		numeroTo.setPlaceholder("nº hasta");
		numeroTo.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroTo.setClearButtonVisible(true);
		numeroTo.addFocusShortcut(Key.DIGIT_2, KeyModifier.ALT);
		binder.forField(numeroTo).withConverter(new DoubleToIntegerConverter())
				.withValidator(value -> (value != null) ? value > 1 : true, "El valor tiene que ser >= 1")
				.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,
						"El valor tiene que ser <= " + Integer.MAX_VALUE)
				.bind(BancosFiltro::getNumeroTo, BancosFiltro::setNumeroTo);
		numeroTo.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		numeroTo.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		numeroTo.addBlurListener(event -> {
			search();
		});

		// Vigente
		ComboBox<FBoolean> vigente = new ComboBox<>();
		vigente.setPlaceholder("Vigente: Todos");
		FBoolean valueVigente = new FBoolean("Vigente: ", null, "Todos");
		vigente.setItems(valueVigente, new FBoolean("Vigente: ", true, "Si"), new FBoolean("Vigente: ", false, "No"));
		vigente.setValue(valueVigente);
		binder.bind(vigente, BancosFiltro::getVigenteX, BancosFiltro::setVigenteX);
		vigente.addValueChangeListener(event -> {
			search();
		});
		vigente.addBlurListener(event -> {
			search();
		});

		// Nombre
		nombre = new TextField();
		nombre.setPlaceholder("nombre");
		nombre.setPrefixComponent(VaadinIcon.SEARCH.create());
		nombre.setWidthFull();
		nombre.setClearButtonVisible(true);
		nombre.setAutoselect(true);
		nombre.addFocusShortcut(Key.DIGIT_3, KeyModifier.ALT);
		binder.bind(nombre, BancosFiltro::getNombre, BancosFiltro::setNombre);
		nombre.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		nombre.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		nombre.addBlurListener(event -> {
			search();
		});
*/
		//-------------------------------------------------------------------

		// Button New ítem
		newBTN = new Button();
		UIUtils.setTooltip("Nuevo", newBTN);
		newBTN.setIcon(VaadinIcon.PLUS.create());

		// Button Search ítem's
		findBTN = new Button();
		UIUtils.setTooltip("Buscar", findBTN);
		findBTN.setIcon(VaadinIcon.SEARCH.create());
		findBTN.addClickListener(event -> {
			search();
		});

		// Layout ------------------------
		filterRow1 = new HorizontalLayout();
		filterRow1.setWidthFull();

		add(filterRow1);

		//filterRow1.add(newBTN, numeroFrom, numeroTo, vigente, nombre, findBTN);
		filterRow1.add(newBTN, clasificacionCliente, numeroFrom, numeroTo, nombre, findBTN);

		//-------------------------------------------------------------------
	}

	private void buildGrid() throws Exception {
//		grid = new UIMotivosBloqueosClientesGrid(AppCX.services().buildMotivoBloqueoClienteService(), filter);
		grid = new UIMotivosBloqueosClientesGrid(new MotivoBloqueoClienteService(), filter);
//		grid.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);
		grid.setWidthFull();
//		grid.setHeightFull();

		add(grid);

		grid.focus();
	}

	private void search() {
	
		binder.validate();
		
		if (this.filter.equals(this.lastFilter) == false) {
			this.lastFilter = (MotivosBloqueosClientesFiltro) this.filter.clone();
			if (binder.isValid()) {
				grid.refreshAll();
			} else {
				Notification.show("Uno o mas valores del filtro son incorrectos.");
			}
		}
	}

	private static final long serialVersionUID = 882456696439273826L;

}