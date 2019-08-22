
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import com.massoftware.service.BackendContextPG;
import com.massoftware.service.DataBase;

public class CuentaFondoRubroService {

	// ---------------------------------------------------------------------------------------------------------------------------

	public CuentaFondoRubro insert(CuentaFondoRubro obj) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("Se esperaba un objeto " + CuentaFondoRubro.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.insertObject(obj);
			if (b == false) {
				throw new IllegalStateException("No se pudo guardar el " + CuentaFondoRubro.class.getCanonicalName() + " " + obj);
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

	public CuentaFondoRubro update(CuentaFondoRubro obj) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("Se esperaba un objeto " + CuentaFondoRubro.class.getCanonicalName() + " no nulo.");
		}
		if (obj.getId() == null || obj.getId().trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un objeto " + CuentaFondoRubro.class.getCanonicalName() + " con id no nulo/vacio.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.updateObject(obj);
			if (b == false) {
				throw new IllegalStateException("No se pudo guardar el " + CuentaFondoRubro.class.getCanonicalName() + " " + obj);
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
			throw new IllegalArgumentException("Se esperaba un id (" + CuentaFondoRubro.class.getCanonicalName() + ".id) no nulo/vacio.");
		}

		id = id.trim();

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.deleteObjectById(id, CuentaFondoRubro.class);
			if (b == false) {
				throw new IllegalStateException("No se pudo borrar el " + CuentaFondoRubro.class.getCanonicalName() + " " + id);
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

	public CuentaFondoRubro findById(String id) throws Exception {

		if (id == null || id.trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un id (" + CuentaFondoRubro.class.getCanonicalName() + ".id) no nulo/vacio.");
		}

		id = id.trim();

		DataBase db = BackendContextPG.get().getDataBase();

		CuentaFondoRubro obj = null;

		try {

			db.begint();

			obj = (CuentaFondoRubro) db.fillObjectById(id, CuentaFondoRubro.class, 4);
			if (obj == null) {
				throw new IllegalStateException("No se pudo encontrar el " + CuentaFondoRubro.class.getCanonicalName() + " con id " + obj);				
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

	public Long count() throws Exception {				

		DataBase db = BackendContextPG.get().getDataBase();

		Long count = 0L;

		try {

			db.begint();

			count = db.countAllObjects(CuentaFondoRubro.class);

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

	public List<CuentasFondosRubros> find(CuentasFondosRubrosFiltro f) throws Exception {

		if (f == null) {
			throw new IllegalArgumentException(
					"Se esperaba un objeto " + CuentasFondosRubrosFiltro.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		List<CuentasFondosRubros> listado = null;

		try {

			db.begint();

			listado = db.findCuentasFondosRubros(f);

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		if (listado == null) {
			listado = new ArrayList<CuentasFondosRubros>();
		}

		return listado;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer count(CuentasFondosRubrosFiltro f) throws Exception {
		
		if (f == null) {
			throw new IllegalArgumentException(
					"Se esperaba un objeto " + CuentasFondosRubrosFiltro.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		Integer count = 0;

		try {

			db.begint();

			count = db.countCuentasFondosRubros(f);

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



} // END CLASS