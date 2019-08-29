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

import com.vaadin.flow.component.combobox.ComboBox;
import java.util.List;
import com.vaadin.flow.component.textfield.TextField;


@PageTitle("Cuentas contables")
@Route("CuentasContables")
public class UICuentasContablesView extends VerticalLayout {

//	autowidth
//	filtro en formlayout
// ctrol + b buscar -- en la view no en la grid
//	ctrol + n nuevo -- en la view no en la grid
//	boton info
//	tarjeta info
//	responsive
// botonera no ordenable no movible

	// Binder
	private CuentasContablesFiltro lastFilter;
	private CuentasContablesFiltro filter;
	private Binder<CuentasContablesFiltro> binder;

	// Filter control
	private HorizontalLayout filterRow1;

	// EJEMPLOS
	//private NumberField numeroFrom;
	//private NumberField numeroTo;
	//private TextField nombre;
	
	private ComboBox<EjerciciosContables> ejercicioContable;
	private ComboBox<CentrosCostosContables> centroCostoContable;
	private ComboBox<PuntosEquilibrios> puntoEquilibrio;
	private TextField codigo;
	private TextField cuentaAgrupadora;
	private TextField nombre;

	private Button newBTN;
	private Button findBTN;

	// Grid
	private UICuentasContablesGrid grid;

	public UICuentasContablesView() throws Exception {
		buildBinder();
		buildFilterRows();
		buildGrid();
		this.setHeightFull();		
		this.search();
	}

	private void buildBinder() {
		filter = new CuentasContablesFiltro();
		binder = new Binder<>(CuentasContablesFiltro.class);
		binder.setBean(filter);
	}

	private void buildFilterRows() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// Ejercicio
		ejercicioContable = new ComboBox<>();
		ejercicioContable.setRequired(true);
		ejercicioContable.setPlaceholder("Ejercicio");
		EjercicioContableService ejercicioContableService = new EjercicioContableService();
		EjerciciosContablesFiltro ejercicioContableFiltro = new EjerciciosContablesFiltro();
		ejercicioContableFiltro.setUnlimited(true);
		List<EjerciciosContables> ejercicioContableItems = ejercicioContableService.find(ejercicioContableFiltro);
		ejercicioContable.setItems(ejercicioContableItems);
		binder.forField(ejercicioContable)
			.asRequired("Ejercicio es requerido.")		
			.bind(CuentasContablesFiltro::getEjercicioContable, CuentasContablesFiltro::setEjercicioContable);
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
		// Estado
		centroCostoContable = new ComboBox<>();
		centroCostoContable.setPlaceholder("Estado");
		CentroCostoContableService centroCostoContableService = new CentroCostoContableService();
		CentrosCostosContablesFiltro centroCostoContableFiltro = new CentrosCostosContablesFiltro();
		centroCostoContableFiltro.setUnlimited(true);
		List<CentrosCostosContables> centroCostoContableItems = centroCostoContableService.find(centroCostoContableFiltro);
		centroCostoContable.setItems(centroCostoContableItems);
		binder.forField(centroCostoContable)
			.bind(CuentasContablesFiltro::getCentroCostoContable, CuentasContablesFiltro::setCentroCostoContable);
		if(centroCostoContableItems.size() > 0){
			centroCostoContable.setValue(centroCostoContableItems.get(0));
		}
		centroCostoContable.addValueChangeListener(event -> {
			search();
		});
		centroCostoContable.addBlurListener(event -> {
			search();
		});

		//-------------------------------------------------------------------
		// Punto de equilibrio
		puntoEquilibrio = new ComboBox<>();
		puntoEquilibrio.setPlaceholder("Punto de equilibrio");
		PuntoEquilibrioService puntoEquilibrioService = new PuntoEquilibrioService();
		PuntosEquilibriosFiltro puntoEquilibrioFiltro = new PuntosEquilibriosFiltro();
		puntoEquilibrioFiltro.setUnlimited(true);
		List<PuntosEquilibrios> puntoEquilibrioItems = puntoEquilibrioService.find(puntoEquilibrioFiltro);
		puntoEquilibrio.setItems(puntoEquilibrioItems);
		binder.forField(puntoEquilibrio)
			.bind(CuentasContablesFiltro::getPuntoEquilibrio, CuentasContablesFiltro::setPuntoEquilibrio);
		if(puntoEquilibrioItems.size() > 0){
			puntoEquilibrio.setValue(puntoEquilibrioItems.get(0));
		}
		puntoEquilibrio.addValueChangeListener(event -> {
			search();
		});
		puntoEquilibrio.addBlurListener(event -> {
			search();
		});

		//-------------------------------------------------------------------
		// Cuenta contable
		codigo = new TextField();
		codigo.setPlaceholder("Cuenta contable");
		codigo.setPrefixComponent(VaadinIcon.SEARCH.create());
		codigo.setWidthFull();
		codigo.setClearButtonVisible(true);
		codigo.setAutoselect(true);
		codigo.addFocusShortcut(Key.DIGIT_4, KeyModifier.ALT);
		binder.forField(codigo)
			.bind(CuentasContablesFiltro::getCodigo, CuentasContablesFiltro::setCodigo);
		codigo.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		codigo.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		codigo.addBlurListener(event -> {
			search();
		});

		//-------------------------------------------------------------------
		// Cuenta agrupadora
		cuentaAgrupadora = new TextField();
		cuentaAgrupadora.setPlaceholder("Cuenta agrupadora");
		cuentaAgrupadora.setPrefixComponent(VaadinIcon.SEARCH.create());
		cuentaAgrupadora.setWidthFull();
		cuentaAgrupadora.setClearButtonVisible(true);
		cuentaAgrupadora.setAutoselect(true);
		cuentaAgrupadora.addFocusShortcut(Key.DIGIT_5, KeyModifier.ALT);
		binder.forField(cuentaAgrupadora)
			.bind(CuentasContablesFiltro::getCuentaAgrupadora, CuentasContablesFiltro::setCuentaAgrupadora);
		cuentaAgrupadora.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		cuentaAgrupadora.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		cuentaAgrupadora.addBlurListener(event -> {
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
		nombre.addFocusShortcut(Key.DIGIT_6, KeyModifier.ALT);
		binder.forField(nombre)
			.bind(CuentasContablesFiltro::getNombre, CuentasContablesFiltro::setNombre);
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
		filterRow1.add(newBTN, ejercicioContable, centroCostoContable, puntoEquilibrio, cuentaAgrupadora, nombre, findBTN);

		//-------------------------------------------------------------------
	}

	private void buildGrid() throws Exception {
//		grid = new UICuentasContablesGrid(AppCX.services().buildCuentaContableService(), filter);
		grid = new UICuentasContablesGrid(new CuentaContableService(), filter);
//		grid.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);
		grid.setWidthFull();
//		grid.setHeightFull();

		add(grid);

		grid.focus();
	}

	private void search() {
	
		binder.validate();
		
		if (this.filter.equals(this.lastFilter) == false) {
			this.lastFilter = (CuentasContablesFiltro) this.filter.clone();
			if (binder.isValid()) {
				grid.refreshAll();
			} else {
				Notification.show("Uno o mas valores del filtro son incorrectos.");
			}
		}
	}

	private static final long serialVersionUID = 882456696439273826L;

}