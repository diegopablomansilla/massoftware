
package com.massoftware.service.clientes;

import java.util.ArrayList;
import java.util.List;


import com.massoftware.ui.views.GridCustom;
//import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
//import com.vaadin.flow.data.renderer.TemplateRenderer;



public class UIMotivosBloqueosClientesGrid extends GridCustom<MotivosBloqueosClientes> {

	private MotivosBloqueosClientesFiltro filter;
	private MotivoBloqueoClienteService service;

	public UIMotivosBloqueosClientesGrid(MotivoBloqueoClienteService service, MotivosBloqueosClientesFiltro filter) {
		super(MotivosBloqueosClientes.class, true, true, true, true);
		this.filter = filter;
		this.service = service;
		//laodItems();
	}

	protected void addColumns() {

		// --------------------------------------------------------------------------------------------------

		addColumn(MotivosBloqueosClientes::getId, "id")
			.setKey("id")
			.setSortProperty("1")
			.setHeader("ID")
			.setVisible(false);

		addColumn(MotivosBloqueosClientes::toString, "toString")
			.setKey("toString")
			.setSortProperty("2")
			.setHeader("Motivo bloqueo a cliente")
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
		
		addColumn(MotivosBloqueosClientes::getNombreClasificacionCliente, "nombreClasificacionCliente")
			.setKey("nombreClasificacionCliente")
			.setResizable(true)
			.setSortProperty("2")
			.setHeader("Clasificación de cliente");

		addColumn(MotivosBloqueosClientes::getNumero, "numero")
			.setKey("numero")
			.setResizable(true)
			.setSortProperty("3")
			.setHeader("Nº motivo");

		addColumn(MotivosBloqueosClientes::getNombre, "nombre")
			.setKey("nombre")
			.setResizable(true)
			.setSortProperty("4")
			.setHeader("Nombre");

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
			
			
	
			if (filter.getClasificacionCliente() == null || filter.getClasificacionCliente().toString().trim().isEmpty()) {
				return 0;
			}

		
			return service.count(filter);
		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo contar la cantidad ítems !!");
		}

		return 0;
	}

	protected List<MotivosBloqueosClientes> findFromService(int offset, int limit, Integer orderBy, Boolean orderByDesc) {

		try {
		
			
	
			if (filter.getClasificacionCliente() == null || filter.getClasificacionCliente().toString().trim().isEmpty()) {
				return new ArrayList<MotivosBloqueosClientes>();
			}


			filter.setOffset(offset);
			filter.setLimit(limit);
			filter.setOrderBy(orderBy);
			filter.setOrderByDesc(orderByDesc);

			List<MotivosBloqueosClientes> items = service.find(filter);

			Notification.show("offset: " + offset + ", limit: " + limit + ", orderBy: " + orderBy + ", orderByDesc: "
					+ orderByDesc + ", items.size(): " + items.size());

			return items;

		} catch (Exception e) {
			e.printStackTrace();
			Notification.show("No se pudo buscar los ítems !!");
		}

		return new ArrayList<MotivosBloqueosClientes>();
	}

	protected boolean removeItemFromService(MotivosBloqueosClientes item) {

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