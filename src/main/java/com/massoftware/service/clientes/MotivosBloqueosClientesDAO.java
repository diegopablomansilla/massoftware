
package com.massoftware.service.clientes;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class MotivosBloqueosClientesDAO {

	public List<MotivosBloqueosClientes> find(ConnectionWrapper connectionWrapper, MotivosBloqueosClientesFiltro f) throws Exception {

		List<MotivosBloqueosClientes> r = new ArrayList<MotivosBloqueosClientes>();

		MotivosBloqueosClientesStm stm = new MotivosBloqueosClientesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				MotivosBloqueosClientes objRow = new MotivosBloqueosClientes();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, MotivosBloqueosClientesFiltro f) throws Exception {

		MotivosBloqueosClientesStm stm = new MotivosBloqueosClientesStm(f, true);

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