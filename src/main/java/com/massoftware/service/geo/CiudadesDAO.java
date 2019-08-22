
package com.massoftware.service.geo;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class CiudadesDAO {

	public List<Ciudades> find(ConnectionWrapper connectionWrapper, CiudadesFiltro f) throws Exception {

		List<Ciudades> r = new ArrayList<Ciudades>();

		CiudadesStm stm = new CiudadesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				Ciudades objRow = new Ciudades();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, CiudadesFiltro f) throws Exception {

		CiudadesStm stm = new CiudadesStm(f, true);

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