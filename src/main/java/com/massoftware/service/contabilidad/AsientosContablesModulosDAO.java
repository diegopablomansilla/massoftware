
package com.massoftware.service.contabilidad;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class AsientosContablesModulosDAO {

	public List<AsientosContablesModulos> find(ConnectionWrapper connectionWrapper, AsientosContablesModulosFiltro f) throws Exception {

		List<AsientosContablesModulos> r = new ArrayList<AsientosContablesModulos>();

		AsientosContablesModulosStm stm = new AsientosContablesModulosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				AsientosContablesModulos objRow = new AsientosContablesModulos();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, AsientosContablesModulosFiltro f) throws Exception {

		AsientosContablesModulosStm stm = new AsientosContablesModulosStm(f, true);

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