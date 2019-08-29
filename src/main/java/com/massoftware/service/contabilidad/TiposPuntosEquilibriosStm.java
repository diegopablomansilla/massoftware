
package com.massoftware.service.contabilidad;

import org.sorm.stm.StatementParam;

public class TiposPuntosEquilibriosStm extends StatementParam {

	public TiposPuntosEquilibriosStm(TiposPuntosEquilibriosFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ TiposPuntosEquilibriosFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "TipoPuntoEquilibrio.id , TipoPuntoEquilibrio.numero, TipoPuntoEquilibrio.nombre";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += "";

		String sql = "SELECT  " + atts + " FROM massoftware.TipoPuntoEquilibrio " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(TiposPuntosEquilibriosFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " TipoPuntoEquilibrio.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " TipoPuntoEquilibrio.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(TipoPuntoEquilibrio.Nombre))" + translate + ") LIKE ?";
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