
package com.massoftware.service.empresa;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class DepositosModulosDAO {

	public List<DepositosModulos> find(ConnectionWrapper connectionWrapper, DepositosModulosFiltro f) throws Exception {

		List<DepositosModulos> r = new ArrayList<DepositosModulos>();

		DepositosModulosStm stm = new DepositosModulosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				DepositosModulos objRow = new DepositosModulos();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNumero((Integer) row[++c]);
				objRow.setNombre((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, DepositosModulosFiltro f) throws Exception {

		DepositosModulosStm stm = new DepositosModulosStm(f, true);

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