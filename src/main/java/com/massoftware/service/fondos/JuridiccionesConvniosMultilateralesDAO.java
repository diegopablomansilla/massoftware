
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class JuridiccionesConvniosMultilateralesDAO {

	public List<JuridiccionesConvniosMultilaterales> find(ConnectionWrapper connectionWrapper, JuridiccionesConvniosMultilateralesFiltro f) throws Exception {

		List<JuridiccionesConvniosMultilaterales> r = new ArrayList<JuridiccionesConvniosMultilaterales>();

		JuridiccionesConvniosMultilateralesStm stm = new JuridiccionesConvniosMultilateralesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				JuridiccionesConvniosMultilaterales objRow = new JuridiccionesConvniosMultilaterales();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, JuridiccionesConvniosMultilateralesFiltro f) throws Exception {

		JuridiccionesConvniosMultilateralesStm stm = new JuridiccionesConvniosMultilateralesStm(f, true);

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