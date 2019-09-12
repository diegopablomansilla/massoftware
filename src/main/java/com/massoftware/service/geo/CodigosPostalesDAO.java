
package com.massoftware.service.geo;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class CodigosPostalesDAO {

	public List<CodigosPostales> find(ConnectionWrapper connectionWrapper, CodigosPostalesFiltro f) throws Exception {

		List<CodigosPostales> r = new ArrayList<CodigosPostales>();

		CodigosPostalesStm stm = new CodigosPostalesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				CodigosPostales objRow = new CodigosPostales();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNombrePais((String) row[++c]);
				objRow.setNombreProvincia((String) row[++c]);
				objRow.setNombreCiudad((String) row[++c]);
				objRow.setCodigo((String) row[++c]);
				objRow.setNumero((Integer) row[++c]);
				objRow.setNumeroCalle((String) row[++c]);
				objRow.setNombreCalle((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, CodigosPostalesFiltro f) throws Exception {

		CodigosPostalesStm stm = new CodigosPostalesStm(f, true);

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