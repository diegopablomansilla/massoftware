
package com.massoftware.service.empresa;

import org.sorm.stm.StatementParam;

public class SucursalesStm extends StatementParam {

	public SucursalesStm(SucursalesFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ SucursalesFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "Sucursal.id , TipoSucursal.nombre AS nombreTiposucursal, Sucursal.numero, Sucursal.abreviatura, Sucursal.nombre";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += " LEFT JOIN massoftware.TipoSucursal ON TipoSucursal.id = Sucursal.tipoSucursal";

		String sql = "SELECT  " + atts + " FROM massoftware.Sucursal " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(SucursalesFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getTipoSucursal() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Sucursal.TipoSucursal = ?";
			this.addArg(buildArgTrim(f.getTipoSucursal().getId(), String.class));
		}
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Sucursal.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Sucursal.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getAbreviatura() != null && f.getAbreviatura().trim().isEmpty() == false) {
			String[] words =  f.getAbreviatura().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(Sucursal.Abreviatura))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(Sucursal.Nombre))" + translate + ") LIKE ?";
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