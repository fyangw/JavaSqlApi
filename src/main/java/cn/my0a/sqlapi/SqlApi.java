package cn.my0a.sqlapi;

public class SqlApi {
	public static Select SELECT (ValueDef ...valueDefs) {
		return new Select(valueDefs);
	}
	public static ValueDef C(String colName) {
		return new ColumnDef(colName);
	}
	public static Select T(String tabName) {
		return new Select(tabName);
	}
	public static Condition AND(Condition...conditions) {
		return new AndCondition(conditions);
	}
	
}
