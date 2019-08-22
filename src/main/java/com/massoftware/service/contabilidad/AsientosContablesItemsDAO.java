
package com.massoftware.service.contabilidad;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class AsientosContablesItemsDAO {

	public List<AsientosContablesItems> find(ConnectionWrapper connectionWrapper, AsientosContablesItemsFiltro f) throws Exception {

		List<AsientosContablesItems> r = new ArrayList<AsientosContablesItems>();

		AsientosContablesItemsStm stm = new AsientosContablesItemsStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				AsientosContablesItems objRow = new AsientosContablesItems();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, AsientosContablesItemsFiltro f) throws Exception {

		AsientosContablesItemsStm stm = new AsientosContablesItemsStm(f, true);

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