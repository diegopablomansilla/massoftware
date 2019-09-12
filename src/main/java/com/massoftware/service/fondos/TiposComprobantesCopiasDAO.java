
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class TiposComprobantesCopiasDAO {

	public List<TiposComprobantesCopias> find(ConnectionWrapper connectionWrapper, TiposComprobantesCopiasFiltro f) throws Exception {

		List<TiposComprobantesCopias> r = new ArrayList<TiposComprobantesCopias>();

		TiposComprobantesCopiasStm stm = new TiposComprobantesCopiasStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				TiposComprobantesCopias objRow = new TiposComprobantesCopias();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, TiposComprobantesCopiasFiltro f) throws Exception {

		TiposComprobantesCopiasStm stm = new TiposComprobantesCopiasStm(f, true);

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