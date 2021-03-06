package com.massoftware.service.geo;

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
import com.vaadin.flow.component.textfield.NumberField;
import com.massoftware.ui.util.DoubleToIntegerConverter;


@PageTitle("Códigos postales")
@Route("CodigosPostales")
public class UICodigosPostalesView extends VerticalLayout {

//	autowidth
//	filtro en formlayout
// ctrol + b buscar -- en la view no en la grid
//	ctrol + n nuevo -- en la view no en la grid
//	boton info
//	tarjeta info
//	responsive
// botonera no ordenable no movible

	// Binder
	private CodigosPostalesFiltro lastFilter;
	private CodigosPostalesFiltro filter;
	private Binder<CodigosPostalesFiltro> binder;

	// Filter control
	private HorizontalLayout filterRow1;

	// EJEMPLOS
	//private NumberField numeroFrom;
	//private NumberField numeroTo;
	//private TextField nombre;
	
	private ComboBox<Paises> pais;
	private ComboBox<Provincias> provincia;
	private ComboBox<Ciudades> ciudad;
	private TextField codigo;
	private NumberField numeroFrom;
	private NumberField numeroTo;
	private TextField nombreCalle;

	private Button newBTN;
	private Button findBTN;

	// Grid
	private UICodigosPostalesGrid grid;

	public UICodigosPostalesView() throws Exception {
		buildBinder();
		buildFilterRows();
		buildGrid();
		this.setHeightFull();		
		this.search();
	}

	private void buildBinder() {
		filter = new CodigosPostalesFiltro();
		binder = new Binder<>(CodigosPostalesFiltro.class);
		binder.setBean(filter);
	}

	private void buildFilterRows() throws Exception {

		// Controls ------------------------
		

		//-------------------------------------------------------------------
		// País
		pais = new ComboBox<>();
		pais.setWidthFull();
		pais.setRequired(true);
		pais.setPlaceholder("País");
		PaisService paisService = new PaisService();
		PaisesFiltro paisFiltro = new PaisesFiltro();
		paisFiltro.setUnlimited(true);
		List<Paises> paisItems = paisService.find(paisFiltro);
		pais.setItems(paisItems);
		binder.forField(pais)
			.asRequired("País es requerido.")		
			.bind(CodigosPostalesFiltro::getPais, CodigosPostalesFiltro::setPais);
		if(paisItems.size() > 0){
			pais.setValue(paisItems.get(0));
		}
		pais.addValueChangeListener(event -> {
			search();
		});
		pais.addBlurListener(event -> {
			search();
		});

		//-------------------------------------------------------------------
		// Provincia
		provincia = new ComboBox<>();
		provincia.setWidthFull();
		provincia.setRequired(true);
		provincia.setPlaceholder("Provincia");
		ProvinciaService provinciaService = new ProvinciaService();
		ProvinciasFiltro provinciaFiltro = new ProvinciasFiltro();
		provinciaFiltro.setUnlimited(true);
		List<Provincias> provinciaItems = provinciaService.find(provinciaFiltro);
		provincia.setItems(provinciaItems);
		binder.forField(provincia)
			.asRequired("Provincia es requerido.")		
			.bind(CodigosPostalesFiltro::getProvincia, CodigosPostalesFiltro::setProvincia);
		if(provinciaItems.size() > 0){
			provincia.setValue(provinciaItems.get(0));
		}
		provincia.addValueChangeListener(event -> {
			search();
		});
		provincia.addBlurListener(event -> {
			search();
		});

		//-------------------------------------------------------------------
		// Ciudad
		ciudad = new ComboBox<>();
		ciudad.setWidthFull();
		ciudad.setRequired(true);
		ciudad.setPlaceholder("Ciudad");
		CiudadService ciudadService = new CiudadService();
		CiudadesFiltro ciudadFiltro = new CiudadesFiltro();
		ciudadFiltro.setUnlimited(true);
		List<Ciudades> ciudadItems = ciudadService.find(ciudadFiltro);
		ciudad.setItems(ciudadItems);
		binder.forField(ciudad)
			.asRequired("Ciudad es requerido.")		
			.bind(CodigosPostalesFiltro::getCiudad, CodigosPostalesFiltro::setCiudad);
		if(ciudadItems.size() > 0){
			ciudad.setValue(ciudadItems.get(0));
		}
		ciudad.addValueChangeListener(event -> {
			search();
		});
		ciudad.addBlurListener(event -> {
			search();
		});

		//-------------------------------------------------------------------
		// Código
		codigo = new TextField();
		codigo.setPlaceholder("Código");
		codigo.setPrefixComponent(VaadinIcon.SEARCH.create());
		codigo.setWidthFull();
		codigo.setClearButtonVisible(true);
		codigo.setAutoselect(true);
		codigo.addFocusShortcut(Key.DIGIT_4, KeyModifier.ALT);
		binder.forField(codigo)
			.bind(CodigosPostalesFiltro::getCodigo, CodigosPostalesFiltro::setCodigo);
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
		// Secuencia (desde)
		numeroFrom = new NumberField();
		numeroFrom.setMin(1);
		numeroFrom.setMax(Integer.MAX_VALUE);
		numeroFrom.setPlaceholder("Secuencia desde ");
		numeroFrom.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroFrom.setClearButtonVisible(true);
		numeroFrom.addFocusShortcut(Key.DIGIT_5, KeyModifier.ALT);
		binder.forField(numeroFrom)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(CodigosPostalesFiltro::getNumeroFrom, CodigosPostalesFiltro::setNumeroFrom);
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
		// Secuencia (hasta)
		numeroTo = new NumberField();
		numeroTo.setMin(1);
		numeroTo.setMax(Integer.MAX_VALUE);
		numeroTo.setPlaceholder("Secuencia hasta ");
		numeroTo.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroTo.setClearButtonVisible(true);
		numeroTo.addFocusShortcut(Key.DIGIT_6, KeyModifier.ALT);
		binder.forField(numeroTo)
			.withConverter(new DoubleToIntegerConverter())
			.withValidator(value -> (value != null) ? value >= 1 : true, "El valor tiene que ser >= 1")
			.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,"El valor tiene que ser <= " + Integer.MAX_VALUE)
			.bind(CodigosPostalesFiltro::getNumeroTo, CodigosPostalesFiltro::setNumeroTo);
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
		// Calle
		nombreCalle = new TextField();
		nombreCalle.setPlaceholder("Calle");
		nombreCalle.setPrefixComponent(VaadinIcon.SEARCH.create());
		nombreCalle.setWidthFull();
		nombreCalle.setClearButtonVisible(true);
		nombreCalle.setAutoselect(true);
		nombreCalle.addFocusShortcut(Key.DIGIT_7, KeyModifier.ALT);
		binder.forField(nombreCalle)
			.bind(CodigosPostalesFiltro::getNombreCalle, CodigosPostalesFiltro::setNombreCalle);
		nombreCalle.addKeyPressListener(Key.ENTER, event -> {
			search();
		});
		nombreCalle.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
		});
		nombreCalle.addBlurListener(event -> {
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
		filterRow1.add(newBTN, pais, provincia, ciudad, codigo, numeroFrom, numeroTo, nombreCalle, findBTN);

		//-------------------------------------------------------------------
	}

	private void buildGrid() throws Exception {
//		grid = new UICodigosPostalesGrid(AppCX.services().buildCodigoPostalService(), filter);
		grid = new UICodigosPostalesGrid(new CodigoPostalService(), filter);
//		grid.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);
		grid.setWidthFull();
//		grid.setHeightFull();

		add(grid);

		grid.focus();
	}

	private void search() {
	
		binder.validate();
		
		if (this.filter.equals(this.lastFilter) == false) {
			this.lastFilter = (CodigosPostalesFiltro) this.filter.clone();
			if (binder.isValid()) {
				grid.refreshAll();
			} else {
				Notification.show("Uno o mas valores del filtro son incorrectos.");
			}
		}
	}

	private static final long serialVersionUID = 882456696439273826L;

}