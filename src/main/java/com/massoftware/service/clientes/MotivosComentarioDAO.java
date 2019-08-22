
package com.massoftware.service.clientes;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class MotivosComentarioDAO {

	public List<MotivosComentario> find(ConnectionWrapper connectionWrapper, MotivosComentarioFiltro f) throws Exception {

		List<MotivosComentario> r = new ArrayList<MotivosComentario>();

		MotivosComentarioStm stm = new MotivosComentarioStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				MotivosComentario objRow = new MotivosComentario();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, MotivosComentarioFiltro f) throws Exception {

		MotivosComentarioStm stm = new MotivosComentarioStm(f, true);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table.length == 1) {

			Object[] row = table[0];

			return (Integer) row[0];

		} else {

			throw new IllegalStateException(
					"No se esperaba que la consulta a la base de datos devuelva " + table.length + " filas.");

		}

	}

}