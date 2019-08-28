
package com.massoftware.service.logistica;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class TransportesDAO {

	public List<Transportes> find(ConnectionWrapper connectionWrapper, TransportesFiltro f) throws Exception {

		List<Transportes> r = new ArrayList<Transportes>();

		TransportesStm stm = new TransportesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				Transportes objRow = new Transportes();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setNumero((Integer) row[++c]);
				objRow.setCuit((Long) row[++c]);
				objRow.setNombre((String) row[++c]);
				objRow.setDomicilio((String) row[++c]);
				objRow.setCodigoPostal((String) row[++c]);
				objRow.setNombreCiudad((String) row[++c]);
				objRow.setNombreProvincia((String) row[++c]);
				objRow.setNombrePais((String) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, TransportesFiltro f) throws Exception {

		TransportesStm stm = new TransportesStm(f, true);

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