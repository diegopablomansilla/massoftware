
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;


import com.massoftware.ui.views.GridCustom;
//import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
//import com.vaadin.flow.data.renderer.TemplateRenderer;

import com.massoftware.ui.components.UIUtils;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.Component;


public class UIChequerasGrid extends GridCustom<Chequeras> {

	private ChequerasFiltro filter;
	private ChequeraService service;

	public UIChequerasGrid(ChequeraService service, ChequerasFiltro filter) {
		super(Chequeras.class, true, true, true, true);
		this.filter = filter;
		this.service = service;
		//laodItems();
	}

	protected void addColumns() {

		// --------------------------------------------------------------------------------------------------

		addColumn(Chequeras::getId, "id")
			.setKey("id")
			.setSortProperty("1")
			.setHeader("ID")
			.setVisible(false);

		addColumn(Chequeras::toString, "toString")
			.setKey("toString")
			.setSortProperty("2")
			.setHeader("Chequera")
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
			
			
	
			if (filter.getCuentaFondo() == null || filter.getCuentaFondo().toString().trim().isEmpty()) {
				return 0;
			}

		
			return service.count(filter);
		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo contar la cantidad ítems !!");
		}

		return 0;
	}

	protected List<Chequeras> findFromService(int offset, int limit, Integer orderBy, Boolean orderByDesc) {

		try {
		
			
	
			if (filter.getCuentaFondo() == null || filter.getCuentaFondo().toString().trim().isEmpty()) {
				return new ArrayList<Chequeras>();
			}


			filter.setOffset(offset);
			filter.setLimit(limit);
			filter.setOrderBy(orderBy);
			filter.setOrderByDesc(orderByDesc);

			List<Chequeras> items = service.find(filter);

			Notification.show("offset: " + offset + ", limit: " + limit + ", orderBy: " + orderBy + ", orderByDesc: "
					+ orderByDesc + ", items.size(): " + items.size());

			return items;

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar los ítems !!");
		}

		return new ArrayList<Chequeras>();
	}

	protected boolean removeItemFromService(Chequeras item) {

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