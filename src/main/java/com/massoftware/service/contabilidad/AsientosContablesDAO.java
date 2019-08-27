
package com.massoftware.service.contabilidad;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class AsientosContablesDAO {

	public List<AsientosContables> find(ConnectionWrapper connectionWrapper, AsientosContablesFiltro f) throws Exception {

		List<AsientosContables> r = new ArrayList<AsientosContables>();

		AsientosContablesStm stm = new AsientosContablesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				AsientosContables objRow = new AsientosContables();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNumeroEjercicio((Integer) row[++c]);
				objRow.setNumero((Integer) row[++c]);
				objRow.setFecha(((java.sql.Date) row[++c]).toLocalDate());
				objRow.setDetalle((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, AsientosContablesFiltro f) throws Exception {

		AsientosContablesStm stm = new AsientosContablesStm(f, true);

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