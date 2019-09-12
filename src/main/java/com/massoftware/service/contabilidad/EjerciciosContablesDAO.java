
package com.massoftware.service.contabilidad;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class EjerciciosContablesDAO {

	public List<EjerciciosContables> find(ConnectionWrapper connectionWrapper, EjerciciosContablesFiltro f) throws Exception {

		List<EjerciciosContables> r = new ArrayList<EjerciciosContables>();

		EjerciciosContablesStm stm = new EjerciciosContablesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				EjerciciosContables objRow = new EjerciciosContables();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNumero((Integer) row[++c]);
				objRow.setApertura(((java.sql.Date) row[++c]).toLocalDate());
				objRow.setCierre(((java.sql.Date) row[++c]).toLocalDate());
				objRow.setCerrado((Boolean) row[++c]);
				objRow.setCerradoModulos((Boolean) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, EjerciciosContablesFiltro f) throws Exception {

		EjerciciosContablesStm stm = new EjerciciosContablesStm(f, true);

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