
package com.massoftware.service.logistica;

import org.sorm.stm.StatementParam;

public class TransportesTarifasStm extends StatementParam {

	public TransportesTarifasStm(TransportesTarifasFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ TransportesTarifasFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			
			
			if (f.getTransporte() == null || f.getTransporte().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + TransportesTarifasFiltro.class.getCanonicalName() + ".transporte para filtrar la consulta");
			}

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "TransporteTarifa.id , Transporte.nombre AS nombreTransporte, Carga.numero AS numeroCarga, Carga.nombre AS nombreCarga, TransporteTarifa.numero, Ciudad.nombre AS nombreCiudad, TransporteTarifa.precioFlete, TransporteTarifa.precioUnidadFacturacion, TransporteTarifa.precioUnidadStock, TransporteTarifa.precioBultos, TransporteTarifa.importeMinimoEntrega";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += " LEFT JOIN massoftware.Carga ON Carga.id = TransporteTarifa.carga LEFT JOIN massoftware.Transporte ON Transporte.id = Carga.transporte LEFT JOIN massoftware.Ciudad ON Ciudad.id = TransporteTarifa.ciudad";

		String sql = "SELECT  " + atts + " FROM massoftware.TransporteTarifa " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(TransportesTarifasFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getTransporte() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Transporte.id = ?";
			this.addArg(buildArgTrim(f.getTransporte().getId(), String.class));
		}

		
		//-----------------

		if (where.trim().isEmpty() == false) {
			where = " WHERE " + where;
		}

		return where;
	}

	

}