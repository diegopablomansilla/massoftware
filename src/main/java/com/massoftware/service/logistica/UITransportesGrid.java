
package com.massoftware.service.logistica;

import java.util.ArrayList;
import java.util.List;


import com.massoftware.ui.views.GridCustom;
//import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
//import com.vaadin.flow.data.renderer.TemplateRenderer;



public class UITransportesGrid extends GridCustom<Transportes> {

	private TransportesFiltro filter;
	private TransporteService service;

	public UITransportesGrid(TransporteService service, TransportesFiltro filter) {
		super(Transportes.class, true, true, true, true);
		this.filter = filter;
		this.service = service;
		//laodItems();
	}

	protected void addColumns() {

		// --------------------------------------------------------------------------------------------------

		addColumn(Transportes::getId, "id")
			.setKey("id")
			.setSortProperty("1")
			.setHeader("ID")
			.setVisible(false);

		addColumn(Transportes::toString, "toString")
			.setKey("toString")
			.setSortProperty("2")
			.setHeader("Transporte")
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
		
		addColumn(Transportes::getNumero, "numero")
			.setKey("numero")
			.setResizable(true)
			.setSortProperty("2")
			.setHeader("Nº transporte");

		addColumn(Transportes::getCuit, "cuit")
			.setKey("cuit")
			.setResizable(true)
			.setSortProperty("3")
			.setHeader("CUIT");

		addColumn(Transportes::getNombre, "nombre")
			.setKey("nombre")
			.setResizable(true)
			.setSortProperty("4")
			.setHeader("Nombre");

		addColumn(Transportes::getDomicilio, "domicilio")
			.setKey("domicilio")
			.setResizable(true)
			.setSortProperty("5")
			.setHeader("Domicilio");

		addColumn(Transportes::getCodigoPostal, "codigoPostal")
			.setKey("codigoPostal")
			.setResizable(true)
			.setSortProperty("6")
			.setHeader("CP");

		addColumn(Transportes::getNombreCiudad, "nombreCiudad")
			.setKey("nombreCiudad")
			.setResizable(true)
			.setSortProperty("7")
			.setHeader("Ciudad");

		addColumn(Transportes::getNombreProvincia, "nombreProvincia")
			.setKey("nombreProvincia")
			.setResizable(true)
			.setSortProperty("8")
			.setHeader("Provincia");

		addColumn(Transportes::getNombrePais, "nombrePais")
			.setKey("nombrePais")
			.setResizable(true)
			.setSortProperty("9")
			.setHeader("Pais");

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
			
			

		
			return service.count(filter);
		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo contar la cantidad ítems !!");
		}

		return 0;
	}

	protected List<Transportes> findFromService(int offset, int limit, Integer orderBy, Boolean orderByDesc) {

		try {
		
			


			filter.setOffset(offset);
			filter.setLimit(limit);
			filter.setOrderBy(orderBy);
			filter.setOrderByDesc(orderByDesc);

			List<Transportes> items = service.find(filter);

			Notification.show("offset: " + offset + ", limit: " + limit + ", orderBy: " + orderBy + ", orderByDesc: "
					+ orderByDesc + ", items.size(): " + items.size());

			return items;

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar los ítems !!");
		}

		return new ArrayList<Transportes>();
	}

	protected boolean removeItemFromService(Transportes item) {

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