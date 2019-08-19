package com.massoftware.ui.views.fondos.banco;

import com.massoftware.service.fondos.banco.BancoService;
import com.massoftware.service.fondos.banco.BancosFiltro;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route("bancos")
public class BancosView extends VerticalLayout {
	
	filtro x vigente
	autowidth
	romper palabras
	botonera configurable
	menu contextual
	filtro en formlayout
	negrita en columna
	enter / lost focus en los filtros
	ctrol + b buscar
	ctrol + n nuevo
	boton info
	tarjeta info
	responsive
	formatear el cuit
	

	// Binder
	private BancosFiltro bancoFiltro;
	private Binder<BancosFiltro> binder;

	// Filter control
	private HorizontalLayout filterRow1;

	private NumberField numeroFrom;
	private NumberField numeroTo;
	private TextField nombre;
	private Button newBTN;
	private Button findBTN;

	// Grid
	private BancosGrid grid;

	public BancosView() {
		buildBinder();
		buildFilterRows();
		buildGrid();

	}

	private void buildBinder() {
		bancoFiltro = new BancosFiltro();
		binder = new Binder<>(BancosFiltro.class);
		binder.setBean(bancoFiltro);
	}

	private void buildFilterRows() {

		// Controls
		numeroFrom = new NumberField();
		numeroFrom.setMin(1);
		numeroFrom.setMax(Integer.MAX_VALUE);
		numeroFrom.setPlaceholder("nº desde");
		numeroFrom.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroFrom.setClearButtonVisible(true);
//		numeroFrom.setAutoselect(true);
		numeroFrom.addFocusShortcut(Key.DIGIT_1, KeyModifier.ALT);

		numeroTo = new NumberField();
		numeroTo.setMin(1);
		numeroTo.setMax(Integer.MAX_VALUE);
		numeroTo.setPlaceholder("nº hasta");
		numeroTo.setPrefixComponent(VaadinIcon.SEARCH.create());
		numeroTo.setClearButtonVisible(true);
//		numeroTo.setAutoselect(true);
		numeroFrom.addFocusShortcut(Key.DIGIT_2, KeyModifier.ALT);

		nombre = new TextField();
		nombre.setPlaceholder("nombre");
		nombre.setPrefixComponent(VaadinIcon.SEARCH.create());
		nombre.setWidthFull();
		nombre.setClearButtonVisible(true);
		nombre.setAutoselect(true);
		numeroFrom.addFocusShortcut(Key.DIGIT_3, KeyModifier.ALT);

		newBTN = new Button();
		newBTN.setIcon(VaadinIcon.PLUS.create());

		findBTN = new Button();
		findBTN.setIcon(VaadinIcon.SEARCH.create());

//		findBTN = new Button("Buscar", event -> {
//			if (binder.isValid()) {
//				grid.refreshAll();
//			}
//		});

		// Layout
		filterRow1 = new HorizontalLayout();
		filterRow1.setWidthFull();

		add(filterRow1);

		filterRow1.add(newBTN, numeroFrom, numeroTo, nombre, findBTN);

	}

	private void buildGrid() {
		grid = new BancosGrid(new BancoService(), bancoFiltro);

		add(grid);

		grid.focus();
	}

	private static final long serialVersionUID = 882456696439273826L;

}
