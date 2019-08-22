
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class TalonariosControladoresFizcalesDAO {

	public List<TalonariosControladoresFizcales> find(ConnectionWrapper connectionWrapper, TalonariosControladoresFizcalesFiltro f) throws Exception {

		List<TalonariosControladoresFizcales> r = new ArrayList<TalonariosControladoresFizcales>();

		TalonariosControladoresFizcalesStm stm = new TalonariosControladoresFizcalesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				TalonariosControladoresFizcales objRow = new TalonariosControladoresFizcales();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, TalonariosControladoresFizcalesFiltro f) throws Exception {

		TalonariosControladoresFizcalesStm stm = new TalonariosControladoresFizcalesStm(f, true);

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