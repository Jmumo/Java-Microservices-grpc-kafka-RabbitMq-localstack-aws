-- Ensure the table exists
DROP TABLE IF EXISTS Patient;


CREATE TABLE IF NOT EXISTS Patient (
                                        id UUID PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address VARCHAR(255) NOT NULL,
    gender VARCHAR(10),
    blood_group VARCHAR(5),
    dob DATE NOT NULL,
    admission_date DATE NOT NULL,
    status VARCHAR(20),
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    created_date VARCHAR(50)
    );

-- Insert 15 records
INSERT INTO Patient (id, name, email, phone, address, gender, blood_group, dob, admission_date, status, created_by, updated_by, created_date) VALUES
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174000', 'John Doe', 'john@example.com', '1234567890', '123 Main St', 'Male', 'O+', '1980-01-01', '2024-01-10', 'Admitted', 'admin', 'admin', '2024-01-10'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174001', 'Jane Smith', 'jane@example.com', '2345678901', '456 Elm St', 'Female', 'A+', '1985-02-15', '2024-02-12', 'Discharged', 'admin', 'admin', '2024-02-12'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174002', 'Alice Johnson', 'alice@example.com', '3456789012', '789 Oak St', 'Female', 'B+', '1990-03-10', '2024-03-05', 'Under Review', 'admin', 'admin', '2024-03-05'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174003', 'Bob Brown', 'bob@example.com', '4567890123', '321 Pine St', 'Male', 'AB-', '1975-04-20', '2024-04-08', 'Admitted', 'admin', 'admin', '2024-04-08'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174004', 'Emily Davis', 'emily@example.com', '5678901234', '654 Maple St', 'Female', 'O-', '1988-05-30', '2024-05-20', 'Discharged', 'admin', 'admin', '2024-05-20'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174005', 'Michael Green', 'michael@example.com', '6789012345', '987 Cedar St', 'Male', 'A-', '1982-06-12', '2024-06-10', 'Admitted', 'admin', 'admin', '2024-06-10'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174006', 'Sarah Taylor', 'sarah@example.com', '7890123456', '123 Birch St', 'Female', 'B-', '1993-07-07', '2024-07-15', 'Admitted', 'admin', 'admin', '2024-07-15'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174007', 'David Wilson', 'david@example.com', '8901234567', '456 Ash St', 'Male', 'AB+', '1996-08-19', '2024-08-02', 'Admitted', 'admin', 'admin', '2024-08-02'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174008', 'Laura White', 'laura@example.com', '9012345678', '789 Palm St', 'Female', 'O+', '1989-09-25', '2024-09-01', 'Discharged', 'admin', 'admin', '2024-09-01'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174009', 'James Harris', 'james@example.com', '0123456789', '321 Cherry St', 'Male', 'A+', '1991-10-10', '2024-10-10', 'Under Review', 'admin', 'admin', '2024-10-10'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174010', 'Emma Moore', 'emma@example.com', '1231231234', '654 Spruce St', 'Female', 'B+', '1984-11-22', '2024-11-11', 'Admitted', 'admin', 'admin', '2024-11-11'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174011', 'Ethan Martinez', 'ethan@example.com', '2342342345', '987 Redwood St', 'Male', 'O-', '1995-12-01', '2024-12-12', 'Discharged', 'admin', 'admin', '2024-12-12'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174012', 'Sophia Clark', 'sophia@example.com', '3453453456', '123 Hickory St', 'Female', 'AB-', '1987-01-17', '2025-01-10', 'Admitted', 'admin', 'admin', '2025-01-10'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174013', 'Daniel Lewis', 'daniel@example.com', '4564564567', '456 Cypress St', 'Male', 'A-', '1999-02-05', '2025-02-15', 'Admitted', 'admin', 'admin', '2025-02-15'),
                                                                                                                                                   ('123e4567-e89b-12d3-a456-426614174014', 'Isabella Walker', 'isabella@example.com', '5675675678', '789 Willow St', 'Female', 'B-', '1986-03-03', '2025-03-01', 'Admitted', 'admin', 'admin', '2025-03-01');