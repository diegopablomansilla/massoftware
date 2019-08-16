package org.sorm.pg.stm.builder;

import org.sorm.model.Identifiable;
import org.sorm.pg.AbstractStmBuilder;
import org.sorm.stm.Statement;
import org.sorm.stm.StatementParam;

public class StmBuilderCount extends AbstractStmBuilder {

	public StmBuilderCount(String schema) {
		super(schema);
	}

	public StatementParam build(Identifiable obj) throws Exception {

		if (obj == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un objeto no nulo.");
		}

//		if (obj instanceof Identifiable == false) {
//			throw new IllegalArgumentException(
//					"QUERY: Se esperaba un objeto con tipo " + Identifiable.class.getSimpleName());
//		}

		return build(obj.getId(), obj.getClass());

	}

	@SuppressWarnings("rawtypes")
	public StatementParam build(String id, Class mappingClass) throws Exception {

		if (id == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba un id no nulo.");
		}

		id = id.trim();

		if (id.isEmpty()) {
			throw new IllegalArgumentException("QUERY: Se esperaba un id no vacio.");
		}

		if (mappingClass == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba una objeto Class (para el mapeo) no nulo.");
		}

		// if (isPersistent(mappingClass) == false) {
		// throw new IllegalArgumentException(
		// "DELETE: Se esperaba un objeto Class anotado con " +
		// PersistentMapping.class.getCanonicalName());
		// }

		StatementParam statement = new StatementParam();

		statement.addArg(id);

		statement.setSql("SELECT COUNT(*) FROM " + schema + "." + mappingClass.getSimpleName() + " WHERE id = ?");

		return statement;

	}

	@SuppressWarnings("rawtypes")
	public Statement build(Class mappingClass) throws Exception {

		if (mappingClass == null) {
			throw new IllegalArgumentException("QUERY: Se esperaba una objeto Class (para el mapeo) no nulo.");
		}

		// if (isPersistent(mappingClass) == false) {
		// throw new IllegalArgumentException(
		// "DELETE: Se esperaba un objeto Class anotado con " +
		// PersistentMapping.class.getCanonicalName());
		// }

		Statement statement = new Statement();

		statement.setSql("SELECT COUNT(*) FROM " + schema + "." + mappingClass.getSimpleName());

		return statement;

	}

}
