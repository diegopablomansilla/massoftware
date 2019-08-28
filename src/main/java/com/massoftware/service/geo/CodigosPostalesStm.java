
package com.massoftware.service.geo;

import org.sorm.stm.StatementParam;

public class CodigosPostalesStm extends StatementParam {

	public CodigosPostalesStm(CodigosPostalesFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ CodigosPostalesFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			
			
			if (f.getPais() == null || f.getPais().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + CodigosPostalesFiltro.class.getCanonicalName() + ".pais para filtrar la consulta");
			}
			
			if (f.getProvincia() == null || f.getProvincia().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + CodigosPostalesFiltro.class.getCanonicalName() + ".provincia para filtrar la consulta");
			}
			
			if (f.getCiudad() == null || f.getCiudad().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + CodigosPostalesFiltro.class.getCanonicalName() + ".ciudad para filtrar la consulta");
			}

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "CodigoPostal.id , Pais.nombre AS nombrePais, Provincia.nombre AS nombreProvincia, Ciudad.nombre AS nombreCiudad, CodigoPostal.codigo, CodigoPostal.numero, CodigoPostal.numeroCalle, CodigoPostal.nombreCalle";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += " LEFT JOIN massoftware.Ciudad ON Ciudad.id = CodigoPostal.ciudad LEFT JOIN massoftware.Provincia ON Provincia.id = Ciudad.provincia  LEFT JOIN massoftware.Pais ON Pais.id = Provincia.pais";

		String sql = "SELECT  " + atts + " FROM massoftware.CodigoPostal " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(CodigosPostalesFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getPais() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Provincia.Pais = ?";
			this.addArg(buildArgTrim(f.getPais().getId(), String.class));
		}
	
		if (f.getProvincia() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Ciudad.Provincia = ?";
			this.addArg(buildArgTrim(f.getProvincia().getId(), String.class));
		}
	
		if (f.getCiudad() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CodigoPostal.Ciudad = ?";
			this.addArg(buildArgTrim(f.getCiudad().getId(), String.class));
		}
	
		if (f.getCodigo() != null && f.getCodigo().trim().isEmpty() == false) {
			String[] words =  f.getCodigo().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(CodigoPostal.Codigo))" + translate + ") LIKE ?";
				this.addArg(buildArgTrimLower(word.trim(), String.class));
			}
		}
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CodigoPostal.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " CodigoPostal.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getNombreCalle() != null && f.getNombreCalle().trim().isEmpty() == false) {
			String[] words =  f.getNombreCalle().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(CodigoPostal.NombreCalle))" + translate + ") LIKE ?";
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