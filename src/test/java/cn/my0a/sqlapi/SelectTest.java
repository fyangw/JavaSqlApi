package cn.my0a.sqlapi;

import static cn.my0a.sqlapi.SqlApi.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SelectTest {

	@Test
	public void testSelect() {
		String sql =
			SELECT(
				T("u").C("user_id").AS("user_id"), 
				T("u").C("name").AS("name"),
				T("s").C("amount").AS("amount")
			)
			.FROM(T("t_user").AS("u"), T("t_salary").AS("s"))
			.WHERE(
				AND(
					T("u").C("user_id").EQ(T("s").C("user_id")), 
					T("u").C("user_id").GT(5),
					T("u").C("name").GT("a")
				)
			)
			.toSql();
		System.out.println(sql);
	}
	
	@Test
	public void testSelect2() {
		String sql =
			SELECT(
				C("u.user_id").AS("user_id"), 
				C("u.name").AS("name"),
				C("s.amount").AS("amount")
			)
			.FROM(T("t_user").AS("u"), T("t_salary").AS("s"))
			.WHERE(
				AND(
					C("u.user_id").EQ(C("s.user_id")), 
					C("u.user_id").GT(5),
					C("u.name").GT("a")
				)
			)
			.toSql();
		System.out.println(sql);
	}
	public static void main (String args[]) {
		new SelectTest().testSelect();
	}

}
