## Part 1: Test it with SQL
## SQL TASK: At this point, you will have one table, job. In queries.sql under “Part 1”, list the columns and their data types in the table.
## SELECT COLUMN_NAME, DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'job';

## Part 2: Test it with SQL
## write a query to list the names of the employers in St. Louis City
## SELECT * FROM techjobs.employer WHERE location = "St. Louis City";

## Part 3: Test it with SQL
## write the SQL statement to remove the job table
DROP TABLE job;

## Part 4: Test it with SQL
##  write a query to return a list of the names and descriptions of all skills that are attached to jobs in alphabetical order.
## If a skill does not have a job listed, it should not be included in the results of this query.
## You will need to make use of “is not null”.
## I did not make use of “is not null”, but believe the INNER JOIN of the skill ID still allows for the skills to only be joined to a listed job.
SELECT id, name, description FROM techjobs.skill INNER JOIN techjobs.job_skills ON techjobs.skill.id = techjobs.job_skills.skills_id ORDER BY techjobs.skill.name ASC;