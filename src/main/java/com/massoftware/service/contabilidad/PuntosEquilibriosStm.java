
package com.massoftware.service.contabilidad;

import org.sorm.stm.StatementParam;

public class PuntosEquilibriosStm extends StatementParam {

	public PuntosEquilibriosStm(PuntosEquilibriosFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ PuntosEquilibriosFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			
			
			if (f.getEjercicioContable() == null || f.getEjercicioContable().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + PuntosEquilibriosFiltro.class.getCanonicalName() + ".ejercicioContable para filtrar la consulta");
			}

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "PuntoEquilibrio.id , EjercicioContable.numero AS nombreEjercicioContable, PuntoEquilibrio.numero, PuntoEquilibrio.nombre, TipoPuntoEquilibrio.nombre AS nombreTipoPuntoEquilibrio";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += " LEFT JOIN massoftware.EjercicioContable ON EjercicioContable.id = PuntoEquilibrio.ejercicioContable LEFT JOIN massoftware.TipoPuntoEquilibrio ON TipoPuntoEquilibrio.id = PuntoEquilibrio.tipoPuntoEquilibrio";

		String sql = "SELECT  " + atts + " FROM massoftware.PuntoEquilibrio " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(PuntosEquilibriosFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getEjercicioContable() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " PuntoEquilibrio.EjercicioContable = ?";
			this.addArg(buildArgTrim(f.getEjercicioContable().getId(), String.class));
		}
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " PuntoEquilibrio.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " PuntoEquilibrio.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(PuntoEquilibrio.Nombre))" + translate + ") LIKE ?";
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