package com.massoftware.backend.dao.fondos.banco;

import java.util.ArrayList;
import java.util.List;

import org.dsw.jdbc.ConnectionWrapper;

import com.massoftware.service.fondos.banco.Bancos;
import com.massoftware.service.fondos.banco.BancosFiltro;
import com.massoftware.service.fondos.banco.XBancosStm;

public class BancosDAO {

	public List<Bancos> find(ConnectionWrapper connectionWrapper, BancosFiltro f) throws Exception {

		List<Bancos> r = new ArrayList<Bancos>();

		XBancosStm stm = new XBancosStm(f, false);

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

		XBancosStm stm = new XBancosStm(f, true);

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
