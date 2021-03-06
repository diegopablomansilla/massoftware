
package com.massoftware.service.clientes;

import org.sorm.stm.StatementParam;

public class MotivosBloqueosClientesStm extends StatementParam {

	public MotivosBloqueosClientesStm(MotivosBloqueosClientesFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ MotivosBloqueosClientesFiltro.class.getCanonicalName());
		}
		
		if(f.getUnlimited() == false) {
			
			
			if (f.getClasificacionCliente() == null || f.getClasificacionCliente().toString().trim().isEmpty()) {
				throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo " + MotivosBloqueosClientesFiltro.class.getCanonicalName() + ".clasificacionCliente para filtrar la consulta");
			}

		}

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";
		String join = "";

		if (count == false) {

			atts = "MotivoBloqueoCliente.id , ClasificacionCliente.nombre AS nombreClasificacionCliente, MotivoBloqueoCliente.numero, MotivoBloqueoCliente.nombre";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}						

		}
		
		join += " LEFT JOIN massoftware.ClasificacionCliente ON ClasificacionCliente.id = MotivoBloqueoCliente.clasificacionCliente";

		String sql = "SELECT  " + atts + " FROM massoftware.MotivoBloqueoCliente " + join + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(MotivosBloqueosClientesFiltro f) {

		String where = "";
		
		//-----------------
		
		
	
		if (f.getClasificacionCliente() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " MotivoBloqueoCliente.ClasificacionCliente = ?";
			this.addArg(buildArgTrim(f.getClasificacionCliente().getId(), String.class));
		}
	
		if (f.getNumeroFrom() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " MotivoBloqueoCliente.Numero >= ?";
			this.addArg(buildArgTrim(f.getNumeroFrom(), Integer.class));
		}
	
		if (f.getNumeroTo() != null) {
			where += (where.trim().length() > 0 ) ? " AND " : "";
			where += " MotivoBloqueoCliente.Numero <= ?";
			this.addArg(buildArgTrim(f.getNumeroTo(), Integer.class));
		}
	
		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			String[] words =  f.getNombre().trim().split(" ");
			for(String word : words) {
				where += (where.trim().length() > 0 ) ? " AND " : "";
				where += " TRANSLATE(LOWER(TRIM(MotivoBloqueoCliente.Nombre))" + translate + ") LIKE ?";
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