#  how to build and Run?
Build docker image:
docker build -f Dockerfile -t docker-employee-service .
Run docker image:
docker run -p 8000:8000 docker-employee-service


# how to run with docker-compose?
docker-compose up
http://localhost:4000


#API
Create new Employees
POST: http://localhost:8000/employee

Body:
{
    "name": "6666666666",
    "role": "Manager",
    "age": 50,
    "gender": "m",
    "dept": "HR",
    "joiningDate": "2021-05-18",
    "address": {
        "doornumber": "1",
        "street": "My street",
        "city": "My city"
    }
}
joiningDate": "2021-05-18",
Update existing ones
PUT: http://localhost:8000/employee

Delete Employee:
DELETE: http://localhost:8000/employee/{id}

Get All Employees:
GET: http://localhost:8000/employees

Get Employee:
get the employee details by passing Employee Id with URL
GET: http://localhost:8000/employee/{id}
  




