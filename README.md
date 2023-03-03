# Doctor-Booking

## Framework And language used
- SpringBoot
- Java
## Data Flow
### Model
- 1- Doctor
- 2- Patient

### Controller
- 1- DoctorController
- 2- PatientController

### Service
- 1- DoctorService
- 2- PatientService

### Repository
- 1- DoctorRepository
- 2- PatientRepository

### Database Design
- Here we are using the MYSQL DataBase and it is in a Tabular Form

## Project Summary
In this Project CRUD operations are performed by hitting the API and here are the links for different model:

1) Doctor
- PostMapping -> http://localhost:8080/api/v1/postDoctor
- GetMapping -> http://localhost:8080/api/v1/getDoctor
- GetMapping -> http://localhost:8080/api/v1/getByExperience
- PutMapping -> http://localhost:8080/api/v1/updateDoctor/{doctorId}
- DeleteMapping -> http://localhost:8080/api/v1/deleteDoctor

2) Patient
- PostMapping -> http://localhost:8080/api/v1/Patient
- GetMapping - > http://localhost:8080/api/v1/getPatient
- PutMapping -> http://localhost:8080/api/v1/updatePatient/{patientId}
- DeleteMapping -> http://localhost:8080/api/v1/deletePatient/{patientId}
