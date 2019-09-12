package com.massoftware.service.contabilidad;

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

import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;
import com.massoftware.service.empresa.Sucursales;
import com.massoftware.service.empresa.SucursalesFiltro;
import com.massoftware.service.empresa.SucursalService;


@PageTitle("Asientos contables")
@Route("AsientosContables")
public class UIAsientosContablesView extends VerticalLayout {

//	autowidth
//	filtro en formlayout
// ctrol + b buscar -- en la view no en la grid
//	ctrol + n nuevo -- en la view no en la grid
//	boton info
//	tarjeta info
//	responsive
// botonera no ordenable no movible

	// Binder
	private AsientosContablesFiltro lastFilter;
	private AsientosContablesFiltro filter;
	private Binder<AsientosContablesFiltro> binder;

	// Filter control
	private HorizontalLayout filterRow1;

	// EJEMPLOS
	//private NumberField numeroFrom;
	//private NumberField numeroTo;
	//private TextField nombre;
	
	private NumberField numeroFrom;
	private NumberField numeroTo;
	private TextField detalle;
	private DatePicker fechaFrom;
	private DatePicker fechaTo;
	private ComboBox<EjerciciosContables> ejercicioContable;
	private ComboBox<MinutasContables> minutaContable;
	private ComboBox<AsientosContablesModulos> asientoContableModulo;
	private ComboBox<Sucursales> sucursal;

	private Button newBTN;
	private Button findBTN;

	// Grid
	private UIAsientosContablesGrid grid;

	public UIAsientosContablesView() throws Exception {
		buildBinder();
		buildFilterRows();
		buildGrid();
		this.setHeightFull();		
		this.search();
	}

	private void buildBinder() {
		filter = new AsientosContablesFiltro();
		binder = new Binder<>(AsientosContablesFiltro.class);
		binder.setBean(filter);
	}

	private void buildFilterRows() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Nº asiento (desde)
		numeroFrom = new NumberField();
		numeroFrom.setMin(1);
		numeroFrom.setMax(Integer.MAX_VALUE);
		numeroFrom.setPlaceholder("Nº asiento desde ");
		numeroFrom.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroFrom.setClearButtonVisible(true);
		numeroFrom.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);
		binder.forField(numeroFrom)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(AsientosContablesFiltro::getNumeroFrom, AsientosContablesFiltro::setNumeroFrom);
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
		// Nº asiento (hasta)
		numeroTo = new NumberField();
		numeroTo.setMin(1);
		numeroTo.setMax(Integer.MAX_VALUE);
		numeroTo.setPlaceholder("Nº asiento hasta ");
		numeroTo.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroTo.setClearButtonVisible(true);
		numeroTo.addFocusShortcut(Key.DIGIT_2, KeyModifier.ALT);
		binder.forField(numeroTo)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(AsientosContablesFiltro::getNumeroTo, AsientosContablesFiltro::setNumeroTo);
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
		// Detalle
		detalle = new TextField();
		detalle.setPlaceholder("Detalle");
		detalle.setPrefixComponent(VaadinIcon.SEARCH.create());
		detalle.setWidthFull();
		detalle.setClearButtonVisible(true);
		detalle.setAutoselect(true);
		detalle.addFocusShortcut(Key.DIGIT_3, KeyModifier.ALT);
		binder.forField(detalle)
			.bind(AsientosContablesFiltro::getDetalle, AsientosContablesFiltro::setDetalle);
		detalle.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		detalle.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		detalle.addBlurListener(event -> {
			search();
		});

		//-------------------------------------------------------------------
		// Ejercicio
		ejercicioContable = new ComboBox<>();
		ejercicioContable.setWidthFull();
		ejercicioContable.setRequired(true);
		ejercicioContable.setPlaceholder("Ejercicio");
		EjercicioContableService ejercicioContableService = new EjercicioContableService();
		EjerciciosContablesFiltro ejercicioContableFiltro = new EjerciciosContablesFiltro();
		ejercicioContableFiltro.setUnlimited(true);
		List<EjerciciosContables> ejercicioContableItems = ejercicioContableService.find(ejercicioContableFiltro);
		ejercicioContable.setItems(ejercicioContableItems);
		binder.forField(ejercicioContable)
			.asRequired("Ejercicio es requerido.")		
			.bind(AsientosContablesFiltro::getEjercicioContable, AsientosContablesFiltro::setEjercicioContable);
		if(ejercicioContableItems.size() > 0){
			ejercicioContable.setValue(ejercicioContableItems.get(0));
		}
		ejercicioContable.addValueChangeListener(event -> {
			search();
		});
		ejercicioContable.addBlurListener(event -> {
			search();
		});

		//-------------------------------------------------------------------
		// Minuta contable
		minutaContable = new ComboBox<>();
		minutaContable.setWidthFull();
		minutaContable.setPlaceholder("Minuta contable");
		MinutaContableService minutaContableService = new MinutaContableService();
		MinutasContablesFiltro minutaContableFiltro = new MinutasContablesFiltro();
		minutaContableFiltro.setUnlimited(true);
		List<MinutasContables> minutaContableItems = minutaContableService.find(minutaContableFiltro);
		minutaContable.setItems(minutaContableItems);
		binder.forField(minutaContable)
			.bind(AsientosContablesFiltro::getMinutaContable, AsientosContablesFiltro::setMinutaContable);
		if(minutaContableItems.size() > 0){
			minutaContable.setValue(minutaContableItems.get(0));
		}
		minutaContable.addValueChangeListener(event -> {
			search();
		});
		minutaContable.addBlurListener(event -> {
			search();
		});

		//-------------------------------------------------------------------
		// Módulo
		asientoContableModulo = new ComboBox<>();
		asientoContableModulo.setWidthFull();
		asientoContableModulo.setPlaceholder("Módulo");
		AsientoContableModuloService asientoContableModuloService = new AsientoContableModuloService();
		AsientosContablesModulosFiltro asientoContableModuloFiltro = new AsientosContablesModulosFiltro();
		asientoContableModuloFiltro.setUnlimited(true);
		List<AsientosContablesModulos> asientoContableModuloItems = asientoContableModuloService.find(asientoContableModuloFiltro);
		asientoContableModulo.setItems(asientoContableModuloItems);
		binder.forField(asientoContableModulo)
			.bind(AsientosContablesFiltro::getAsientoContableModulo, AsientosContablesFiltro::setAsientoContableModulo);
		if(asientoContableModuloItems.size() > 0){
			asientoContableModulo.setValue(asientoContableModuloItems.get(0));
		}
		asientoContableModulo.addValueChangeListener(event -> {
			search();
		});
		asientoContableModulo.addBlurListener(event -> {
			search();
		});

		//-------------------------------------------------------------------
		// Sucursal
		sucursal = new ComboBox<>();
		sucursal.setWidthFull();
		sucursal.setPlaceholder("Sucursal");
		SucursalService sucursalService = new SucursalService();
		SucursalesFiltro sucursalFiltro = new SucursalesFiltro();
		sucursalFiltro.setUnlimited(true);
		List<Sucursales> sucursalItems = sucursalService.find(sucursalFiltro);
		sucursal.setItems(sucursalItems);
		binder.forField(sucursal)
			.bind(AsientosContablesFiltro::getSucursal, AsientosContablesFiltro::setSucursal);
		if(sucursalItems.size() > 0){
			sucursal.setValue(sucursalItems.get(0));
		}
		sucursal.addValueChangeListener(event -> {
			search();
		});
		sucursal.addBlurListener(event -> {
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
		filterRow1.add(newBTN, numeroFrom, numeroTo, detalle, fechaFrom, fechaTo, ejercicioContable, minutaContable, asientoContableModulo, sucursal, findBTN);

		//-------------------------------------------------------------------
	}

	private void buildGrid() throws Exception {
//		grid = new UIAsientosContablesGrid(AppCX.services().buildAsientoContableService(), filter);
		grid = new UIAsientosContablesGrid(new AsientoContableService(), filter);
//		grid.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);
		grid.setWidthFull();
//		grid.setHeightFull();

		add(grid);

		grid.focus();
	}

	private void search() {
	
		binder.validate();
		
		if (this.filter.equals(this.lastFilter) == false) {
			this.lastFilter = (AsientosContablesFiltro) this.filter.clone();
			if (binder.isValid()) {
				grid.refreshAll();
			} else {
				Notification.show("Uno o mas valores del filtro son incorrectos.");
			}
		}
	}

	private static final long serialVersionUID = 882456696439273826L;

}