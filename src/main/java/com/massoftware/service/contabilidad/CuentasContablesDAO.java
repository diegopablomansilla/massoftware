
package com.massoftware.service.contabilidad;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class CuentasContablesDAO {

	public List<CuentasContables> find(ConnectionWrapper connectionWrapper, CuentasContablesFiltro f) throws Exception {

		List<CuentasContables> r = new ArrayList<CuentasContables>();

		CuentasContablesStm stm = new CuentasContablesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				CuentasContables objRow = new CuentasContables();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNombreEjercicioContable((Integer) row[++c]);
				objRow.setCodigo((String) row[++c]);
				objRow.setNombre((String) row[++c]);
				objRow.setNombreCentroCostoContable((String) row[++c]);
				objRow.setCuentaAgrupadora((String) row[++c]);
				objRow.setPorcentaje((Double) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, CuentasContablesFiltro f) throws Exception {

		CuentasContablesStm stm = new CuentasContablesStm(f, true);

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