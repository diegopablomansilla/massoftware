
package com.massoftware.service.fondos;

import org.sorm.stm.StatementParam;

public class ComprobantesFondosModelosItemsStm extends StatementParam {

	public ComprobantesFondosModelosItemsStm(ComprobantesFondosModelosItemsFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ ComprobantesFondosModelosItemsFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			
			
			if (f.getCuentaFondo() == null || f.getCuentaFondo().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + ComprobantesFondosModelosItemsFiltro.class.getCanonicalName() + ".cuentaFondo para filtrar la consulta");
			}

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "ComprobanteFondoModeloItem.id ";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += "";

		String sql = "SELECT  " + atts + " FROM massoftware.ComprobanteFondoModeloItem " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(ComprobantesFondosModelosItemsFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " ComprobanteFondoModeloItem.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " ComprobanteFondoModeloItem.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getCuentaFondo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " ComprobanteFondoModeloItem.CuentaFondo = ?";
			this.addArg(buildArgTrim(f.getCuentaFondo().getId(), String.class));
		}

		
		//-----------------

		if (where.trim().isEmpty() == false) {
			where = " WHERE " + where;
		}

		return where;
	}

	

}