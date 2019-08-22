
package com.massoftware.service.empresa;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class DepositosDAO {

	public List<Depositos> find(ConnectionWrapper connectionWrapper, DepositosFiltro f) throws Exception {

		List<Depositos> r = new ArrayList<Depositos>();

		DepositosStm stm = new DepositosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				Depositos objRow = new Depositos();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, DepositosFiltro f) throws Exception {

		DepositosStm stm = new DepositosStm(f, true);

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