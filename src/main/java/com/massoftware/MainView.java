package com.massoftware;

import com.massoftware.ui.widgets.fondos.banco.BancoGridFilter;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
//@PWA(name = "MasSoftware ERP", shortName = "MasSoftware")
public class MainView extends VerticalLayout {

	public MainView() {

		try {
			
			BancoGridFilter bancoGridFilter = new BancoGridFilter();
			add(bancoGridFilter);
			
			

//			BancoFiltro bancoFiltro = new BancoFiltro();
//			bancoFiltro.setNombre("rojo");
//
//			Binder<BancoFiltro> binder = new Binder<>(BancoFiltro.class);
//			binder.setBean(bancoFiltro);
//
//			TextField nombreTXT = new TextField("Nombre");
//			nombreTXT.setRequired(true);
//			add(nombreTXT);
//
//			TextField nombreTXT2 = new TextField("Nombre2");
//			nombreTXT2.setRequired(true);
//			add(nombreTXT2);
//
//			binder.forField(nombreTXT).asRequired("El campo \"Nombre\" es requerido, no puede estar vacio.")
//					.withValidator(name -> name.length() >= 3,
//							"El campo \"Nombre\" debe contener al menos tres caracteres")
//					.bind(BancoFiltro::getNombre, BancoFiltro::setNombre);
//
//			binder.forField(nombreTXT2).asRequired("El campo \"Nombre\" es requerido, no puede estar vacio.")
//					.withValidator(name -> name.length() >= 3,
//							"El campo \"Nombre\" debe contener al menos tres caracteres")
//					.bind(BancoFiltro::getNombre, BancoFiltro::setNombre);
//
//			BancoGrid grid = new BancoGrid(bancoFiltro);
//
//			Button saveButton = new Button("Filtrar", event -> {
//				if (binder.isValid()) {
//					grid.refreshAll();
//				}
//			});
//
//			add(saveButton);
//			add(grid);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static final long serialVersionUID = 9176214270115665566L;
}
