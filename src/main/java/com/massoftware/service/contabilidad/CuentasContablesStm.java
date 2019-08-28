
package com.massoftware.service.contabilidad;

import org.sorm.stm.StatementParam;

public class CuentasContablesStm extends StatementParam {

	public CuentasContablesStm(CuentasContablesFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ CuentasContablesFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			
			
			if (f.getEjercicioContable() == null || f.getEjercicioContable().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + CuentasContablesFiltro.class.getCanonicalName() + ".ejercicioContable para filtrar la consulta");
			}

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "CuentaContable.id ";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += "";

		String sql = "SELECT  " + atts + " FROM massoftware.CuentaContable " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(CuentasContablesFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getCodigo() != null && f.getCodigo().trim().isEmpty() == false) {
			String[] words =  f.getCodigo().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(CuentaContable.Codigo))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(CuentaContable.Nombre))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
		}
	
		if (f.getEjercicioContable() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CuentaContable.EjercicioContable = ?";
			this.addArg(buildArgTrim(f.getEjercicioContable().getId(), String.class));
		}

		
		//-----------------

		if (where.trim().isEmpty() == false) {
			where = " WHERE " + where;
		}

		return where;
	}

	

}