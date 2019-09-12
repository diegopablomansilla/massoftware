
package com.massoftware.service.fondos.banco;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class BancosDAO {

	public List<Bancos> find(ConnectionWrapper connectionWrapper, BancosFiltro f) throws Exception {

		List<Bancos> r = new ArrayList<Bancos>();

		BancosStm stm = new BancosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				Bancos objRow = new Bancos();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNumero((Integer) row[++c]);
				objRow.setNombre((String) row[++c]);
				objRow.setCuit((Long) row[++c]);
				objRow.setVigente((Boolean) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, BancosFiltro f) throws Exception {

		BancosStm stm = new BancosStm(f, true);

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