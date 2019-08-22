
package com.massoftware.service.contabilidad;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class AsientosModelosDAO {

	public List<AsientosModelos> find(ConnectionWrapper connectionWrapper, AsientosModelosFiltro f) throws Exception {

		List<AsientosModelos> r = new ArrayList<AsientosModelos>();

		AsientosModelosStm stm = new AsientosModelosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				AsientosModelos objRow = new AsientosModelos();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, AsientosModelosFiltro f) throws Exception {

		AsientosModelosStm stm = new AsientosModelosStm(f, true);

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