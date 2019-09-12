
package com.massoftware.service.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class SeguridadModulosDAO {

	public List<SeguridadModulos> find(ConnectionWrapper connectionWrapper, SeguridadModulosFiltro f) throws Exception {

		List<SeguridadModulos> r = new ArrayList<SeguridadModulos>();

		SeguridadModulosStm stm = new SeguridadModulosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				SeguridadModulos objRow = new SeguridadModulos();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNumero((Integer) row[++c]);
				objRow.setNombre((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, SeguridadModulosFiltro f) throws Exception {

		SeguridadModulosStm stm = new SeguridadModulosStm(f, true);

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