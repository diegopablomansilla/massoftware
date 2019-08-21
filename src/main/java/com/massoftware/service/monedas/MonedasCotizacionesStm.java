
package com.massoftware.service.monedas;

import org.sorm.stm.StatementParam;

public class MonedasCotizacionesStm extends StatementParam {

	public MonedasCotizacionesStm(MonedasCotizacionesFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ MonedasCotizacionesFiltro.class.getCanonicalName());
		}
		
		
	
		if (f.getCotizacionFechaFrom() == null || f.getCotizacionFechaFrom().toString().trim().isEmpty()) {
			throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + MonedasCotizacionesFiltro.class.getCanonicalName() + ".name para filtrar la consulta");
		}
	
		if (f.getCotizacionFechato() == null || f.getCotizacionFechato().toString().trim().isEmpty()) {
			throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + MonedasCotizacionesFiltro.class.getCanonicalName() + ".name para filtrar la consulta");
		}


		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";

		if (count == false) {

			atts = "";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}

		}

		String sql = "SELECT  " + atts + " FROM massoftware.MonedaCotizacion " + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(MonedasCotizacionesFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getMoneda() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " MonedaCotizacion.Moneda = ?";
			this.addArg(buildArgTrimLower(f.getMoneda(), java.lang.String.class));
		}
	
		if (f.getCotizacionFechaFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " MonedaCotizacion.CotizacionFecha >= ?";
			this.addArg(buildArgTrimLower(f.getCotizacionFechaFrom(), Timestamp.class));
		}
	
		if (f.getCotizacionFechaTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " MonedaCotizacion.CotizacionFecha <= ?";
			this.addArg(buildArgTrimLower(f.getCotizacionFechaTo(), Timestamp.class));
		}

		
		//-----------------

		if (where.trim().isEmpty() == false) {
			where = " WHERE " + where;
		}

		return where;
	}

	@SuppressWarnings("rawtypes")
	private Object buildArgTrimLower(Object arg, Class c) {
		if (c == String.class) {
			return (arg == null || arg.toString().trim().isEmpty()) ? c
					: "%" + arg.toString().trim().toLowerCase() + "%";
		}
		return (arg == null || arg.toString().trim().isEmpty()) ? c : arg;
	}

}