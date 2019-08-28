
package com.massoftware.service.monedas;

import org.sorm.stm.StatementParam;

public class MonedasCotizacionesStm extends StatementParam {

	public MonedasCotizacionesStm(MonedasCotizacionesFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ MonedasCotizacionesFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			
			
			if (f.getCotizacionFechaFrom() == null || f.getCotizacionFechaFrom().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + MonedasCotizacionesFiltro.class.getCanonicalName() + ".cotizacionFechaFrom para filtrar la consulta");
			}
			
			if (f.getCotizacionFechaTo() == null || f.getCotizacionFechaTo().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + MonedasCotizacionesFiltro.class.getCanonicalName() + ".cotizacionFechaTo para filtrar la consulta");
			}

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "MonedaCotizacion.id , MonedaCotizacion.cotizacionFecha, MonedaCotizacion.compra, MonedaCotizacion.venta, MonedaCotizacion.moneda";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += "";

		String sql = "SELECT  " + atts + " FROM massoftware.MonedaCotizacion " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(MonedasCotizacionesFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getMoneda() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " MonedaCotizacion.Moneda = ?";
			this.addArg(buildArgTrim(f.getMoneda().getId(), String.class));
		}
	
		if (f.getCotizacionFechaFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " MonedaCotizacion.CotizacionFecha >= ?";
			this.addArg(buildArgTrim(f.getCotizacionFechaFrom(), java.sql.Timestamp.class));
		}
	
		if (f.getCotizacionFechaTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " MonedaCotizacion.CotizacionFecha <= ?";
			this.addArg(buildArgTrim(f.getCotizacionFechaTo(), java.sql.Timestamp.class));
		}

		
		//-----------------

		if (where.trim().isEmpty() == false) {
			where = " WHERE " + where;
		}

		return where;
	}

	

}