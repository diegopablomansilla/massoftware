
package com.massoftware.service.contabilidad;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class MinutasContablesDAO {

	public List<MinutasContables> find(ConnectionWrapper connectionWrapper, MinutasContablesFiltro f) throws Exception {

		List<MinutasContables> r = new ArrayList<MinutasContables>();

		MinutasContablesStm stm = new MinutasContablesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				MinutasContables objRow = new MinutasContables();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, MinutasContablesFiltro f) throws Exception {

		MinutasContablesStm stm = new MinutasContablesStm(f, true);

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