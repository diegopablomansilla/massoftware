package com.massoftware.ui.widgets.fondos.banco;

import com.massoftware.service.fondos.banco.BancosFiltro;
import com.massoftware.service.fondos.banco.BancoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route("bancos")
public class BancoGridFilter extends VerticalLayout {

	private BancosFiltro bancoFiltro;
	private Binder<BancosFiltro> binder;

	private HorizontalLayout hl1;
	private HorizontalLayout hl2;
	private NumberField numeroFrom;
	private NumberField numeroTo;
	private TextField nombre;
	private Button findBTN;

	private BancoGrid grid;

	public BancoGridFilter() {

		bancoFiltro = new BancosFiltro();
		binder = new Binder<>(BancosFiltro.class);
		binder.setBean(bancoFiltro);

		hl1 = new HorizontalLayout();
		hl2 = new HorizontalLayout();

		add(hl1, hl2);

		numeroFrom = new NumberField();
//		numeroFrom.addThemeVariants(TextFieldVariant.LUMO_SMALL);
//		binder.forField(numeroFrom).asRequired("El campo \"Nombre\" es requerido, no puede estar vacio.")				.
//				.bind(BancoFiltro::getNombre, BancoFiltro::setNombre);

		numeroTo = new NumberField();

		hl1.add(numeroFrom, numeroTo);

		nombre = new TextField();

		findBTN = new Button("Buscar", event -> {
			if (binder.isValid()) {
				grid.refreshAll();
			}
		});

		hl2.add(nombre);
		hl2.add(findBTN);

		grid = new BancoGrid(new BancoService(), bancoFiltro);

		add(grid);
		
		HorizontalLayout toolbar = new HorizontalLayout(); 
		
		Button button1 = new Button("No borde", event -> {
			grid.setBorder(false);
		});		
		toolbar.add(button1);
		
		Button button2 = new Button("Borde", event -> {
			grid.setBorder(true);
		});		
		toolbar.add(button2);
		
		Button button3 = new Button("No row", event -> {
			grid.setRowStripes(false);
		});			
		toolbar.add(button3);
		
		Button button4 = new Button("Row", event -> {
			grid.setRowStripes(true);
		});				
		toolbar.add(button4);
		
		Button button5 = new Button("No row border", event -> {
			grid.setRowBorder(false);
		});			
		toolbar.add(button5);
		
		Button button6 = new Button("Row border", event -> {
			grid.setRowBorder(true);
		});				
		toolbar.add(button6);
		
		Button button7 = new Button("Conf style", event -> {
			grid.setShowContextMenuConfigStyle(true);
		});				
		toolbar.add(button7);
		
		Button button8 = new Button("No Conf style", event -> {
			grid.setShowContextMenuConfigStyle(false);
		});				
		toolbar.add(button8);
		
		this.add(toolbar);
		
		grid.focus();

	}

	private static final long serialVersionUID = 882456696439273826L;

}
