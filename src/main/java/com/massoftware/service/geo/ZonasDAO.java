
package com.massoftware.service.geo;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class ZonasDAO {

	public List<Zonas> find(ConnectionWrapper connectionWrapper, ZonasFiltro f) throws Exception {

		List<Zonas> r = new ArrayList<Zonas>();

		ZonasStm stm = new ZonasStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				Zonas objRow = new Zonas();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setCodigo((String) row[++c]);
				objRow.setNombre((String) row[++c]);
				objRow.setBonificacion((Double) row[++c]);
				objRow.setRecargo((Double) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, ZonasFiltro f) throws Exception {

		ZonasStm stm = new ZonasStm(f, true);

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