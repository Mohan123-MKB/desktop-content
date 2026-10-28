class Employee{
    //class holding multiple possible properties(data members)
    //class holding multiple possible behaviour(member functions)
    //emp1,emp2,emp3,emp4,emp5 this are multiple objects we can create based on blueprint(class)
    //this are possible properties and possible behaviour present here
    //encapsulation-make data as private, everyone cannot access data directly but indirectly we can access data with help of getters ands setters method,data hiding,data security(prevents unauthorized access),data integrity(prevents invalid values from being stored),data privacy,validation(ensures valid data only stored, error handling is provide meaningful feedback when bad data is passed),modularity(internal changes don't break external usage),resuability
    int id;
    private int age; //declared private so they cannot be accessed directly outside the scope of this class
    String name;
    String city;
    double salary;

    public Employee(int id,String name,String city,double salary){
        this.id=id;
        this.name=name;
        this.city=city;
        this.salary=salary;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){ //setter methods use when we need validation otherwise we use constructor itself)
        if(age>0){
            this.age=age;
        }
        else{
            System.out.println("Age must be positive!");
        }
    }
    public void doWork(){
        System.out.println(name + " " + "is doing work");
    }
    public void attendMeeting(){
        System.out.println(name + " " + "is attend meeting");
    }
    public void markAttendance(){
        System.out.println(name + " " + "is mark attendance");
    }
} 

public class EmpMain {

    public static void main(String[] args) {

        Employee emp1 = new Employee(
            1,
            "SenthilKumar",
            "Chennai",
            100000.00
        );

        emp1.setAge(50);

        System.out.println("Employee age: " + emp1.getAge());

        emp1.doWork();
        emp1.attendMeeting();
        emp1.markAttendance();
    }
}
