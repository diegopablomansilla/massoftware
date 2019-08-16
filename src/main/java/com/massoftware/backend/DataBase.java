package com.massoftware.backend;

import java.util.List;

import org.dsw.jdbc.DataSourceWrapper;
import org.sorm.pg.DataBasePG;

import com.massoftware.backend.dao.fondos.banco.BancosDAO;
import com.massoftware.service.fondos.banco.Bancos;
import com.massoftware.service.fondos.banco.BancosFiltro;

public class DataBase extends DataBasePG {

	private BancosDAO bancosDAO;

	public DataBase(DataSourceWrapper dataSourceWrapper, String schema) {
		super(dataSourceWrapper, schema);
		bancosDAO = new BancosDAO();
	}

	public List<Bancos> findBancos(BancosFiltro f) throws Exception {
		return bancosDAO.find(connectionWrapper, f);
	}

	public Integer countBancos(BancosFiltro f) throws Exception {
		return bancosDAO.count(connectionWrapper, f);
	}

}
