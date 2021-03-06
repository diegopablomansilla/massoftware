
package com.massoftware.service.empresa;

import org.sorm.stm.StatementParam;

public class DepositosStm extends StatementParam {

	public DepositosStm(DepositosFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ DepositosFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "Deposito.id , Deposito.numero, Deposito.abreviatura, Deposito.nombre, Sucursal.nombre AS nombreSucursal, DepositoModulo.nombre AS nombreModulo";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += " LEFT JOIN massoftware.DepositoModulo ON DepositoModulo.id = Deposito.depositoModulo  LEFT JOIN massoftware.Sucursal ON Sucursal.id = Deposito.sucursal";

		String sql = "SELECT  " + atts + " FROM massoftware.Deposito " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(DepositosFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getSucursal() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Deposito.Sucursal = ?";
			this.addArg(buildArgTrim(f.getSucursal().getId(), String.class));
		}
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Deposito.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " Deposito.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(Deposito.Nombre))" + translate + ") LIKE ?";
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