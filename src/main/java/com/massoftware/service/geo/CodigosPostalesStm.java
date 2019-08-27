
package com.massoftware.service.geo;

import org.sorm.stm.StatementParam;

public class CodigosPostalesStm extends StatementParam {

	public CodigosPostalesStm(CodigosPostalesFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ CodigosPostalesFiltro.class.getCanonicalName());
		}
		
		
	
		if (f.getPais() == null || f.getPais().toString().trim().isEmpty()) {
			throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + CodigosPostalesFiltro.class.getCanonicalName() + ".pais para filtrar la consulta");
		}
	
		if (f.getProvincia() == null || f.getProvincia().toString().trim().isEmpty()) {
			throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + CodigosPostalesFiltro.class.getCanonicalName() + ".provincia para filtrar la consulta");
		}
	
		if (f.getCiudad() == null || f.getCiudad().toString().trim().isEmpty()) {
			throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + CodigosPostalesFiltro.class.getCanonicalName() + ".ciudad para filtrar la consulta");
		}


		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";

		if (count == false) {

			atts = "CodigoPostal.id ";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}

		}

		String sql = "SELECT  " + atts + " FROM massoftware.CodigoPostal " + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(CodigosPostalesFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getCodigo() != null && f.getCodigo().trim().isEmpty() == false) {
			String[] words =  f.getCodigo().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(CodigoPostal.Codigo))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
		}
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CodigoPostal.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CodigoPostal.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getPais() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CodigoPostal.Pais = ?";
			this.addArg(buildArgTrim(f.getPais().getId(), String.class));
		}
	
		if (f.getProvincia() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CodigoPostal.Provincia = ?";
			this.addArg(buildArgTrim(f.getProvincia().getId(), String.class));
		}
	
		if (f.getCiudad() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CodigoPostal.Ciudad = ?";
			this.addArg(buildArgTrim(f.getCiudad().getId(), String.class));
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