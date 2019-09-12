
package com.massoftware.service.contabilidad;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class CuentasContablesEstadosDAO {

	public List<CuentasContablesEstados> find(ConnectionWrapper connectionWrapper, CuentasContablesEstadosFiltro f) throws Exception {

		List<CuentasContablesEstados> r = new ArrayList<CuentasContablesEstados>();

		CuentasContablesEstadosStm stm = new CuentasContablesEstadosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				CuentasContablesEstados objRow = new CuentasContablesEstados();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNumero((Integer) row[++c]);
				objRow.setNombre((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, CuentasContablesEstadosFiltro f) throws Exception {

		CuentasContablesEstadosStm stm = new CuentasContablesEstadosStm(f, true);

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