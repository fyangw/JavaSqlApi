# JavaSqlApi 

JavaSqlApi is a SQL DSL API for Java.

# Introduction

As we known, Java doesn't support native SQL. But Java supports DSL, which can build SQL-like DSL interface with ease. The API is a good ORM tool to model data operation in Java. On the other hand, the API can model SQL syntax tree as well.

# SQL API DSL Example

SQL API DSL Example
```Java
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
```

Equivalent SQL
```SQL
SELECT u.user_id AS user_id, u.name AS name, s.amount AS amount
FROM t_user AS u, t_salary AS s
WHERE u.user_id = s.user_id
 AND u.user_id > 5
 AND u.name > 'a'
```

Other simplified syntax
```Java
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

SELECT(
  "u.uid user_id",
  "u.name",
  "s.amount"
)
.FROM("t_user u", "t_salary s")
.WHERE(
  AND(
    E("u.user_id = s.user_id"), 
    E("u.user_id > ?", 5),
    E("u.name > ?", "a")
  )
)
```
