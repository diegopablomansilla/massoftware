
package com.massoftware.service.afip;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class TiposDocumentosAFIPDAO {

	public List<TiposDocumentosAFIP> find(ConnectionWrapper connectionWrapper, TiposDocumentosAFIPFiltro f) throws Exception {

		List<TiposDocumentosAFIP> r = new ArrayList<TiposDocumentosAFIP>();

		TiposDocumentosAFIPStm stm = new TiposDocumentosAFIPStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				TiposDocumentosAFIP objRow = new TiposDocumentosAFIP();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNumero((Integer) row[++c]);
				objRow.setNombre((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, TiposDocumentosAFIPFiltro f) throws Exception {

		TiposDocumentosAFIPStm stm = new TiposDocumentosAFIPStm(f, true);

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