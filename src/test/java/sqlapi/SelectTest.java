package sqlapi;

import static cn.my0a.sqlapi.SqlApi.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SelectTest {

	@Test
	public void testSelect() {
		String sql =
			SELECT(
				T("u").C("id").AS("id"), 
				T("u").C("name").AS("name"),
				T("s").C("amount").AS("amount")
			)
			.FROM(T("t_user").AS("u"), T("t_salary").AS("s"))
			.WHERE(
				AND(
					C("id").GT(5),
					C("name").GT("a")
				)
			)
			.toSql();
		System.out.println(sql);
	}
	
	public static void main (String args[]) {
		new SelectTest().testSelect();
	}

}
