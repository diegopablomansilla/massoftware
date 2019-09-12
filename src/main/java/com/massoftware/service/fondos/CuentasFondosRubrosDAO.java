
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class CuentasFondosRubrosDAO {

	public List<CuentasFondosRubros> find(ConnectionWrapper connectionWrapper, CuentasFondosRubrosFiltro f) throws Exception {

		List<CuentasFondosRubros> r = new ArrayList<CuentasFondosRubros>();

		CuentasFondosRubrosStm stm = new CuentasFondosRubrosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				CuentasFondosRubros objRow = new CuentasFondosRubros();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, CuentasFondosRubrosFiltro f) throws Exception {

		CuentasFondosRubrosStm stm = new CuentasFondosRubrosStm(f, true);

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