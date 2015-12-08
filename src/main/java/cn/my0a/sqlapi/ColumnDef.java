package cn.my0a.sqlapi;

public class ColumnDef extends ValueDef {

	private String colName;
	private Select table;

	public ColumnDef(String colName) {
		this.table = null;
		this.colName = colName;
	}
	
	public ColumnDef(Select table, String colName) {
		this.table = table;
		this.colName = colName;
	}

	public Condition gt(ColumnDef columnDef) {
		return new Gt(this, columnDef);
	}
	
	public String toSql() {
		return (table != null ? table.toSql() + "." : "") 
				+ colName 
				+ (asName != null ? " AS " + asName : "");
	}

}
