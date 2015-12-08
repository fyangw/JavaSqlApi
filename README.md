# JavaSqlApi 

JavaSqlApi is a SQL DSL API for Java.

# Introduction

As we known, Java doesn't support native SQL. But Java supports DSL, which can build SQL-like DSL interface with ease. 

# SQL API DSL Example

SQL API DSL Example
```Java
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
```

```SQL
SELECT u.user_id AS user_id, u.name AS name, s.amount AS amount
FROM t_user AS u, t_salary AS s
WHERE u.user_id = s.user_id
 AND u.user_id > 5
 AND u.name > 'a'
```
