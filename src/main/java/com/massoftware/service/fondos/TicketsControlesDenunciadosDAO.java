
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class TicketsControlesDenunciadosDAO {

	public List<TicketsControlesDenunciados> find(ConnectionWrapper connectionWrapper, TicketsControlesDenunciadosFiltro f) throws Exception {

		List<TicketsControlesDenunciados> r = new ArrayList<TicketsControlesDenunciados>();

		TicketsControlesDenunciadosStm stm = new TicketsControlesDenunciadosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				TicketsControlesDenunciados objRow = new TicketsControlesDenunciados();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, TicketsControlesDenunciadosFiltro f) throws Exception {

		TicketsControlesDenunciadosStm stm = new TicketsControlesDenunciadosStm(f, true);

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