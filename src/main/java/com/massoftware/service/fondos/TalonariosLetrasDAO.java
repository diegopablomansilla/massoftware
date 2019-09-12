
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class TalonariosLetrasDAO {

	public List<TalonariosLetras> find(ConnectionWrapper connectionWrapper, TalonariosLetrasFiltro f) throws Exception {

		List<TalonariosLetras> r = new ArrayList<TalonariosLetras>();

		TalonariosLetrasStm stm = new TalonariosLetrasStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				TalonariosLetras objRow = new TalonariosLetras();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, TalonariosLetrasFiltro f) throws Exception {

		TalonariosLetrasStm stm = new TalonariosLetrasStm(f, true);

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