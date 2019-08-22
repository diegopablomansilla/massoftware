
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class TicketsModelosDAO {

	public List<TicketsModelos> find(ConnectionWrapper connectionWrapper, TicketsModelosFiltro f) throws Exception {

		List<TicketsModelos> r = new ArrayList<TicketsModelos>();

		TicketsModelosStm stm = new TicketsModelosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				TicketsModelos objRow = new TicketsModelos();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, TicketsModelosFiltro f) throws Exception {

		TicketsModelosStm stm = new TicketsModelosStm(f, true);

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