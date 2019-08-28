
package com.massoftware.service.seguridad;

import org.sorm.stm.StatementParam;

public class SeguridadPuertasStm extends StatementParam {

	public SeguridadPuertasStm(SeguridadPuertasFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ SeguridadPuertasFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			
			
			if (f.getSeguridadModulo() == null || f.getSeguridadModulo().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + SeguridadPuertasFiltro.class.getCanonicalName() + ".seguridadModulo para filtrar la consulta");
			}

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "SeguridadPuerta.id , SeguridadModulo.nombre AS nombreModulo, SeguridadPuerta.numero, SeguridadPuerta.nombre";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += " LEFT JOIN massoftware.SeguridadModulo ON SeguridadModulo.id = SeguridadPuerta.seguridadModulo";

		String sql = "SELECT  " + atts + " FROM massoftware.SeguridadPuerta " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(SeguridadPuertasFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getSeguridadModulo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " SeguridadPuerta.SeguridadModulo = ?";
			this.addArg(buildArgTrim(f.getSeguridadModulo().getId(), String.class));
		}
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " SeguridadPuerta.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " SeguridadPuerta.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(SeguridadPuerta.Nombre))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
		}

		
		//-----------------

		if (where.trim().isEmpty() == false) {
			where = " WHERE " + where;
		}

		return where;
	}

	

}