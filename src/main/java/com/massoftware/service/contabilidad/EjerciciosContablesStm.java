
package com.massoftware.service.contabilidad;

import org.sorm.stm.StatementParam;

public class EjerciciosContablesStm extends StatementParam {

	public EjerciciosContablesStm(EjerciciosContablesFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ EjerciciosContablesFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "EjercicioContable.id , EjercicioContable.numero, EjercicioContable.apertura, EjercicioContable.cierre, EjercicioContable.cerrado, EjercicioContable.cerradoModulos";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += "";

		String sql = "SELECT  " + atts + " FROM massoftware.EjercicioContable " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(EjerciciosContablesFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " EjercicioContable.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " EjercicioContable.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}

		
		//-----------------

		if (where.trim().isEmpty() == false) {
			where = " WHERE " + where;
		}

		return where;
	}

	

}