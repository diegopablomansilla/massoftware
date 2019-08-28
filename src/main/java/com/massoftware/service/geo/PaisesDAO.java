
package com.massoftware.service.geo;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class PaisesDAO {

	public List<Paises> find(ConnectionWrapper connectionWrapper, PaisesFiltro f) throws Exception {

		List<Paises> r = new ArrayList<Paises>();

		PaisesStm stm = new PaisesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				Paises objRow = new Paises();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNumero((Integer) row[++c]);
				objRow.setAbreviatura((String) row[++c]);
				objRow.setNombre((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, PaisesFiltro f) throws Exception {

		PaisesStm stm = new PaisesStm(f, true);

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