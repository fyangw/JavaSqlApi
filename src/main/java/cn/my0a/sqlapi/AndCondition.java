package cn.my0a.sqlapi;

public class AndCondition extends Condition {

	private Condition[] conditions;

	public AndCondition(Condition[] conditions) {
		this.conditions = conditions;
	}

	@Override
	public String toSql() {
		String sql = "";
		for (Condition e : conditions) {
			if (!sql.equals("")) {
				sql += "\n AND ";
			}
			sql += e.toSql();
		}
		return sql;
	}
}
