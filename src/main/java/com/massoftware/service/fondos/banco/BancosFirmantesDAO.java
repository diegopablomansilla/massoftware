
package com.massoftware.service.fondos.banco;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class BancosFirmantesDAO {

	public List<BancosFirmantes> find(ConnectionWrapper connectionWrapper, BancosFirmantesFiltro f) throws Exception {

		List<BancosFirmantes> r = new ArrayList<BancosFirmantes>();

		BancosFirmantesStm stm = new BancosFirmantesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				BancosFirmantes objRow = new BancosFirmantes();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, BancosFirmantesFiltro f) throws Exception {

		BancosFirmantesStm stm = new BancosFirmantesStm(f, true);

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