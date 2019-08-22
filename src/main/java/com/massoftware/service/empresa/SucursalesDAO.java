
package com.massoftware.service.empresa;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class SucursalesDAO {

	public List<Sucursales> find(ConnectionWrapper connectionWrapper, SucursalesFiltro f) throws Exception {

		List<Sucursales> r = new ArrayList<Sucursales>();

		SucursalesStm stm = new SucursalesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				Sucursales objRow = new Sucursales();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, SucursalesFiltro f) throws Exception {

		SucursalesStm stm = new SucursalesStm(f, true);

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