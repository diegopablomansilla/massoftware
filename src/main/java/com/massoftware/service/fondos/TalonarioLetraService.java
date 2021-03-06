
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import com.massoftware.service.BackendContextPG;
import com.massoftware.service.DataBase;

public class TalonarioLetraService {

	// ---------------------------------------------------------------------------------------------------------------------------

	public TalonarioLetra insert(TalonarioLetra obj) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("Se esperaba un objeto " + TalonarioLetra.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.insertObject(obj);
			if (b == false) {
				throw new IllegalStateException("No se pudo guardar el " + TalonarioLetra.class.getCanonicalName() + " " + obj);
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

	public TalonarioLetra update(TalonarioLetra obj) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("Se esperaba un objeto " + TalonarioLetra.class.getCanonicalName() + " no nulo.");
		}
		if (obj.getId() == null || obj.getId().trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un objeto " + TalonarioLetra.class.getCanonicalName() + " con id no nulo/vacio.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.updateObject(obj);
			if (b == false) {
				throw new IllegalStateException("No se pudo guardar el " + TalonarioLetra.class.getCanonicalName() + " " + obj);
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
			throw new IllegalArgumentException("Se esperaba un id (" + TalonarioLetra.class.getCanonicalName() + ".id) no nulo/vacio.");
		}

		id = id.trim();

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.deleteObjectById(id, TalonarioLetra.class);
			if (b == false) {
				throw new IllegalStateException("No se pudo borrar el " + TalonarioLetra.class.getCanonicalName() + " " + id);
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

	public TalonarioLetra findById(String id) throws Exception {

		if (id == null || id.trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un id (" + TalonarioLetra.class.getCanonicalName() + ".id) no nulo/vacio.");
		}

		id = id.trim();

		DataBase db = BackendContextPG.get().getDataBase();

		TalonarioLetra obj = null;

		try {

			db.begint();

			obj = (TalonarioLetra) db.fillObjectById(id, TalonarioLetra.class, 4);
			if (obj == null) {
				throw new IllegalStateException("No se pudo encontrar el " + TalonarioLetra.class.getCanonicalName() + " con id " + obj);				
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

			count = db.countAllObjects(TalonarioLetra.class);

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

	@SuppressWarnings("unchecked")
	public List<TalonarioLetra> find() throws Exception {		

		DataBase db = BackendContextPG.get().getDataBase();

		List<TalonarioLetra> listado = null;

		try {

			db.begint();

			listado = db.fillAllObjects(TalonarioLetra.class);

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		if (listado == null) {
			listado = new ArrayList<TalonarioLetra>();
		}

		return listado;
	}
	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<TalonariosLetras> find(TalonariosLetrasFiltro f) throws Exception {

		if (f == null) {
			throw new IllegalArgumentException(
					"Se esperaba un objeto " + TalonariosLetrasFiltro.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		List<TalonariosLetras> listado = null;

		try {

			db.begint();

			listado = db.findTalonariosLetras(f);

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		if (listado == null) {
			listado = new ArrayList<TalonariosLetras>();
		}

		return listado;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer count(TalonariosLetrasFiltro f) throws Exception {
		
		if (f == null) {
			throw new IllegalArgumentException(
					"Se esperaba un objeto " + TalonariosLetrasFiltro.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		Integer count = 0;

		try {

			db.begint();

			count = db.countTalonariosLetras(f);

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