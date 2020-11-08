## Part 1: Test it with SQL
SHOW FIELDS FROM job
## Part 2: Test it with SQL
SELECT * FROM employer
WHERE location = "St. Louis"
## Part 3: Test it with SQL
DROP TABLE job

## Part 4: Test it with SQL
SELECT skill.name, skill.description FROM job
INNER JOIN job_skills ON job.id = job_skills.jobs_id
INNER JOIN skill ON skill.id = job_skills.skills_id
ORDER BY skill.name ASC