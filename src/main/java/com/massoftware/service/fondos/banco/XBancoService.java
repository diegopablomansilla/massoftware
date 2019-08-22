package com.massoftware.service.fondos.banco;

import java.util.ArrayList;
import java.util.List;

import com.massoftware.service.BackendContextPG;
import com.massoftware.service.DataBase;

public class XBancoService {

	// ---------------------------------------------------------------------------------------------------------------------------

	public Banco insert(Banco obj) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("Se esperaba un objeto " + Banco.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.insertObject(obj);
			if (b == false) {
				throw new IllegalStateException("No se pudo guardar el " + Banco.class.getCanonicalName() + " " + obj);
			}

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		return obj;

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Banco update(Banco obj) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("Se esperaba un objeto " + Banco.class.getCanonicalName() + " no nulo.");
		}
		if (obj.getId() == null || obj.getId().trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un objeto " + Banco.class.getCanonicalName() + " con id no nulo/vacio.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.updateObject(obj);
			if (b == false) {
				throw new IllegalStateException("No se pudo guardar el " + Banco.class.getCanonicalName() + " " + obj);
			}

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		return obj;

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean deleteById(String id) throws Exception {

		if (id == null || id.trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un id (" + Banco.class.getCanonicalName() + ".id) no nulo/vacio.");
		}

		id = id.trim();

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.deleteObjectById(id, Banco.class);
			if (b == false) {
				throw new IllegalStateException("No se pudo borrar el " + Banco.class.getCanonicalName() + " " + id);
			}

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		return true;

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Banco findById(String id) throws Exception {

		if (id == null || id.trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un id (" + Banco.class.getCanonicalName() + ".id) no nulo/vacio.");
		}

		id = id.trim();

		DataBase db = BackendContextPG.get().getDataBase();

		Banco obj = null;

		try {

			db.begint();

			obj = (Banco) db.fillObjectById(id, Banco.class, 4);
			if (obj == null) {
				throw new IllegalStateException("No se pudo encontrar el " + Banco.class.getCanonicalName() + " con id " + obj);				
			}

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		return obj;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public List<Bancos> find(BancosFiltro f) throws Exception {

		if (f == null) {
			throw new IllegalArgumentException(
					"Se esperaba un objeto " + BancosFiltro.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		List<Bancos> listado = null;

		try {

			db.begint();

			listado = db.findBancos(f);

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		if (listado == null) {
			listado = new ArrayList<Bancos>();
		}

		return listado;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer count(BancosFiltro f) throws Exception {
		
		if (f == null) {
			throw new IllegalArgumentException(
					"Se esperaba un objeto " + BancosFiltro.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		Integer count = 0;

		try {

			db.begint();

			count = db.countBancos(f);

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		return count;

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public boolean isExistsNumero(Integer arg) throws Exception {

		if (arg == null || arg.toString().trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un arg (Banco.numero) no nulo/vacio.");
		}

		String sql = "SELECT * FROM massoftware.f_exists_Banco_numero(?)";

		Object[] args = new Object[] { arg };

		Object[][] table = BackendContextPG.get().find(sql, args);

		if (table.length == 1) {

			Object[] row = table[0];

			if (row.length == 1) {

				return (Boolean) row[0];

			} else {
				throw new IllegalStateException(
						"No se esperaba que la consulta a la base de datos devuelva " + row.length + " columnas.");
			}

		} else {
			throw new IllegalStateException(
					"No se esperaba que la consulta a la base de datos devuelva " + table.length + " filas.");
		}

	}

	public boolean isExistsNombre(String arg) throws Exception {

		if (arg == null || arg.toString().trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un arg (Banco.nombre) no nulo/vacio.");
		}

		arg = arg.trim();

		String sql = "SELECT * FROM massoftware.f_exists_Banco_nombre(?)";

		Object[] args = new Object[] { arg };

		Object[][] table = BackendContextPG.get().find(sql, args);

		if (table.length == 1) {

			Object[] row = table[0];

			if (row.length == 1) {

				return (Boolean) row[0];

			} else {
				throw new IllegalStateException(
						"No se esperaba que la consulta a la base de datos devuelva " + row.length + " columnas.");
			}

		} else {
			throw new IllegalStateException(
					"No se esperaba que la consulta a la base de datos devuelva " + table.length + " filas.");
		}

	}

	public boolean isExistsCuit(Long arg) throws Exception {

		if (arg == null || arg.toString().trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un arg (Banco.cuit) no nulo/vacio.");
		}

		String sql = "SELECT * FROM massoftware.f_exists_Banco_cuit(?)";

		Object[] args = new Object[] { arg };

		Object[][] table = BackendContextPG.get().find(sql, args);

		if (table.length == 1) {

			Object[] row = table[0];

			if (row.length == 1) {

				return (Boolean) row[0];

			} else {
				throw new IllegalStateException(
						"No se esperaba que la consulta a la base de datos devuelva " + row.length + " columnas.");
			}

		} else {
			throw new IllegalStateException(
					"No se esperaba que la consulta a la base de datos devuelva " + table.length + " filas.");
		}

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer nextValueNumero() throws Exception {

		String sql = "SELECT * FROM massoftware.f_next_Banco_numero()";

		Object[] args = new Object[] {};

		Object[][] table = BackendContextPG.get().find(sql, args);

		if (table.length == 1) {

			Object[] row = table[0];

			return (Integer) row[0];

		} else {
			throw new IllegalStateException(
					"No se esperaba que la consulta a la base de datos devuelva " + table.length + " filas.");
		}

	}

	public Long nextValueCuit() throws Exception {

		String sql = "SELECT * FROM massoftware.f_next_Banco_cuit()";

		Object[] args = new Object[] {};

		Object[][] table = BackendContextPG.get().find(sql, args);

		if (table.length == 1) {

			Object[] row = table[0];

			return (Long) row[0];

		} else {
			throw new IllegalStateException(
					"No se esperaba que la consulta a la base de datos devuelva " + table.length + " filas.");
		}

	}

	public Integer nextValueHoja() throws Exception {

		String sql = "SELECT * FROM massoftware.f_next_Banco_hoja()";

		Object[] args = new Object[] {};

		Object[][] table = BackendContextPG.get().find(sql, args);

		if (table.length == 1) {

			Object[] row = table[0];

			return (Integer) row[0];

		} else {
			throw new IllegalStateException(
					"No se esperaba que la consulta a la base de datos devuelva " + table.length + " filas.");
		}

	}

	public Integer nextValuePrimeraFila() throws Exception {

		String sql = "SELECT * FROM massoftware.f_next_Banco_primeraFila()";

		Object[] args = new Object[] {};

		Object[][] table = BackendContextPG.get().find(sql, args);

		if (table.length == 1) {

			Object[] row = table[0];

			return (Integer) row[0];

		} else {
			throw new IllegalStateException(
					"No se esperaba que la consulta a la base de datos devuelva " + table.length + " filas.");
		}

	}

	public Integer nextValueUltimaFila() throws Exception {

		String sql = "SELECT * FROM massoftware.f_next_Banco_ultimaFila()";

		Object[] args = new Object[] {};

		Object[][] table = BackendContextPG.get().find(sql, args);

		if (table.length == 1) {

			Object[] row = table[0];

			return (Integer) row[0];

		} else {
			throw new IllegalStateException(
					"No se esperaba que la consulta a la base de datos devuelva " + table.length + " filas.");
		}

	}

	// ---------------------------------------------------------------------------------------------------------------------------

//	public List<Banco> findByNumeroOrNombre(String arg) throws Exception {
//
//		if (arg == null || arg.trim().length() == 0) {
//
//			throw new IllegalArgumentException("Se esperaba un arg (Banco.numero o Banco.nombre) no nulo/vacio.");
//
//		}
//
//		arg = arg.trim();
//
//		// ------------ buscar por Nº banco
//
//		if (UtilNumeric.isInteger(arg)) {
//
//			BancosFiltro filtroNumero = new BancosFiltro();
//
//			filtroNumero.setUnlimited(true);
//
//			filtroNumero.setNumeroFrom(new Integer(arg));
//
//			filtroNumero.setNumeroTo(new Integer(arg));
//
//			List<Banco> listadoNumero = find(filtroNumero);
//
//			if (listadoNumero.size() > 0) {
//
//				return listadoNumero;
//
//			}
//
//		}
//
//		// ------------ buscar por Nombre
//
//		BancosFiltro filtroNombre = new BancosFiltro();
//
//		filtroNombre.setUnlimited(true);
//
//		filtroNombre.setNombre(arg);
//
//		List<Banco> listadoNombre = find(filtroNombre);
//
//		if (listadoNombre.size() > 0) {
//
//			return listadoNombre;
//
//		}
//
//		return new ArrayList<Banco>();
//
//	}

} // END CLASS
