#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int day;
    int month;
    int year;
} Date;

typedef struct {
    char name[100];
    float cgpa;
    Date *birthdate;
    Date *admission_date;
    char address[200];
} Student;

void Age(Student *student) {
    int age = student->admission_date->year - student->birthdate->year;

    if (student->admission_date->month < student->birthdate->month ||
        (student->admission_date->month == student->birthdate->month && student->admission_date->day < student->birthdate->day)) {
        age--;
    }

    printf("Age of %s at the time of admission: %d years\n", student->name, age);
}

void inputStudentDetails(Student *student) {
    student->birthdate = (Date *)malloc(sizeof(Date));
    student->admission_date = (Date *)malloc(sizeof(Date));

    if (student->birthdate == NULL || student->admission_date == NULL) {
        printf("Memory allocation failed for date structures!\n");
        exit(1);
    }

    printf("Enter student details:\n");

    printf("Name: ");
    scanf("%s", student->name);

    printf("CGPA: ");
    scanf("%f", &student->cgpa);

    printf("Enter birthdate (day month year): ");
    scanf("%d %d %d", &student->birthdate->day, &student->birthdate->month, &student->birthdate->year);

    printf("Enter admission date (day month year): ");
    scanf("%d %d %d", &student->admission_date->day, &student->admission_date->month, &student->admission_date->year);

    printf("Address: ");
    scanf(" %[^\n]s", student->address);
}

void displayStudentDetails(Student *student) {
    printf("\nStudent Details:\n");
    printf("Name: %s\n", student->name);
    printf("CGPA: %.2f\n", student->cgpa);
    printf("Birthdate: %d-%d-%d\n", student->birthdate->day, student->birthdate->month, student->birthdate->year);
    printf("Admission Date: %d-%d-%d\n", student->admission_date->day, student->admission_date->month, student->admission_date->year);
    printf("Address: %s\n", student->address);

    Age(student);
}

int main() {
    int n;

    printf("Enter the number of students: ");
    scanf("%d", &n);

    Student *students = (Student *)malloc(n * sizeof(Student));

    if (students == NULL) {
        printf("Memory allocation failed!\n");
        return 1;
    }

    for (int i = 0; i < n; i++) {
        printf("\nEnter details for student %d\n", i + 1);
        inputStudentDetails(&students[i]);
    }

    for (int i = 0; i < n; i++) {
        displayStudentDetails(&students[i]);
    }

    for (int i = 0; i < n; i++) {
        free(students[i].birthdate);
        free(students[i].admission_date);
    }
    free(students);

    return 0;
}
