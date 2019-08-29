
package com.massoftware.service.empresa;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class TiposSucursalesDAO {

	public List<TiposSucursales> find(ConnectionWrapper connectionWrapper, TiposSucursalesFiltro f) throws Exception {

		List<TiposSucursales> r = new ArrayList<TiposSucursales>();

		TiposSucursalesStm stm = new TiposSucursalesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				TiposSucursales objRow = new TiposSucursales();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNumero((Integer) row[++c]);
				objRow.setNombre((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, TiposSucursalesFiltro f) throws Exception {

		TiposSucursalesStm stm = new TiposSucursalesStm(f, true);

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