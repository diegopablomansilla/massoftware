
package com.massoftware.service.empresa;

import java.util.ArrayList;
import java.util.List;

import com.massoftware.service.BackendContextPG;
import com.massoftware.service.DataBase;

public class SucursalService {

	// ---------------------------------------------------------------------------------------------------------------------------

	public Sucursal insert(Sucursal obj) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("Se esperaba un objeto " + Sucursal.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.insertObject(obj);
			if (b == false) {
				throw new IllegalStateException("No se pudo guardar el " + Sucursal.class.getCanonicalName() + " " + obj);
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

	public Sucursal update(Sucursal obj) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("Se esperaba un objeto " + Sucursal.class.getCanonicalName() + " no nulo.");
		}
		if (obj.getId() == null || obj.getId().trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un objeto " + Sucursal.class.getCanonicalName() + " con id no nulo/vacio.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.updateObject(obj);
			if (b == false) {
				throw new IllegalStateException("No se pudo guardar el " + Sucursal.class.getCanonicalName() + " " + obj);
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
			throw new IllegalArgumentException("Se esperaba un id (" + Sucursal.class.getCanonicalName() + ".id) no nulo/vacio.");
		}

		id = id.trim();

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.deleteObjectById(id, Sucursal.class);
			if (b == false) {
				throw new IllegalStateException("No se pudo borrar el " + Sucursal.class.getCanonicalName() + " " + id);
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

	public Sucursal findById(String id) throws Exception {

		if (id == null || id.trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un id (" + Sucursal.class.getCanonicalName() + ".id) no nulo/vacio.");
		}

		id = id.trim();

		DataBase db = BackendContextPG.get().getDataBase();

		Sucursal obj = null;

		try {

			db.begint();

			obj = (Sucursal) db.fillObjectById(id, Sucursal.class, 4);
			if (obj == null) {
				throw new IllegalStateException("No se pudo encontrar el " + Sucursal.class.getCanonicalName() + " con id " + obj);				
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

			count = db.countAllObjects(Sucursal.class);

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
	public List<Sucursal> find() throws Exception {		

		DataBase db = BackendContextPG.get().getDataBase();

		List<Sucursal> listado = null;

		try {

			db.begint();

			listado = db.fillAllObjects(Sucursal.class);

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		if (listado == null) {
			listado = new ArrayList<Sucursal>();
		}

		return listado;
	}
	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<Sucursales> find(SucursalesFiltro f) throws Exception {

		if (f == null) {
			throw new IllegalArgumentException(
					"Se esperaba un objeto " + SucursalesFiltro.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		List<Sucursales> listado = null;

		try {

			db.begint();

			listado = db.findSucursales(f);

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		if (listado == null) {
			listado = new ArrayList<Sucursales>();
		}

		return listado;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer count(SucursalesFiltro f) throws Exception {
		
		if (f == null) {
			throw new IllegalArgumentException(
					"Se esperaba un objeto " + SucursalesFiltro.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		Integer count = 0;

		try {

			db.begint();

			count = db.countSucursales(f);

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