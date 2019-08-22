package com.massoftware.service;

import java.util.List;

import org.dsw.jdbc.DataSourceWrapper;
import org.sorm.pg.DataBasePG;

import com.massoftware.service.fondos.banco.Bancos;
import com.massoftware.service.fondos.banco.BancosFiltro;
import com.massoftware.service.fondos.banco.XBancosDAO;

public class DataBaseX extends DataBasePG {

	private XBancosDAO bancosDAO;

	public DataBaseX(DataSourceWrapper dataSourceWrapper, String schema) {
		super(dataSourceWrapper, schema);
		bancosDAO = new XBancosDAO();
	}

	public List<Bancos> findBancos(BancosFiltro f) throws Exception {
		return bancosDAO.find(connectionWrapper, f);
	}

	public Integer countBancos(BancosFiltro f) throws Exception {
		return bancosDAO.count(connectionWrapper, f);
	}

}
