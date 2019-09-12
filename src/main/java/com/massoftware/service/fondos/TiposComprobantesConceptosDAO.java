
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class TiposComprobantesConceptosDAO {

	public List<TiposComprobantesConceptos> find(ConnectionWrapper connectionWrapper, TiposComprobantesConceptosFiltro f) throws Exception {

		List<TiposComprobantesConceptos> r = new ArrayList<TiposComprobantesConceptos>();

		TiposComprobantesConceptosStm stm = new TiposComprobantesConceptosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				TiposComprobantesConceptos objRow = new TiposComprobantesConceptos();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, TiposComprobantesConceptosFiltro f) throws Exception {

		TiposComprobantesConceptosStm stm = new TiposComprobantesConceptosStm(f, true);

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