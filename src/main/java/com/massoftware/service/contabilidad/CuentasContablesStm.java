
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

			atts = "CuentaContable.id , EjercicioContable.numero AS nombreEjercicioContable, CuentaContable.codigo, CuentaContable.nombre, CentroCostoContable.nombre AS nombreCentroCostoContable, CuentaContable.cuentaAgrupadora, CuentaContable.porcentaje";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += " LEFT JOIN massoftware.EjercicioContable ON EjercicioContable.id = CuentaContable.ejercicioContable LEFT JOIN massoftware.CentroCostoContable ON CentroCostoContable.id = CuentaContable.centroCostoContable";

		String sql = "SELECT  " + atts + " FROM massoftware.CuentaContable " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(CuentasContablesFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getEjercicioContable() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CuentaContable.EjercicioContable = ?";
			this.addArg(buildArgTrim(f.getEjercicioContable().getId(), String.class));
		}
	
		if (f.getCentroCostoContable() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CuentaContable.CentroCostoContable = ?";
			this.addArg(buildArgTrim(f.getCentroCostoContable().getId(), String.class));
		}
	
		if (f.getPuntoEquilibrio() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CuentaContable.PuntoEquilibrio = ?";
			this.addArg(buildArgTrim(f.getPuntoEquilibrio().getId(), String.class));
		}
	
		if (f.getCodigo() != null && f.getCodigo().trim().isEmpty() == false) {
			String[] words =  f.getCodigo().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(CuentaContable.Codigo))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
		}
	
		if (f.getCuentaAgrupadora() != null && f.getCuentaAgrupadora().trim().isEmpty() == false) {
			String[] words =  f.getCuentaAgrupadora().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(CuentaContable.CuentaAgrupadora))" + translate + ") LIKE ?";
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

		
		//-----------------

		if (where.trim().isEmpty() == false) {
			where = " WHERE " + where;
		}

		return where;
	}

	

}