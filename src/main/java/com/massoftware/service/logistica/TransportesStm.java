
package com.massoftware.service.logistica;

import org.sorm.stm.StatementParam;

public class TransportesStm extends StatementParam {

	public TransportesStm(TransportesFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ TransportesFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "Transporte.id , Transporte.numero, Transporte.cuit, Transporte.nombre, Transporte.domicilio, CodigoPostal.codigo AS codigoPostal, Ciudad.nombre AS nombreCiudad, Provincia.nombre AS nombreProvincia, Pais.nombre AS nombrePais ";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += "  LEFT JOIN massoftware.CodigoPostal ON CodigoPostal.id = transporte.codigoPostal 	LEFT JOIN massoftware.Ciudad ON Ciudad.id = CodigoPostal.ciudad LEFT JOIN massoftware.Provincia ON Provincia.id = Ciudad.provincia  LEFT JOIN massoftware.Pais ON Pais.id = Provincia.pais";

		String sql = "SELECT  " + atts + " FROM massoftware.Transporte " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(TransportesFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Transporte.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Transporte.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(Transporte.Nombre))" + translate + ") LIKE ?";
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