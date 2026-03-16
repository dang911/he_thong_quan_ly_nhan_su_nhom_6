package hrdemo;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;

public class FileHandler {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public void saveEmployees(List<Employee> employees,boolean append) {

        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("employees.txt", append)
            );
            for (Employee e : employees) {
                bw.write(e.toString());
                bw.newLine();
            }
            bw.close();
            System.out.println("Saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving file!");
        } 
    }
    
//    public void saveWorkLogs(List<WorkLog> workLogs) {
//
//        try {
//            BufferedWriter bw = new BufferedWriter(
//                    new FileWriter("worklogs.txt")
//            );
//
//            for (WorkLog w : workLogs) {
//
//                String formattedDate = sdf.format(w.getDate());
//
//                bw.write(
//                        w.getEmpId() + "," +
//                        formattedDate + "," +
//                        w.getHoursWorked()
//                );
//
//                bw.newLine();
//            }
//
//            bw.close();
//            System.out.println("WorkLogs saved successfully!");
//
//        } catch (IOException e) {
//            System.out.println("Error saving WorkLogs!");
//        }
//    }
    
    public List<Employee> loadEmployees() {

        List<Employee> employees = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(
                new FileReader("employees.txt")
            );

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String type = data[0];
                String id = data[1];
                String fullName = data[2];
                Date dob = sdf.parse(data[3]);
                String phone = data[4];
                String email = data[5];
                String deptId = data[6];
                switch (type) {
                    case "FT":
                        double baseSalary = Double.parseDouble(data[7]);
                        double bonus = Double.parseDouble(data[8]);
                        employees.add(new FullTimeEmployee(
                                id, fullName, dob,
                                phone, email, deptId,
                                baseSalary,bonus));
                        break;
                    case "PT":
                        double rate = Double.parseDouble(data[7]);
                        employees.add(new PartTimeEmployee(
                                id, fullName, dob,
                                phone, email, deptId,
                                rate));
                        break;
                    case "IN":
                        double allowance = Double.parseDouble(data[7]);
                        employees.add(new InternEmployee(
                                id, fullName, dob,
                                phone, email, deptId,
                                allowance));
                        break;
                    default:
                        break;
                }
            }
        br.close();

    } catch (IOException | ParseException e) {
        System.out.println("Error loading file!");
    }
        return employees;
    }
    
    public List<WorkLog> loadWorkLogs() {

        List<WorkLog> workLogs = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("worklogs.txt")
            );

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String Empid = data[0];
                Date date = sdf.parse(data[1]);   // parse lại ngày
                double hoursWorked = Double.parseDouble(data[2]);

                WorkLog w = new WorkLog(Empid, date, hoursWorked);
                workLogs.add(w);
            }

            br.close();
            System.out.println("WorkLogs loaded successfully!");

        } catch (IOException e) {
            System.out.println("File error while loading WorkLogs!");
        } catch (ParseException e) {
            System.out.println("Date format error in WorkLogs file!");
        }

        return workLogs;
    }
    
    public void saveLeaves(List<Leave> leaves,boolean append) {

        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("leaves.txt", append)
            );
            for (Leave l : leaves) {
                bw.write(l.toString());
                bw.newLine();
            }
            bw.close();
            System.out.println("Saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving file!");
        } 
    }
    
    public List<Leave> loadLeaves() {

        List<Leave> leaves = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("leaves.txt")
            );

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String Empid = data[0];
                Date fromDate = sdf.parse(data[1]);   
                Date toDate = sdf.parse(data[2]);
                String reason = data[3];
                String status = data[4];

                Leave l = new Leave(Empid, fromDate, toDate, reason, status);
                leaves.add(l);
            }

            br.close();
            System.out.println("Leaves loaded successfully!");

        } catch (IOException e) {
            System.out.println("File error while loading Leaves!");
        } catch (ParseException e) {
            System.out.println("Date format error in Leaves file!");
        }

        return leaves;
    }
}

