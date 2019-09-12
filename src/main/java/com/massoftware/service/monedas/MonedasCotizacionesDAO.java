
package com.massoftware.service.monedas;

import java.util.ArrayList;
import java.util.List;

import org.dsw.ConnectionWrapper;

public class MonedasCotizacionesDAO {

	public List<MonedasCotizaciones> find(ConnectionWrapper connectionWrapper, MonedasCotizacionesFiltro f) throws Exception {

		List<MonedasCotizaciones> r = new ArrayList<MonedasCotizaciones>();

		MonedasCotizacionesStm stm = new MonedasCotizacionesStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				MonedasCotizaciones objRow = new MonedasCotizaciones();

				int c = -1;

				objRow.setId((String) row[++c]);				
				
				objRow.setCotizacionFecha((java.time.LocalDateTime) row[++c]);
				objRow.setCompra((java.math.BigDecimal) row[++c]);
				objRow.setVenta((java.math.BigDecimal) row[++c]);
				objRow.setMoneda((Moneda) row[++c]);

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, MonedasCotizacionesFiltro f) throws Exception {

		MonedasCotizacionesStm stm = new MonedasCotizacionesStm(f, true);

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