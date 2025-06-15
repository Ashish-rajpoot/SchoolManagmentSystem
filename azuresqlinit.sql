-- Create database (optional in Azure, usually done in portal)
-- CREATE DATABASE schoolmanagementapp;

-- Use the database (Azure doesn't allow USE in batch scripts, so skip if executing in Azure Portal)

-- USERS table
CREATE TABLE users (
    user_id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    email NVARCHAR(100) NOT NULL UNIQUE,
    password NVARCHAR(255) NOT NULL,
    role NVARCHAR(50) NOT NULL
);

-- TEACHERS table
CREATE TABLE teachers (
    teacher_id INT IDENTITY(1,1) PRIMARY KEY,
    teacher_name NVARCHAR(100) NOT NULL,
    age INT,
    gender NVARCHAR(10),
    email_id NVARCHAR(100) UNIQUE
);

-- SUBJECTS table
CREATE TABLE subjects (
    subject_id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL
);

-- CLASSES table
CREATE TABLE classes (
    class_id INT IDENTITY(1,1) PRIMARY KEY,
    class_name NVARCHAR(100) NOT NULL,
    seats INT DEFAULT 0,
    strength INT DEFAULT 0
);

-- STUDENTS table
CREATE TABLE students (
    student_id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    email_id NVARCHAR(100) NOT NULL,
    age INT,
    gender NVARCHAR(10),
    class_id INT,
    FOREIGN KEY (class_id) REFERENCES classes(class_id)
);

-- ASSIGN table
CREATE TABLE assign (
    assign_id INT IDENTITY(1,1) PRIMARY KEY,
    class_name NVARCHAR(100),
    subject_name NVARCHAR(100),
    teacher_name NVARCHAR(100)
);

-- CLASS_SUBJECTS_TEACHERS table
CREATE TABLE class_subjects_teachers (
    id INT IDENTITY(1,1) PRIMARY KEY,
    class_id INT,
    subject_id INT,
    teacher_id INT,
    assign_id INT,
    FOREIGN KEY (class_id) REFERENCES classes(class_id),
    FOREIGN KEY (subject_id) REFERENCES subjects(subject_id),
    FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id),
    FOREIGN KEY (assign_id) REFERENCES assign(assign_id)
);
