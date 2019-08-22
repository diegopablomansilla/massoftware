
package com.massoftware.service.geo;

import org.sorm.stm.StatementParam;

public class ProvinciasStm extends StatementParam {

	public ProvinciasStm(ProvinciasFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ ProvinciasFiltro.class.getCanonicalName());
		}
		
		
	
		if (f.getPais() == null || f.getPais().toString().trim().isEmpty()) {
//			throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + ProvinciasFiltro.class.getCanonicalName() + ".pais para filtrar la consulta");
		}


		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";

		if (count == false) {

			atts = "Provincia.id ";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}

		}

		String sql = "SELECT  " + atts + " FROM massoftware.Provincia " + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(ProvinciasFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Provincia.Numero >= ?";
			this.addArg(buildArgTrimLower(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Provincia.Numero <= ?";
			this.addArg(buildArgTrimLower(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(Provincia.Nombre))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
	}
	
		if (f.getAbreviatura() != null && f.getAbreviatura().trim().isEmpty() == false) {
			String[] words =  f.getAbreviatura().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(Provincia.Abreviatura))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
	}
	
		if (f.getPais() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Provincia.Pais = ?";
			this.addArg(buildArgTrimLower(f.getPais(), String.class));
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