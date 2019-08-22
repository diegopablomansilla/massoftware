
package com.massoftware.service.contabilidad.ventas;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

public class NotasCreditoMotivoDAO {

	public List<NotasCreditoMotivo> find(ConnectionWrapper connectionWrapper, NotasCreditoMotivoFiltro f) throws Exception {

		List<NotasCreditoMotivo> r = new ArrayList<NotasCreditoMotivo>();

		NotasCreditoMotivoStm stm = new NotasCreditoMotivoStm(f, false);

		Object[][] table = connectionWrapper.findToTable(stm.getSql(), stm.getArgs());

		if (table != null && table.length > 0) {

			for (Object[] row : table) {

				NotasCreditoMotivo objRow = new NotasCreditoMotivo();

				int c = -1;

				objRow.setId((String) row[++c]);				
				

				r.add(objRow);

			}
		}

		return r;
	}

	public Integer count(ConnectionWrapper connectionWrapper, NotasCreditoMotivoFiltro f) throws Exception {

		NotasCreditoMotivoStm stm = new NotasCreditoMotivoStm(f, true);

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