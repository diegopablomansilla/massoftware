
package com.massoftware.service.afip;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class MonedasAFIPDAO {

	public List<MonedasAFIP> find(ConnectionWrapper connectionWrapper, MonedasAFIPFiltro f) throws Exception {

		List<MonedasAFIP> r = new ArrayList<MonedasAFIP>();

		MonedasAFIPStm stm = new MonedasAFIPStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				MonedasAFIP objRow = new MonedasAFIP();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, MonedasAFIPFiltro f) throws Exception {

		MonedasAFIPStm stm = new MonedasAFIPStm(f, true);

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