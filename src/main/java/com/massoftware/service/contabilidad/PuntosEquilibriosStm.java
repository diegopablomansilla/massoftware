
package com.massoftware.service.contabilidad;

import org.sorm.stm.StatementParam;

public class PuntosEquilibriosStm extends StatementParam {

	public PuntosEquilibriosStm(PuntosEquilibriosFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ PuntosEquilibriosFiltro.class.getCanonicalName());
		}
		
		
	
		if (f.getEjercicioContable() == null || f.getEjercicioContable().toString().trim().isEmpty()) {
			throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + PuntosEquilibriosFiltro.class.getCanonicalName() + ".ejercicioContable para filtrar la consulta");
		}


		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";

		if (count == false) {

			atts = "PuntoEquilibrio.id, ";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}

		}

		String sql = "SELECT  " + atts + " FROM massoftware.PuntoEquilibrio " + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(PuntosEquilibriosFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " PuntoEquilibrio.Numero >= ?";
			this.addArg(buildArgTrimLower(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " PuntoEquilibrio.Numero <= ?";
			this.addArg(buildArgTrimLower(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(PuntoEquilibrio.Nombre))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
	}
	
		if (f.getEjercicioContable() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " PuntoEquilibrio.EjercicioContable = ?";
			this.addArg(buildArgTrimLower(f.getEjercicioContable(), String.class));
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