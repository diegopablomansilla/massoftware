
package com.massoftware.service.clientes;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class TiposClientesDAO {

	public List<TiposClientes> find(ConnectionWrapper connectionWrapper, TiposClientesFiltro f) throws Exception {

		List<TiposClientes> r = new ArrayList<TiposClientes>();

		TiposClientesStm stm = new TiposClientesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				TiposClientes objRow = new TiposClientes();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNumero((Integer) row[++c]);
				objRow.setNombre((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, TiposClientesFiltro f) throws Exception {

		TiposClientesStm stm = new TiposClientesStm(f, true);

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