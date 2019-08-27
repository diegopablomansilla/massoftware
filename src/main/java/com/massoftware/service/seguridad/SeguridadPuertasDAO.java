
package com.massoftware.service.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class SeguridadPuertasDAO {

	public List<SeguridadPuertas> find(ConnectionWrapper connectionWrapper, SeguridadPuertasFiltro f) throws Exception {

		List<SeguridadPuertas> r = new ArrayList<SeguridadPuertas>();

		SeguridadPuertasStm stm = new SeguridadPuertasStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				SeguridadPuertas objRow = new SeguridadPuertas();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNombreModulo((String) row[++c]);
				objRow.setNumero((Integer) row[++c]);
				objRow.setNombre((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, SeguridadPuertasFiltro f) throws Exception {

		SeguridadPuertasStm stm = new SeguridadPuertasStm(f, true);

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