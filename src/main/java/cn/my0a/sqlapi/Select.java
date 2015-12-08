package cn.my0a.sqlapi;

import java.util.ArrayList;
import java.util.List;

public class Select extends Query {

	private static final boolean TABLE = false;
	private static final boolean QUERY = true;
	private boolean type;
	private ValueDef[] valueDefs;
	private Select[] froms;
	private Condition condition;
	private ValueDef[] orderBys;
	private ValueDef[] groupBys;
	private String tableName;
	private String asName;

	public Select(ValueDef[] valueDefs) {
		this.valueDefs = valueDefs;
		this.type = QUERY;
	}
	
	public Select(String tableName) {
		this.tableName = tableName;
		this.type = TABLE;
	}
	
	public Select FROM(Select... froms) {
		this.froms = froms;
		return this;
	}
	
	public Select WHERE(Condition condition) {
		this.condition = condition;
		return this;
	}
	
	public Select orderBy(ValueDef... orderBys) {
		this.orderBys = orderBys;
		return this;
	}
	
	public Select groupBy(ValueDef... groupBys) {
		this.groupBys = groupBys;
		return this;
	}
	
	public List<Object> exec() {
		ArrayList<Object> ret = new ArrayList<Object>();

		ret.add(toSql());
		return ret;
	}

	public String toSql() {
		String fullSql = "";
		String sql = "";
		if (type == TABLE) {
			fullSql = tableName 
					+ (asName != null ? " AS " + asName : "");
		} else {
			// select
			fullSql += "SELECT ";
			sql = "";
			for (ValueDef v : valueDefs) {
				if (!sql.equals("")) {
					sql += ", ";
				}
				sql += v.toSql();
			}
			fullSql += sql + "\n";
			
			// from
			fullSql += "FROM ";
			sql = "";
			for (Select s : froms) {
				if (!sql.equals("")) {
					sql += ", ";
				}
				sql += s.toSql();
			}
			fullSql += sql + "\n";

			// where
			fullSql += "WHERE ";
			sql = condition.toSql();
			fullSql += sql;
		}
		
		return fullSql;
	}

	public ValueDef C(String colName) {
		return new ColumnDef(this, colName);
	}

	public Select AS(String asName) {
		this.asName = asName;
		return this;
	}

}
