
package com.massoftware.service.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class UsuariosDAO {

	public List<Usuarios> find(ConnectionWrapper connectionWrapper, UsuariosFiltro f) throws Exception {

		List<Usuarios> r = new ArrayList<Usuarios>();

		UsuariosStm stm = new UsuariosStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				Usuarios objRow = new Usuarios();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNumero((Integer) row[++c]);
				objRow.setNombre((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, UsuariosFiltro f) throws Exception {

		UsuariosStm stm = new UsuariosStm(f, true);

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