
package com.massoftware.service.logistica;

import java.util.ArrayList;
import java.util.List;

import com.massoftware.service.BackendContextPG;
import com.massoftware.service.DataBase;

public class TransporteService {

	// ---------------------------------------------------------------------------------------------------------------------------

	public Transporte insert(Transporte obj) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("Se esperaba un objeto " + Transporte.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.insertObject(obj);
			if (b == false) {
				throw new IllegalStateException("No se pudo guardar el " + Transporte.class.getCanonicalName() + " " + obj);
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

	public Transporte update(Transporte obj) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("Se esperaba un objeto " + Transporte.class.getCanonicalName() + " no nulo.");
		}
		if (obj.getId() == null || obj.getId().trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un objeto " + Transporte.class.getCanonicalName() + " con id no nulo/vacio.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.updateObject(obj);
			if (b == false) {
				throw new IllegalStateException("No se pudo guardar el " + Transporte.class.getCanonicalName() + " " + obj);
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
			throw new IllegalArgumentException("Se esperaba un id (" + Transporte.class.getCanonicalName() + ".id) no nulo/vacio.");
		}

		id = id.trim();

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.deleteObjectById(id, Transporte.class);
			if (b == false) {
				throw new IllegalStateException("No se pudo borrar el " + Transporte.class.getCanonicalName() + " " + id);
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

	public Transporte findById(String id) throws Exception {

		if (id == null || id.trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un id (" + Transporte.class.getCanonicalName() + ".id) no nulo/vacio.");
		}

		id = id.trim();

		DataBase db = BackendContextPG.get().getDataBase();

		Transporte obj = null;

		try {

			db.begint();

			obj = (Transporte) db.fillObjectById(id, Transporte.class, 4);
			if (obj == null) {
				throw new IllegalStateException("No se pudo encontrar el " + Transporte.class.getCanonicalName() + " con id " + obj);				
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

			count = db.countAllObjects(Transporte.class);

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

	public List<Transportes> find(TransportesFiltro f) throws Exception {

		if (f == null) {
			throw new IllegalArgumentException(
					"Se esperaba un objeto " + TransportesFiltro.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		List<Transportes> listado = null;

		try {

			db.begint();

			listado = db.findTransportes(f);

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		if (listado == null) {
			listado = new ArrayList<Transportes>();
		}

		return listado;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer count(TransportesFiltro f) throws Exception {
		
		if (f == null) {
			throw new IllegalArgumentException(
					"Se esperaba un objeto " + TransportesFiltro.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		Integer count = 0;

		try {

			db.begint();

			count = db.countTransportes(f);

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