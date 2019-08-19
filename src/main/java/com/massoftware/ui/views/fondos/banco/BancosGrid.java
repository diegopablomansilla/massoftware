package com.massoftware.ui.views.fondos.banco;

import java.util.ArrayList;
import java.util.List;

import com.massoftware.service.fondos.banco.BancoService;
import com.massoftware.service.fondos.banco.Bancos;
import com.massoftware.service.fondos.banco.BancosFiltro;
import com.massoftware.ui.components.UIUtils;
import com.massoftware.ui.views.GridCustom;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.renderer.ComponentRenderer;

public class BancosGrid extends GridCustom<Bancos> {

	private BancosFiltro filter;
	private BancoService service;

	public BancosGrid(BancoService service, BancosFiltro filter) {
		super(Bancos.class);
		this.filter = filter;
		this.service = service;
		laodItems();		
	}

	protected void addColumns() {

		// --------------------------------------------------------------------------------------------------

		addColumn(Bancos::getId, "id").setKey("id").setSortProperty("1").setHeader("ID")
				.setVisible(false);

		addColumn(Bancos::toString, "toString").setKey("toString").setSortProperty("2")
				.setHeader("Banco").setVisible(false);

		// --------------------------------------------------------------------------------------------------

		addColumn(Bancos::getNumero, "numero").setKey("numero").setResizable(true).setSortProperty("2")
				.setHeader("Número");

		addColumn(Bancos::getNombre, "nombre").setKey("nombre").setResizable(true).setSortProperty("3")
				.setHeader("Nombre");

		addColumn(Bancos::getCuit, "cuit").setKey("cuit").setResizable(true).setSortProperty("4")
				.setHeader("CUIT");

		addColumn(new ComponentRenderer<>(this::createBloqueado)).setKey("bloqueado").setResizable(true)
				.setSortProperty("5").setHeader("Vigente").setTextAlign(ColumnTextAlign.CENTER);

		// --------------------------------------------------------------------------------------------------

		this.addComponentColumn(item -> createActionsColumn(this, item)).setHeader("").setTextAlign(ColumnTextAlign.END);

		// --------------------------------------------------------------------------------------------------

	}

	private Component createBloqueado(Bancos item) {
		return (item.getBloqueado() == true) ? UIUtils.createPrimaryIcon(VaadinIcon.CHECK)
				: UIUtils.createDisabledIcon(VaadinIcon.CLOSE);
	}

	// --------------------------------------------------------------------------------------------------

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
				// ALERT: throw new IllegalArgumentException("Se esperaba un id (Banco.id) no
				// nulo/vacio.");
			}

			return service.deleteById(item.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
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
