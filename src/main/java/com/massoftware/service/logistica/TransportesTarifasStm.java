
package com.massoftware.service.logistica;

import org.sorm.stm.StatementParam;

public class TransportesTarifasStm extends StatementParam {

	public TransportesTarifasStm(TransportesTarifasFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ TransportesTarifasFiltro.class.getCanonicalName());
		}
		
		
	
		if (f.getTransporte() == null || f.getTransporte().toString().trim().isEmpty()) {
			throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + TransportesTarifasFiltro.class.getCanonicalName() + ".transporte para filtrar la consulta");
		}


		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";

		if (count == false) {

			atts = "TransporteTarifa.id ";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}

		}

		String sql = "SELECT  " + atts + " FROM massoftware.TransporteTarifa " + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(TransportesTarifasFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getTransporte() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " TransporteTarifa.Transporte = ?";
			this.addArg(buildArgTrim(f.getTransporte().getId(), String.class));
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