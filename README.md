# JavaSqlApi 

JavaSqlApi is a SQL DSL API for Java.

# Introduction

As we known, Java doesn't support native SQL. But Java supports DSL, which can build SQL-like DSL interface with ease. 

# API DSL Example

'''Java
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
'''
