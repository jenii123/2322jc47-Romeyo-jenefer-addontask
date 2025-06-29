
mysql> create table department(
    -> dept_id int primary key,
    -> dept_name varchar(100));
Query OK, 0 rows affected (0.02 sec)

mysql> create table Employee(
    -> emp_id int primary key,
    -> emp_name varchar(100),
    -> sal decimal(10,2),
    -> dept_id int,
    -> foreign key (dept_id) references department(dept_id));
Query OK, 0 rows affected (0.03 sec)

mysql> insert into department values(1,'HR'),(2,'IT'),(3,'Finance');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> insert into department values(4,'Sales'),(5,'Product');
Query OK, 2 rows affected (0.00 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> insert into employee values(201,'ravi',55000,2),(202,'meena',60000,3),(203,'raj',30000,4),(204,'jothi',44000,1),(205,'karan',56000,5);
Query OK, 5 rows affected (0.00 sec)
Records: 5  Duplicates: 0  Warnings: 0
