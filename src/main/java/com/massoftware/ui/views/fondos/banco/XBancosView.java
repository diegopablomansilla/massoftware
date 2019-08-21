package com.massoftware.ui.views.fondos.banco;

import com.massoftware.service.FBoolean;
import com.massoftware.service.fondos.banco.XBancoService;
import com.massoftware.service.fondos.banco.XBancosFiltro;
import com.massoftware.ui.components.UIUtils;
import com.massoftware.ui.util.DoubleToIntegerConverter;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Bancos")
@Route("bancos")
public class XBancosView extends VerticalLayout {

//	filtro x vigente

//	autowidth
//	filtro en formlayout

// ctrol + b buscar -- en la view no en la grid
//	ctrol + n nuevo -- en la view no en la grid

//	boton info
//	tarjeta info
//	responsive

	// botonera no ordenable no movible

	// Binder
	private XBancosFiltro lastFilter;
	private XBancosFiltro filter;
	private Binder<XBancosFiltro> binder;

	// Filter control
	private HorizontalLayout filterRow1;

	private NumberField numeroFrom;
	private NumberField numeroTo;
	private TextField nombre;
	private Button newBTN;
	private Button findBTN;

	// Grid
	private XBancosGrid grid;

	public XBancosView() {
		buildBinder();
		buildFilterRows();
		buildGrid();
		this.setHeightFull();
	}

	private void buildBinder() {
		filter = new XBancosFiltro();
		binder = new Binder<>(XBancosFiltro.class);
		binder.setBean(filter);
	}

	private void buildFilterRows() {

		// Controls ------------------------

		// Nº banco (desde)
		numeroFrom = new NumberField();
		numeroFrom.setMin(1);
		numeroFrom.setMax(Integer.MAX_VALUE);
		numeroFrom.setPlaceholder("nº desde");
		numeroFrom.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroFrom.setClearButtonVisible(true);
		numeroFrom.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);
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
		binder.forField(numeroFrom).withConverter(new DoubleToIntegerConverter())
				.withValidator(value -> (value != null) ? value > 1 : true, "El valor tiene que ser >= 1")
				.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,
						"El valor tiene que ser <= " + Integer.MAX_VALUE)
				.bind(XBancosFiltro::getNumeroFrom, XBancosFiltro::setNumeroFrom);

		// Nº banco (hasta)
		numeroTo = new NumberField();
		numeroTo.setMin(1);
		numeroTo.setMax(Integer.MAX_VALUE);
		numeroTo.setPlaceholder("nº hasta");
		numeroTo.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroTo.setClearButtonVisible(true);
		numeroTo.addFocusShortcut(Key.DIGIT_2, KeyModifier.ALT);
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
		binder.forField(numeroTo).withConverter(new DoubleToIntegerConverter())
				.withValidator(value -> (value != null) ? value > 1 : true, "El valor tiene que ser >= 1")
				.withValidator(value -> (value != null) ? value <= Integer.MAX_VALUE : true,
						"El valor tiene que ser <= " + Integer.MAX_VALUE)
				.bind(XBancosFiltro::getNumeroTo, XBancosFiltro::setNumeroTo);

		// Vigente
		ComboBox<FBoolean> vigente = new ComboBox<>();
		vigente.setPlaceholder("Vigente: Todos");
		FBoolean valueVigente = new FBoolean("Vigente: ", null, "Todos");
		vigente.setItems(valueVigente, new FBoolean("Vigente: ", true, "Si"), new FBoolean("Vigente: ", false, "No"));
		vigente.setValue(valueVigente);
		vigente.addValueChangeListener(event -> {
			if (event.getValue() == null || event.getValue().toString().trim().length() == 0) {
				search();
			}
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
		binder.bind(nombre, XBancosFiltro::getNombre, XBancosFiltro::setNombre);

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

		filterRow1.add(newBTN, numeroFrom, numeroTo, vigente, nombre, findBTN);

	}

	private void buildGrid() {
		grid = new XBancosGrid(new XBancoService(), filter);
		grid.addFocusShortcut(Key.DIGIT_5, KeyModifier.ALT);
		grid.setWidthFull();
//		grid.setHeightFull();

		add(grid);

		grid.focus();
	}

	private void search() {
		if (this.filter.equals(this.lastFilter) == false) {
			this.lastFilter = (XBancosFiltro) this.filter.clone();
			if (binder.isValid()) {
				grid.refreshAll();
			} else {
				Notification.show("Uno o mas valores del filtro son incorrectos.");
			}
		}
	}

	private static final long serialVersionUID = 882456696439273826L;

}
