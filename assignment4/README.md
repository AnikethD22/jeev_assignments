## Build project

To run the tests and build the project run the command below:

```console
mvn package
```

## Excute the program

To execute the program, run the command below:

```console
 java -jar .\target\assignment4-1.0-SNAPSHOT.jar
```
If the above command fails with missing jdbc driver, run the command with adding the jdbc driver in the classpath.
```console
java -cp ".m2\repository\com\mysql\mysql-connector-j\8.0.33\mysql-connector-j-8.0.33.jar;target\classes" com.jeev.assignments.App
```


## Sample output

```console
1. Add a new student
2. Remove a student by ID
3. Update student details by ID
4. Search for a student by ID
5. Display all students
6. Exit


Enter your choice: 1
Enter Student ID: 1
Enter the Student Name: 1
Enter Student Age: 1
Enter Student Grade: 1
Enter Student Address: 1

ERROR: Student with the id 1 exists. Please enter unique student ID.

[Student{id=1, name='Deepak', age=15, grade='12', address='11 jjs '}]
Press Enter to continue...

```
