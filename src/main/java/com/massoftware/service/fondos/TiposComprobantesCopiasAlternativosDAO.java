
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class TiposComprobantesCopiasAlternativosDAO {

	public List<TiposComprobantesCopiasAlternativos> find(ConnectionWrapper connectionWrapper, TiposComprobantesCopiasAlternativosFiltro f) throws Exception {

		List<TiposComprobantesCopiasAlternativos> r = new ArrayList<TiposComprobantesCopiasAlternativos>();

		TiposComprobantesCopiasAlternativosStm stm = new TiposComprobantesCopiasAlternativosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				TiposComprobantesCopiasAlternativos objRow = new TiposComprobantesCopiasAlternativos();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, TiposComprobantesCopiasAlternativosFiltro f) throws Exception {

		TiposComprobantesCopiasAlternativosStm stm = new TiposComprobantesCopiasAlternativosStm(f, true);

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