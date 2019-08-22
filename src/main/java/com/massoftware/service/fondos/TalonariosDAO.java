
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class TalonariosDAO {

	public List<Talonarios> find(ConnectionWrapper connectionWrapper, TalonariosFiltro f) throws Exception {

		List<Talonarios> r = new ArrayList<Talonarios>();

		TalonariosStm stm = new TalonariosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				Talonarios objRow = new Talonarios();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, TalonariosFiltro f) throws Exception {

		TalonariosStm stm = new TalonariosStm(f, true);

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