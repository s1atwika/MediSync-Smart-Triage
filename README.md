# MediSync: Smart Patient Triage & Risk Analyzer

**Domain:** Healthcare AI / Computational Biology (CB)  
**Course:** Object-Oriented Programming (OOPS)

## Project Overview
MediSync is an Object-Oriented Java-based application designed to automate patient triage. The system ingests a real-world dataset of 2,000 patients from Kaggle (`patients.csv`) using Java File I/O. It utilizes a modular rule-based AI engine to analyze patient vitals (BP, Glucose, BMI) and dynamically routes them to the appropriate department (Cardiology or Endocrinology).

## OOP Concepts Implemented
*   **Inheritance:** `Patient` extends the abstract `Person` class.
*   **Polymorphism & Interfaces:** `MedicalAnalyzer` interface implemented by `CardioAnalyzer` and `DiabetesAnalyzer`.
*   **Design Patterns (Factory):** `AIEngine` dynamically assigns the correct analyzer.
*   **Collections & Sorting:** Custom `Comparator` sorts an `ArrayList` of patients by risk.
*   **Exception Handling:** Custom `InvalidVitalException` prevents corrupted data.

## Working Model (Frontend Dashboard)
I have included an `index.html` file in this repository. This is a frontend simulation of the backend Java logic. 
**To run the simulation:** Simply download `index.html` and open it in any web browser. Click the "Run AI Triage Engine" button to see the logic in action.
