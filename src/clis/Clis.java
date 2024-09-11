
package clis;

import java.util.Scanner;


public class Clis {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of Applications: ");
        int numApplications = scanner.nextInt();

        ScholarshipApplication[] applications = new ScholarshipApplication[numApplications];

        for (int i = 0; i < numApplications; i++) {
            System.out.println("Enter details of application " + (i + 1) + ":");

            System.out.print("ID: ");
            int id = scanner.nextInt();

            System.out.print("Name: ");
            String name = scanner.next();

            System.out.print("GPA: ");
            double gpa = scanner.nextDouble();

            System.out.print("Annual Family Income: ");
            double annualFamilyIncome = scanner.nextDouble();

            System.out.print("Community Service Hours: ");
            int communityServiceHours = scanner.nextInt();

            applications[i] = new ScholarshipApplication(id, name, gpa, annualFamilyIncome, communityServiceHours);
        }

        System.out.println("ID\tName\tGPA\tAnnual Family Income\tScholarship Status");
        for (ScholarshipApplication application : applications) {
            System.out.println(application.id + "\t" + application.name + "\t" + String.format("%.1f", application.gpa) + "\t$" + String.format("%,.2f", application.annualFamilyIncome) + "\t" + (application.isApproved() ? "Approved" : "Denied"));
        }
    }
}

class ScholarshipApplication {
    int id;
    String name;
    double gpa;
    double annualFamilyIncome;
    int communityServiceHours;

    public ScholarshipApplication(int id, String name, double gpa, double annualFamilyIncome, int communityServiceHours) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.annualFamilyIncome = annualFamilyIncome;
        this.communityServiceHours = communityServiceHours;
    }

    public boolean isApproved() {
        return gpa >= 8.5 && annualFamilyIncome < 400000 && communityServiceHours > 60;
    }

    
}
