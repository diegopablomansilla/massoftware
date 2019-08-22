
package com.massoftware.service.geo;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class ProvinciasDAO {

	public List<Provincias> find(ConnectionWrapper connectionWrapper, ProvinciasFiltro f) throws Exception {

		List<Provincias> r = new ArrayList<Provincias>();

		ProvinciasStm stm = new ProvinciasStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				Provincias objRow = new Provincias();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, ProvinciasFiltro f) throws Exception {

		ProvinciasStm stm = new ProvinciasStm(f, true);

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