package cn.my0a.sqlapi;

public abstract class ValueDef {

	protected String asName;

	public Condition GT(int value) {
		return new Gt(this, new ConstDef(value));
	}

	public Condition GT(String value) {
		return new Gt(this, new ConstDef(value));
	}
	
	public Condition gt(ValueDef value) {
		return new Gt(this, value);
	}
	
	abstract public String toSql();

	public ValueDef AS(String asName) {
		this.asName = asName;
		return this;
	}
	
}
