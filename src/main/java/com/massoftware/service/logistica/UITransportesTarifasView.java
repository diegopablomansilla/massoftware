
package com.massoftware.service.logistica;

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


@PageTitle("Tarifas de transporte")
@Route("TransportesTarifas")
public class UITransportesTarifasView extends VerticalLayout {

//	autowidth
//	filtro en formlayout
// ctrol + b buscar -- en la view no en la grid
//	ctrol + n nuevo -- en la view no en la grid
//	boton info
//	tarjeta info
//	responsive
// botonera no ordenable no movible

	// Binder
	private TransportesTarifasFiltro lastFilter;
	private TransportesTarifasFiltro filter;
	private Binder<TransportesTarifasFiltro> binder;

	// Filter control
	private HorizontalLayout filterRow1;

	// EJEMPLOS
	//private NumberField numeroFrom;
	//private NumberField numeroTo;
	//private TextField nombre;
	
	private ComboBox<Transportes> transporte;

	private Button newBTN;
	private Button findBTN;

	// Grid
	private UITransportesTarifasGrid grid;

	public UITransportesTarifasView() throws Exception {
		buildBinder();
		buildFilterRows();
		buildGrid();
		this.setHeightFull();		
		this.search();
	}

	private void buildBinder() {
		filter = new TransportesTarifasFiltro();
		binder = new Binder<>(TransportesTarifasFiltro.class);
		binder.setBean(filter);
	}

	private void buildFilterRows() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Transporte
		transporte = new ComboBox<>();
		transporte.setRequired(true);
		transporte.setPlaceholder("Transporte");
		TransporteService transporteService = new TransporteService();
		TransportesFiltro transporteFiltro = new TransportesFiltro();
		transporteFiltro.setUnlimited(true);
		List<Transportes> transporteItems = transporteService.find(transporteFiltro);
		transporte.setItems(transporteItems);
		binder.forField(transporte)
			.asRequired("Transporte es requerido.")		
			.bind(TransportesTarifasFiltro::getTransporte, TransportesTarifasFiltro::setTransporte);
		if(transporteItems.size() > 0){
			transporte.setValue(transporteItems.get(0));
		}
		transporte.addValueChangeListener(event -> {
			search();
		});
		transporte.addBlurListener(event -> {
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
		filterRow1.add(newBTN, transporte, findBTN);

		//-------------------------------------------------------------------
	}

	private void buildGrid() throws Exception {
//		grid = new UITransportesTarifasGrid(AppCX.services().buildTransporteTarifaService(), filter);
		grid = new UITransportesTarifasGrid(new TransporteTarifaService(), filter);
//		grid.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);
		grid.setWidthFull();
//		grid.setHeightFull();

		add(grid);

		grid.focus();
	}

	private void search() {
	
		binder.validate();
		
		if (this.filter.equals(this.lastFilter) == false) {
			this.lastFilter = (TransportesTarifasFiltro) this.filter.clone();
			if (binder.isValid()) {
				grid.refreshAll();
			} else {
				Notification.show("Uno o mas valores del filtro son incorrectos.");
			}
		}
	}

	private static final long serialVersionUID = 882456696439273826L;

}