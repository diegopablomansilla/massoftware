
package com.massoftware.service.contabilidad;

import org.sorm.stm.StatementParam;

public class AsientosModelosItemsStm extends StatementParam {

	public AsientosModelosItemsStm(AsientosModelosItemsFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ AsientosModelosItemsFiltro.class.getCanonicalName());
		}
		
		
	
		if (f.getAsientoModelo() == null || f.getAsientoModelo().toString().trim().isEmpty()) {
			throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + AsientosModelosItemsFiltro.class.getCanonicalName() + ".asientoModelo para filtrar la consulta");
		}


		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";

		if (count == false) {

			atts = "AsientoModeloItem.id ";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}

		}

		String sql = "SELECT  " + atts + " FROM massoftware.AsientoModeloItem " + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(AsientosModelosItemsFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getAsientoModelo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoModeloItem.AsientoModelo = ?";
			this.addArg(buildArgTrimLower(f.getAsientoModelo(), String.class));
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