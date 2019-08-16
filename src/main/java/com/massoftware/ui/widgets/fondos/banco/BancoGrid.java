package com.massoftware.ui.widgets.fondos.banco;

import java.util.ArrayList;
import java.util.List;

import com.massoftware.service.fondos.banco.BancoService;
import com.massoftware.service.fondos.banco.Bancos;
import com.massoftware.service.fondos.banco.BancosFiltro;
import com.massoftware.ui.widgets.GridCustom;
import com.vaadin.flow.component.notification.Notification;

public class BancoGrid extends GridCustom<Bancos> {

	private BancosFiltro filter;
	private BancoService service;

	public BancoGrid(BancoService service, BancosFiltro filter) {
		super(Bancos.class);
		this.filter = filter;
		this.service = service;
		laodItems();
	}

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

	protected void addColumns() {

//		addColumn(TemplateRenderer.<Banco>of("<b>[[item.id]]</b>").withProperty("id", Banco::getId)).setHeader("ID 1")	
//				.setSortable(true).setComparator((item1, item2) -> item1.getId().compareToIgnoreCase(item2.getId()));

//		addColumn(TemplateRenderer.<Banco>of("<b>[[item.id]]</b>").withProperty("id", Banco::getId)).setHeader("ID 2")
//				.setSortProperty("id").setSortable(true);

		// --------------------------------------------------------------------------------------------------

		addColumn(Bancos::getId, "id").setKey("id").setSortProperty("1").setHeader("ID");
		addColumn(Bancos::toString, "toString").setKey("toString").setSortProperty("2").setHeader("Banco");

		// --------------------------------------------------------------------------------------------------

		addColumn(Bancos::getNumero, "numero").setKey("numero").setResizable(true).setSortProperty("2")
				.setHeader("Número");
		addColumn(Bancos::getNombre, "nombre").setKey("nombre").setFrozen(true).setSortProperty("3")
				.setHeader("Nombre");

		// --------------------------------------------------------------------------------------------------

		this.addComponentColumn(item -> createActionsColumn(this, item)).setHeader("");

		// --------------------------------------------------------------------------------------------------

	}

	protected Integer countFromService() {

		try {

			return service.count(filter);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	protected List<Bancos> findFromService(int offset, int limit, Integer orderBy, Boolean orderByDesc) {

		try {

			filter.setOffset(offset);
			filter.setLimit(limit);
			filter.setOrderBy(orderBy);
			filter.setOrderByDesc(orderByDesc);

			List<Bancos> items = service.find(filter);

			Notification.show("offset: " + offset + ", limit: " + limit + ", orderBy: " + orderBy + ", orderByDesc: "
					+ orderByDesc + ", items.size(): " + items.size());

			return items;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<Bancos>();
	}

	protected boolean removeItemFromService(Bancos item) {
		try {
			
			if (item == null) {
//				throw new IllegalArgumentException("Se esperaba un objeto Banco no nulo.");
			}
			
			if (item.getId() == null || item.getId().trim().length() == 0) {
				// ALERT: throw new IllegalArgumentException("Se esperaba un id (Banco.id) no nulo/vacio.");
			}
			
			return service.deleteById(item.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	private static final long serialVersionUID = 5047281514894427842L;

}
