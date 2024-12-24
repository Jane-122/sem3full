#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int day;
    char *month;  
    int year;
} DOB;

typedef struct {
    int reg_no;
    char *name;   
    char address[100];
} STU_INFO;

typedef struct {
    char *college_name;    
    char university_name[50];
} COLLEGE;

typedef struct {
    DOB *dob;
    STU_INFO info;
    COLLEGE college;
} STUDENT;

void readStudent(STUDENT *student) {
    student->dob = (DOB*)malloc(sizeof(DOB));
    student->dob->month = (char*)malloc(20 * sizeof(char));

    student->info.name = (char*)malloc(50 * sizeof(char));
    student->college.college_name = (char*)malloc(100 * sizeof(char));

    printf("Enter Date of Birth (dd mm yyyy): ");
    scanf("%d %s %d", &student->dob->day, student->dob->month, &student->dob->year);

    printf("Enter Registration Number: ");
    scanf("%d", &student->info.reg_no);
    printf("Enter Name: ");
    scanf(" %[^\n]", student->info.name);
    printf("Enter Address: ");
    scanf(" %[^\n]", student->info.address);

    printf("Enter College Name: ");
    scanf(" %[^\n]", student->college.college_name);
    printf("Enter University Name: ");
    scanf(" %[^\n]", student->college.university_name);
}

void displayStudent(const STUDENT *student) {
    printf("\nDate of Birth: %02d %s %d\n", student->dob->day, student->dob->month, student->dob->year);

    printf("Registration Number: %d\n", student->info.reg_no);
    printf("Name: %s\n", student->info.name);
    printf("Address: %s\n", student->info.address);

    printf("College Name: %s\n", student->college.college_name);
    printf("University Name: %s\n", student->college.university_name);
}

int main() {
    STUDENT *student = (STUDENT*)malloc(sizeof(STUDENT));

    readStudent(student);

    displayStudent(student);

    free(student->dob->month);
    free(student->dob);
    free(student->info.name);
    free(student->college.college_name);
    free(student);

    return 0;
}
