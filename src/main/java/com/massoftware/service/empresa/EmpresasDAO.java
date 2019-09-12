
package com.massoftware.service.empresa;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class EmpresasDAO {

	public List<Empresas> find(ConnectionWrapper connectionWrapper, EmpresasFiltro f) throws Exception {

		List<Empresas> r = new ArrayList<Empresas>();

		EmpresasStm stm = new EmpresasStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				Empresas objRow = new Empresas();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, EmpresasFiltro f) throws Exception {

		EmpresasStm stm = new EmpresasStm(f, true);

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