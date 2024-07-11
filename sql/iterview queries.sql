SELECT name, salary
FROM employee
WHERE salary = (
  SELECT MAX(salary)
  FROM employee
  WHERE salary < (SELECT MAX(salary) FROM employee)
);


