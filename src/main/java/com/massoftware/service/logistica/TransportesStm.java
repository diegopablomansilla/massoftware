
package com.massoftware.service.logistica;

import org.sorm.stm.StatementParam;

public class TransportesStm extends StatementParam {

	public TransportesStm(TransportesFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ TransportesFiltro.class.getCanonicalName());
		}
		
		


		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";

		if (count == false) {

			atts = "Transporte.id, ";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}

		}

		String sql = "SELECT  " + atts + " FROM massoftware.Transporte " + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(TransportesFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Transporte.Numero >= ?";
			this.addArg(buildArgTrimLower(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Transporte.Numero <= ?";
			this.addArg(buildArgTrimLower(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(Transporte.Nombre))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
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