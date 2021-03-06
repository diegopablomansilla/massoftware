
package com.massoftware.service.fondos.banco;

import java.util.ArrayList;
import java.util.List;

import com.massoftware.service.BackendContextPG;
import com.massoftware.service.DataBase;

public class BancoService {

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

	public Long count() throws Exception {				

		DataBase db = BackendContextPG.get().getDataBase();

		Long count = 0L;

		try {

			db.begint();

			count = db.countAllObjects(Banco.class);

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
	public List<Banco> find() throws Exception {		

		DataBase db = BackendContextPG.get().getDataBase();

		List<Banco> listado = null;

		try {

			db.begint();

			listado = db.fillAllObjects(Banco.class);

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		if (listado == null) {
			listado = new ArrayList<Banco>();
		}

		return listado;
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



} // END CLASS