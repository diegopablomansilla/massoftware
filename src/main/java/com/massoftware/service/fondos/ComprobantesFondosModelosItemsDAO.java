
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class ComprobantesFondosModelosItemsDAO {

	public List<ComprobantesFondosModelosItems> find(ConnectionWrapper connectionWrapper, ComprobantesFondosModelosItemsFiltro f) throws Exception {

		List<ComprobantesFondosModelosItems> r = new ArrayList<ComprobantesFondosModelosItems>();

		ComprobantesFondosModelosItemsStm stm = new ComprobantesFondosModelosItemsStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				ComprobantesFondosModelosItems objRow = new ComprobantesFondosModelosItems();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, ComprobantesFondosModelosItemsFiltro f) throws Exception {

		ComprobantesFondosModelosItemsStm stm = new ComprobantesFondosModelosItemsStm(f, true);

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