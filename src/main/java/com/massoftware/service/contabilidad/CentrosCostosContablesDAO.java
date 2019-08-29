
package com.massoftware.service.contabilidad;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class CentrosCostosContablesDAO {

	public List<CentrosCostosContables> find(ConnectionWrapper connectionWrapper, CentrosCostosContablesFiltro f) throws Exception {

		List<CentrosCostosContables> r = new ArrayList<CentrosCostosContables>();

		CentrosCostosContablesStm stm = new CentrosCostosContablesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				CentrosCostosContables objRow = new CentrosCostosContables();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNombreEjercicioContable((Integer) row[++c]);
				objRow.setNumero((Integer) row[++c]);
				objRow.setAbreviatura((String) row[++c]);
				objRow.setNombre((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, CentrosCostosContablesFiltro f) throws Exception {

		CentrosCostosContablesStm stm = new CentrosCostosContablesStm(f, true);

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