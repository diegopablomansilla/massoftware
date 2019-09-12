
package com.massoftware.service.fondos;

import java.util.ArrayList;
import java.util.List;

import com.massoftware.service.BackendContextPG;
import com.massoftware.service.DataBase;

public class TipoComprobanteCopiaAlternativoService {

	// ---------------------------------------------------------------------------------------------------------------------------

	public TipoComprobanteCopiaAlternativo insert(TipoComprobanteCopiaAlternativo obj) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("Se esperaba un objeto " + TipoComprobanteCopiaAlternativo.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.insertObject(obj);
			if (b == false) {
				throw new IllegalStateException("No se pudo guardar el " + TipoComprobanteCopiaAlternativo.class.getCanonicalName() + " " + obj);
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

	public TipoComprobanteCopiaAlternativo update(TipoComprobanteCopiaAlternativo obj) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("Se esperaba un objeto " + TipoComprobanteCopiaAlternativo.class.getCanonicalName() + " no nulo.");
		}
		if (obj.getId() == null || obj.getId().trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un objeto " + TipoComprobanteCopiaAlternativo.class.getCanonicalName() + " con id no nulo/vacio.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.updateObject(obj);
			if (b == false) {
				throw new IllegalStateException("No se pudo guardar el " + TipoComprobanteCopiaAlternativo.class.getCanonicalName() + " " + obj);
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
			throw new IllegalArgumentException("Se esperaba un id (" + TipoComprobanteCopiaAlternativo.class.getCanonicalName() + ".id) no nulo/vacio.");
		}

		id = id.trim();

		DataBase db = BackendContextPG.get().getDataBase();

		try {

			db.begint();

			boolean b = db.deleteObjectById(id, TipoComprobanteCopiaAlternativo.class);
			if (b == false) {
				throw new IllegalStateException("No se pudo borrar el " + TipoComprobanteCopiaAlternativo.class.getCanonicalName() + " " + id);
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

	public TipoComprobanteCopiaAlternativo findById(String id) throws Exception {

		if (id == null || id.trim().length() == 0) {
			throw new IllegalArgumentException("Se esperaba un id (" + TipoComprobanteCopiaAlternativo.class.getCanonicalName() + ".id) no nulo/vacio.");
		}

		id = id.trim();

		DataBase db = BackendContextPG.get().getDataBase();

		TipoComprobanteCopiaAlternativo obj = null;

		try {

			db.begint();

			obj = (TipoComprobanteCopiaAlternativo) db.fillObjectById(id, TipoComprobanteCopiaAlternativo.class, 4);
			if (obj == null) {
				throw new IllegalStateException("No se pudo encontrar el " + TipoComprobanteCopiaAlternativo.class.getCanonicalName() + " con id " + obj);				
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

			count = db.countAllObjects(TipoComprobanteCopiaAlternativo.class);

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
	public List<TipoComprobanteCopiaAlternativo> find() throws Exception {		

		DataBase db = BackendContextPG.get().getDataBase();

		List<TipoComprobanteCopiaAlternativo> listado = null;

		try {

			db.begint();

			listado = db.fillAllObjects(TipoComprobanteCopiaAlternativo.class);

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		if (listado == null) {
			listado = new ArrayList<TipoComprobanteCopiaAlternativo>();
		}

		return listado;
	}
	
	// ---------------------------------------------------------------------------------------------------------------------------

	public List<TiposComprobantesCopiasAlternativos> find(TiposComprobantesCopiasAlternativosFiltro f) throws Exception {

		if (f == null) {
			throw new IllegalArgumentException(
					"Se esperaba un objeto " + TiposComprobantesCopiasAlternativosFiltro.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		List<TiposComprobantesCopiasAlternativos> listado = null;

		try {

			db.begint();

			listado = db.findTiposComprobantesCopiasAlternativos(f);

			db.commit();

		} catch (Exception e) {
			db.rollBack();
			throw e;
		} finally {
			db.close();
		}

		if (listado == null) {
			listado = new ArrayList<TiposComprobantesCopiasAlternativos>();
		}

		return listado;
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Integer count(TiposComprobantesCopiasAlternativosFiltro f) throws Exception {
		
		if (f == null) {
			throw new IllegalArgumentException(
					"Se esperaba un objeto " + TiposComprobantesCopiasAlternativosFiltro.class.getCanonicalName() + " no nulo.");
		}

		DataBase db = BackendContextPG.get().getDataBase();

		Integer count = 0;

		try {

			db.begint();

			count = db.countTiposComprobantesCopiasAlternativos(f);

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