
package com.massoftware.service.logistica;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class TransportesTarifasDAO {

	public List<TransportesTarifas> find(ConnectionWrapper connectionWrapper, TransportesTarifasFiltro f) throws Exception {

		List<TransportesTarifas> r = new ArrayList<TransportesTarifas>();

		TransportesTarifasStm stm = new TransportesTarifasStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				TransportesTarifas objRow = new TransportesTarifas();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, TransportesTarifasFiltro f) throws Exception {

		TransportesTarifasStm stm = new TransportesTarifasStm(f, true);

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