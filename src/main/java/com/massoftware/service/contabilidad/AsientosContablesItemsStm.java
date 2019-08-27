
package com.massoftware.service.contabilidad;

import org.sorm.stm.StatementParam;

public class AsientosContablesItemsStm extends StatementParam {

	public AsientosContablesItemsStm(AsientosContablesItemsFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ AsientosContablesItemsFiltro.class.getCanonicalName());
		}
		
		
	
		if (f.getNumeroFrom() == null || f.getNumeroFrom().toString().trim().isEmpty()) {
			throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + AsientosContablesItemsFiltro.class.getCanonicalName() + ".numeroFrom para filtrar la consulta");
		}
	
		if (f.getNumeroTo() == null || f.getNumeroTo().toString().trim().isEmpty()) {
			throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + AsientosContablesItemsFiltro.class.getCanonicalName() + ".numeroTo para filtrar la consulta");
		}
	
		if (f.getAsientoContable() == null || f.getAsientoContable().toString().trim().isEmpty()) {
			throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + AsientosContablesItemsFiltro.class.getCanonicalName() + ".asientoContable para filtrar la consulta");
		}


		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";

		if (count == false) {

			atts = "AsientoContableItem.id ";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}

		}

		String sql = "SELECT  " + atts + " FROM massoftware.AsientoContableItem " + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(AsientosContablesItemsFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoContableItem.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoContableItem.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getDetalle() != null && f.getDetalle().trim().isEmpty() == false) {
			String[] words =  f.getDetalle().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(AsientoContableItem.Detalle))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
		}
	
		if (f.getAsientoContable() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoContableItem.AsientoContable = ?";
			this.addArg(buildArgTrim(f.getAsientoContable().getId(), String.class));
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