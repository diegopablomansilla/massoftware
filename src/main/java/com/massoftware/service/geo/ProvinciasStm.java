
package com.massoftware.service.geo;

import org.sorm.stm.StatementParam;

public class ProvinciasStm extends StatementParam {

	public ProvinciasStm(ProvinciasFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ ProvinciasFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			
			
			if (f.getPais() == null || f.getPais().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + ProvinciasFiltro.class.getCanonicalName() + ".pais para filtrar la consulta");
			}

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "Provincia.id , Pais.nombre AS nombrePais, Provincia.numero, Provincia.abreviatura, Provincia.nombre";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += " LEFT JOIN massoftware.Pais ON Pais.id = Provincia.pais";

		String sql = "SELECT  " + atts + " FROM massoftware.Provincia " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(ProvinciasFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getPais() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Provincia.Pais = ?";
			this.addArg(buildArgTrim(f.getPais().getId(), String.class));
		}
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Provincia.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Provincia.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getAbreviatura() != null && f.getAbreviatura().trim().isEmpty() == false) {
			String[] words =  f.getAbreviatura().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(Provincia.Abreviatura))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(Provincia.Nombre))" + translate + ") LIKE ?";
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