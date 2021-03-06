package cn.my0a.sqlapi;

public class Gt extends Condition {

	private ValueDef valueDef1;
	private ValueDef valueDef2;

	public Gt(ValueDef valueDef1, ValueDef valueDef2) {
		this.valueDef1 = valueDef1;
		this.valueDef2 = valueDef2;
	}

	@Override
	public String toSql() {
		return valueDef1.toSql() + " > " + valueDef2.toSql();
	}

}
