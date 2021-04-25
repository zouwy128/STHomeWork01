package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void APP(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> arr = new ArrayList<>();
        while (true){
            System.out.println("请选择操作：");
            System.out.println("***********************");
            System.out.println("*        1插入        *");
            System.out.println("*        2查找        *");
            System.out.println("*        3删除        *");
            System.out.println("*        4修改        *");
            System.out.println("*        5输出        *");
            System.out.println("*        6退出        *");
            System.out.println("***********************");
            int n = sc.nextInt();
            switch (n) {
                //按照输入的数字调用对应的函数
                case 1 :
                    addStudent(arr);
                    break;
                case 2 :
                    searchStudent(arr);
                    break;
                case 3 :
                    deleteStudent(arr);
                    break;
                case 4 :
                    updateStudent(arr);
                    break;
                case 5 :
                    outputStudent(arr);
                    break;
                case 6 :
                    System.out.println("谢谢使用");
                    System.exit(0);
                    break;
            }
        }
    }

    //判断是否有相同姓名的函数，传入集合和输入的新姓名，在studentAdd函数中使用，返回值根据情况有所不同
    public static boolean isUsed(ArrayList<Student> arr, String name) {
        boolean n = false;
        for (Student s : arr) {
            if (s.getName().equals(name)) {
                n = true;
                break;
            }
        }
        return n;
    }

    //插入学生函数
    public static void addStudent(ArrayList<Student> arr) {
        Scanner sc = new Scanner(System.in);
        //定义在外面，使后面的print能够调用
        String name;
        //用死循环配合isUsed函数判断是否输入相同姓名
        while (true) {
            System.out.println("姓名");
            name = sc.nextLine();
            if (isUsed(arr, name)) {
                System.out.println("姓名输入重复，请重新输入");
            } else break;
        }
        System.out.println("学号");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.println("出生日期");
        String birDate = sc.nextLine();
        System.out.println("性别");
        boolean gender = sc.nextBoolean();

        //装进student类中
        Student s = new Student();
        s.setID(ID);
        s.setName(name);
        s.setBirDate(birDate);
        s.setGender(gender);
        //把类装到集合中
        arr.add(s);
        System.out.println("插入成功!");
    }
    //查找学生函数
    private static void searchStudent(ArrayList<Student> arr) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入要查找学生的姓名：");
            String name = sc.nextLine();
            //用boolean来判断是否查找成功
            boolean index = true;
            for (int i = 0; i < arr.size(); i++) {
                Student s = arr.get(i);
                //遍历加if，删除对应的学生
                if (s.getName().equals(name)) {
                    index = false;
                    System.out.println("姓名" + "\t" +"学号" + "\t" +  "出生日期" + "\t" + "性别");
                    System.out.println(s.getName() + "\t" + s.getID() + "\t" + s.getBirDate() + "\t"+ s.isGender());
                    return;
                }
            }
            //查找不成功
            if (index) {
                System.out.println("姓名输入错误或不存在");
            }
        }
    }
    //删除学生函数
    private static void deleteStudent(ArrayList<Student> arr) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("查找要删除的学生的姓名：");
            String name = sc.nextLine();
            boolean index = true;
            for (int i = 0; i < arr.size(); i++) {
                Student s = arr.get(i);
                //遍历加if，删除对应的学生
                if (s.getName().equals(name)) {
                    arr.remove(i);
                    index = false;
                    System.out.println("删除成功！");
                    return;
                }
            }
            if (index) {
                System.out.println("姓名输入错误或不存在");
            }
        }
    }
    //修改学生函数
    private static void updateStudent(ArrayList<Student> arr) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("查找要修改的学生的姓名:");
            String name = sc.nextLine();
            boolean index = true;
            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(j).getName().equals(name)) {
                    //修改学生功能菜单
                    System.out.println("输入新的年龄:");
                    String newbirDate = sc.nextLine();
                    arr.get(j).setBirDate(newbirDate);
                    return;
                }
            }
            if (index) {
                System.out.println("姓名输入错误");
            }
        }
    }
    //输出学生函数
    private static void outputStudent(ArrayList<Student> arr) {
        //判断是否有数据存入其中
        if (arr.size() == 0) {
            System.out.println("无数据，请先输入数据");
            return;
        }
        //使用制表符制作表格，更好的展示
        System.out.println("姓名" + "\t" +"学号" + "\t" +  "出生日期" + "\t" + "性别");
        //可以使用增强for循环，针对只对数组，集合中对象单一遍历操作的函数
        for (Student s : arr) {
            System.out.println(s.getName() + "\t" + s.getID() + "\t" + s.getBirDate() + "\t"+ s.isGender());
        }
    }
}

