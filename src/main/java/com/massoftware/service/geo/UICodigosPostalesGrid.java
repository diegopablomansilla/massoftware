
package com.massoftware.service.geo;

import java.util.ArrayList;
import java.util.List;


import com.massoftware.ui.views.GridCustom;
//import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
//import com.vaadin.flow.data.renderer.TemplateRenderer;



public class UICodigosPostalesGrid extends GridCustom<CodigosPostales> {

	private CodigosPostalesFiltro filter;
	private CodigoPostalService service;

	public UICodigosPostalesGrid(CodigoPostalService service, CodigosPostalesFiltro filter) {
		super(CodigosPostales.class, true, true, true, true);
		this.filter = filter;
		this.service = service;
		//laodItems();
	}

	protected void addColumns() {

		// --------------------------------------------------------------------------------------------------

		addColumn(CodigosPostales::getId, "id")
			.setKey("id")
			.setSortProperty("1")
			.setHeader("ID")
			.setVisible(false);

		addColumn(CodigosPostales::toString, "toString")
			.setKey("toString")
			.setSortProperty("2")
			.setHeader("Código postal")
			.setVisible(false);

		/* EJEMPLO
		addColumn(TemplateRenderer.<Bancos>of("<div>[[item.cuit]]<br><small>[[item.nombre]]</small></div>")
			.withProperty("cuit", Bancos::getCuit)
			.withProperty("nombre", Bancos::getNombre), "cuit", "nombre")
			.setKey("toString2")
			.setSortProperty("2")
			.setHeader("Banco")
			.setVisible(false);
		 */
		
		// --------------------------------------------------------------------------------------------------
		
		addColumn(CodigosPostales::getNombrePais, "nombrePais")
			.setKey("nombrePais")
			.setResizable(true)
			.setSortProperty("2")
			.setHeader("Pais");

		addColumn(CodigosPostales::getNombreProvincia, "nombreProvincia")
			.setKey("nombreProvincia")
			.setResizable(true)
			.setSortProperty("3")
			.setHeader("Provincia");

		addColumn(CodigosPostales::getNombreCiudad, "nombreCiudad")
			.setKey("nombreCiudad")
			.setResizable(true)
			.setSortProperty("4")
			.setHeader("Ciudad");

		addColumn(CodigosPostales::getCodigo, "codigo")
			.setKey("codigo")
			.setResizable(true)
			.setSortProperty("5")
			.setHeader("Código");

		addColumn(CodigosPostales::getNumero, "numero")
			.setKey("numero")
			.setResizable(true)
			.setSortProperty("6")
			.setHeader("Secuencia");

		addColumn(CodigosPostales::getNumeroCalle, "numeroCalle")
			.setKey("numeroCalle")
			.setResizable(true)
			.setSortProperty("7")
			.setHeader("Número calle");

		addColumn(CodigosPostales::getNombreCalle, "nombreCalle")
			.setKey("nombreCalle")
			.setResizable(true)
			.setSortProperty("8")
			.setHeader("Calle");

		/* EJEMPLOS
		addColumn(Bancos::getNumero, "numero")
			.setKey("numero")
			.setResizable(true)
			.setSortProperty("2")
			.setHeader("Número");

		addColumn(TemplateRenderer.<Bancos>of("<b>[[item.nombre]]</b>")
				.withProperty("nombre", Bancos::getNombre))
				.setKey("nombre")
				.setResizable(true)
				.setSortProperty("3")
				.setHeader("Nombre");

//		addColumn(Bancos::getCuit, "cuit").setKey("cuit").setResizable(true).setSortProperty("4").setHeader("CUIT");
		addColumn(new ComponentRenderer<>(this::createRendererCuit))
			.setKey("cuit")
			.setResizable(true)
			.setSortProperty("4")
			.setHeader("CUIT");

		addColumn(new ComponentRenderer<>(this::createRendererVigente))
			.setKey("vigente")
			.setResizable(true)
			.setSortProperty("5")
			.setHeader("Vigente"); // .setTextAlign(ColumnTextAlign.CENTER);
		 */
		// --------------------------------------------------------------------------------------------------

	}
	
	
	
	/* EJEMPLOS
	private Component createRendererVigente(Bancos item) {
		return (item.getVigente() == true) ? UIUtils.createPrimaryIcon(VaadinIcon.CHECK)
				: UIUtils.createDisabledIcon(VaadinIcon.CLOSE);
	}
	
	
	private Component createRendererCuit(Bancos item) {
		String cuit = "";
		if (item.getCuit() != null) {
			cuit = item.getCuit().toString();
			String prefix = cuit.substring(0, 2);
			String body = cuit.substring(2, cuit.length() - 2);
			String sufix = cuit.substring(cuit.length() - 2, cuit.length() - 1);
			cuit = prefix + "-" + body + "-" + sufix;
		}

		return new Label(cuit);
	}
	*/

	// --------------------------------------------------------------------------------------------------

	protected Integer countFromService() {

		try {
			
			
	
			if (filter.getPais() == null || filter.getPais().toString().trim().isEmpty()) {
				return 0;
			}
	
			if (filter.getProvincia() == null || filter.getProvincia().toString().trim().isEmpty()) {
				return 0;
			}
	
			if (filter.getCiudad() == null || filter.getCiudad().toString().trim().isEmpty()) {
				return 0;
			}

		
			return service.count(filter);
		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo contar la cantidad ítems !!");
		}

		return 0;
	}

	protected List<CodigosPostales> findFromService(int offset, int limit, Integer orderBy, Boolean orderByDesc) {

		try {
		
			
	
			if (filter.getPais() == null || filter.getPais().toString().trim().isEmpty()) {
				return new ArrayList<CodigosPostales>();
			}
	
			if (filter.getProvincia() == null || filter.getProvincia().toString().trim().isEmpty()) {
				return new ArrayList<CodigosPostales>();
			}
	
			if (filter.getCiudad() == null || filter.getCiudad().toString().trim().isEmpty()) {
				return new ArrayList<CodigosPostales>();
			}


			filter.setOffset(offset);
			filter.setLimit(limit);
			filter.setOrderBy(orderBy);
			filter.setOrderByDesc(orderByDesc);

			List<CodigosPostales> items = service.find(filter);

			Notification.show("offset: " + offset + ", limit: " + limit + ", orderBy: " + orderBy + ", orderByDesc: "
					+ orderByDesc + ", items.size(): " + items.size());

			return items;

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar los ítems !!");
		}

		return new ArrayList<CodigosPostales>();
	}

	protected boolean removeItemFromService(CodigosPostales item) {

		boolean r = false;

		try {
			r = service.deleteById(item.getId());
		} catch (Exception e) {
			r = false;
		}

		if (r) {
			Notification.show("El ítem '" + item + "' se borró con éxito");
		} else {
			Notification.show("No se pudo borrar el ítem !!");
		}

		return r;
	}

	// --------------------------------------------------------------------------------------------------

//	public void ccc(JsonObject eventData) {
//
//		try {
//
//			String id = eventData.getString("col0");
//			Integer numero = Integer.valueOf(eventData.getString("col1"));
//			String nombre = eventData.getString("col2");
//
//			Banco b = new Banco();
//			b.setId(id);
//
//						
//			
//			this.getSelectionModel().selectFromClient(b);
////			this.select(b);
//			
////			Banco b2 = this.getSelectionModel().getFirstSelectedItem().get(); 
//			Notification.show(nombre);
//			
////			
//
////			b.setNombre(nombre);
////			b.setNumero(numero);
//
////			this.getDataProvider().refreshItem(b);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Notification.show(e.toString());
//		}
//
//	}

	private static final long serialVersionUID = 5047281514894427842L;

}