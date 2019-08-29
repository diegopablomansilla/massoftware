
package com.massoftware.service.clientes;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class ClasificacionesClientesDAO {

	public List<ClasificacionesClientes> find(ConnectionWrapper connectionWrapper, ClasificacionesClientesFiltro f) throws Exception {

		List<ClasificacionesClientes> r = new ArrayList<ClasificacionesClientes>();

		ClasificacionesClientesStm stm = new ClasificacionesClientesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				ClasificacionesClientes objRow = new ClasificacionesClientes();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNumero((Integer) row[++c]);
				objRow.setNombre((String) row[++c]);
				objRow.setColor((Integer) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, ClasificacionesClientesFiltro f) throws Exception {

		ClasificacionesClientesStm stm = new ClasificacionesClientesStm(f, true);

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