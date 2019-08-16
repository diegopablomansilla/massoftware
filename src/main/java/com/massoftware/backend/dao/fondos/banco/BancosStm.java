package com.massoftware.backend.dao.fondos.banco;

import org.sorm.stm.StatementParam;

import com.massoftware.service.fondos.banco.BancosFiltro;

public class BancosStm extends StatementParam {

	public BancosStm(BancosFiltro f, boolean count) {
		super();

		if (f == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un bojeto para filtrar la consulta. Se esperaba "
					+ BancosFiltro.class.getCanonicalName());
		}

		// if (f.getName() == null || f.getName().trim().isEmpty()) {
		// throw new IllegalArgumentException("QUERY: Se esperaba un valor para el campo
		// "
		// + ContinentsFilter.class.getCanonicalName() + ".name para filtrar la
		// consulta");
		// }

		String atts = " COUNT(*)::INTEGER ";
		String orderBy = "";
		String page = "";

		if (count == false) {

			atts = "banco.id, banco.numero, banco.nombre, banco.cuit, banco.bloqueado";

			orderBy = " ORDER BY " + f.getOrderBy() + " " + (f.getOrderByDesc() ? "DESC" : "");

			if (f.getUnlimited() == false) {
				page = " LIMIT " + f.getLimit() + " OFFSET " + f.getOffset();
			}

		}

		String sql = "SELECT  " + atts + " FROM massoftware.banco " + buildWhere(f) + orderBy + page;

		this.setSql(sql);

	}

	private String buildWhere(BancosFiltro f) {

		String where = "";
		
		//-----------------
		
		if (f.getNumeroFrom() != null) {
			where += " banco.numero >= ?";
			this.addArg(buildArgTrimLower(f.getNumeroFrom(), Integer.class));
		}
		
		if (f.getNumeroTo() != null) {
			where += " banco.numero <= ?";
			this.addArg(buildArgTrimLower(f.getNumeroTo(), Integer.class));
		}

		if (f.getNombre() != null && f.getNombre().trim().isEmpty() == false) {
			where += " TRANSLATE(LOWER(TRIM(banco.nombre))" + translate + ") LIKE ?";
			this.addArg(buildArgTrimLower(f.getNombre(), String.class));
		}
		
		if (f.getBloqueado() != null) {
			where += " banco.bloqueado = ?";
			this.addArg(buildArgTrimLower(f.getBloqueado(), Boolean.class));
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
