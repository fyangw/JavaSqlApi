package cn.my0a.sqlapi;

public class ConstDef extends ValueDef {

	private Object value;

	public ConstDef(int value) {
		this.value = value;
	}

	public ConstDef(String value) {
		this.value = value;
	}
	
	public String toSql() {
		String sql;
		if (value == null) {
			sql = "NULL";
		} else if (value instanceof String) {
			sql = "'" + (String)value + "'";
		} else {
			sql = value.toString();
		}
		return sql;
	}

}
