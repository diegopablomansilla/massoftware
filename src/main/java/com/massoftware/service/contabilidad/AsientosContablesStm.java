
package com.massoftware.service.contabilidad;

import org.sorm.stm.StatementParam;

public class AsientosContablesStm extends StatementParam {

	public AsientosContablesStm(AsientosContablesFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ AsientosContablesFiltro.class.getCanonicalName());
		}
		
		
	
		if (f.getEjercicioContable() == null || f.getEjercicioContable().toString().trim().isEmpty()) {
			throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + AsientosContablesFiltro.class.getCanonicalName() + ".name para filtrar la consulta");
		}


		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";

		if (count == false) {

			atts = "";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}

		}

		String sql = "SELECT  " + atts + " FROM massoftware.AsientoContable " + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(AsientosContablesFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoContable.Numero >= ?";
			this.addArg(buildArgTrimLower(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoContable.Numero <= ?";
			this.addArg(buildArgTrimLower(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getDetalle() != null && f.getDetalle().trim().isEmpty() == false) {
			String[] words =  f.getDetalle().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(AsientoContable.Detalle))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
	}
	
		if (f.getFechaFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoContable.Fecha >= ?";
			this.addArg(buildArgTrimLower(f.getFechaFrom(), Date.class));
		}
	
		if (f.getFechaTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoContable.Fecha <= ?";
			this.addArg(buildArgTrimLower(f.getFechaTo(), Date.class));
		}
	
		if (f.getEjercicioContable() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoContable.EjercicioContable = ?";
			this.addArg(buildArgTrimLower(f.getEjercicioContable(), java.lang.String.class));
		}
	
		if (f.getMinutaContable() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoContable.MinutaContable = ?";
			this.addArg(buildArgTrimLower(f.getMinutaContable(), java.lang.String.class));
		}
	
		if (f.getAsientoContableModulo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoContable.AsientoContableModulo = ?";
			this.addArg(buildArgTrimLower(f.getAsientoContableModulo(), java.lang.String.class));
		}
	
		if (f.getSucursal() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " AsientoContable.Sucursal = ?";
			this.addArg(buildArgTrimLower(f.getSucursal(), java.lang.String.class));
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