
package com.massoftware.service.contabilidad;

import org.sorm.stm.StatementParam;

public class AsientosContablesModulosStm extends StatementParam {

	public AsientosContablesModulosStm(AsientosContablesModulosFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ AsientosContablesModulosFiltro.class.getCanonicalName());
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

		String sql = "SELECT  " + atts + " FROM massoftware.AsientoContableModulo " + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(AsientosContablesModulosFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoContableModulo.Numero >= ?";
			this.addArg(buildArgTrimLower(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoContableModulo.Numero <= ?";
			this.addArg(buildArgTrimLower(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(AsientoContableModulo.Nombre))" + translate + ") LIKE ?";
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