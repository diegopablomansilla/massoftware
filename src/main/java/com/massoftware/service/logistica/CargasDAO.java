
package com.massoftware.service.logistica;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class CargasDAO {

	public List<Cargas> find(ConnectionWrapper connectionWrapper, CargasFiltro f) throws Exception {

		List<Cargas> r = new ArrayList<Cargas>();

		CargasStm stm = new CargasStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				Cargas objRow = new Cargas();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNombreTransporte((String) row[++c]);
				objRow.setNumero((Integer) row[++c]);
				objRow.setNombre((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, CargasFiltro f) throws Exception {

		CargasStm stm = new CargasStm(f, true);

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