
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class CuentasFondosDAO {

	public List<CuentasFondos> find(ConnectionWrapper connectionWrapper, CuentasFondosFiltro f) throws Exception {

		List<CuentasFondos> r = new ArrayList<CuentasFondos>();

		CuentasFondosStm stm = new CuentasFondosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				CuentasFondos objRow = new CuentasFondos();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, CuentasFondosFiltro f) throws Exception {

		CuentasFondosStm stm = new CuentasFondosStm(f, true);

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