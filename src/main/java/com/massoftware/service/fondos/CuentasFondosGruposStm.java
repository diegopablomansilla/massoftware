
package com.massoftware.service.fondos;

import org.sorm.stm.StatementParam;

public class CuentasFondosGruposStm extends StatementParam {

	public CuentasFondosGruposStm(CuentasFondosGruposFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ CuentasFondosGruposFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			
			
			if (f.getCuentaFondoRubro() == null || f.getCuentaFondoRubro().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + CuentasFondosGruposFiltro.class.getCanonicalName() + ".cuentaFondoRubro para filtrar la consulta");
			}

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "CuentaFondoGrupo.id ";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += "";

		String sql = "SELECT  " + atts + " FROM massoftware.CuentaFondoGrupo " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(CuentasFondosGruposFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CuentaFondoGrupo.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CuentaFondoGrupo.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(CuentaFondoGrupo.Nombre))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
		}
	
		if (f.getCuentaFondoRubro() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CuentaFondoGrupo.CuentaFondoRubro = ?";
			this.addArg(buildArgTrim(f.getCuentaFondoRubro().getId(), String.class));
		}

		
		//-----------------

		if (where.trim().isEmpty() == false) {
			where = " WHERE " + where;
		}

		return where;
	}

	

}