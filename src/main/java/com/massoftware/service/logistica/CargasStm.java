
package com.massoftware.service.logistica;

import org.sorm.stm.StatementParam;

public class CargasStm extends StatementParam {

	public CargasStm(CargasFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ CargasFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			
			
			if (f.getTransporte() == null || f.getTransporte().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + CargasFiltro.class.getCanonicalName() + ".transporte para filtrar la consulta");
			}

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "Carga.id , Transporte.nombre AS nombreTransporte, Carga.numero, Carga.nombre";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += " LEFT JOIN massoftware.Transporte ON Transporte.id = Carga.transporte";

		String sql = "SELECT  " + atts + " FROM massoftware.Carga " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(CargasFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getTransporte() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Carga.Transporte = ?";
			this.addArg(buildArgTrim(f.getTransporte().getId(), String.class));
		}
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Carga.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Carga.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(Carga.Nombre))" + translate + ") LIKE ?";
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