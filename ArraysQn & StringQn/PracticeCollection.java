import java.util.*;


class Employee{ //what data will actually be stored, what info we can store about this entity, info about this entity
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    @Override
    public String toString(){
        return "Employee{name='"+name+"', age="+age+", salary="+salary+"}";
    }
    // Getters and setters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getSalary() {
        return salary;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
public class PracticeCollection {
    public static void main(String[] args){
        List<Integer> l1=new ArrayList<>(Arrays.asList(50,10,30,20,66));
        List<Integer> l2=new ArrayList<>(Arrays.asList(80,10,30,70,96));
        List<Integer> l3=new ArrayList<>(Arrays.asList(50,20,30,40,80));
        List<Integer> l4=new ArrayList<>(Arrays.asList(20,30,40));

        List<Integer> nums=new ArrayList<>(Arrays.asList(50,10,30,20));
        //ascending order
        Collections.sort(nums);
        System.out.println(nums);

        //descending order
        nums.sort(Collections.reverseOrder());
        System.out.println(nums);

        //List of employees
        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 70000));

        //sort employees by any field like salary in ascending order
        employees.sort(Comparator.comparingDouble(Employee::getSalary)); //method reference
        System.out.println(employees);

        //sort employees by any field like name in descending order
        employees.sort(Comparator.comparing(Employee::getName).reversed());
        System.out.println(employees);

        //converting list to set
        Set<Integer> numSet=new HashSet<>(nums);
        System.out.println(numSet); //duplicates disappear, order is not guaranteed

        //common elements between two lists[common users, common products, common items]
        l1.retainAll(l2);
        System.out.println(l1);

        //Non common elements between two lists (elements present in one list but not another)
        l3.removeAll(l4);
        System.out.println(l3);

        //whether an element exist
        if(l1.contains(10)){
            System.out.println("Element found");
        }

        //second largest using collections
        TreeSet<Integer> sortedSet=new TreeSet<>(nums);
        sortedSet.pollLast(); //targets and removes the highest element
        System.out.println(sortedSet.last()); //find the highest element

        //reverse a list
        Collections.reverse(nums);
        System.out.println(nums);

        //count word frequency //hashmap is used for fast lookup and counting occurrences of words in a string
        String sentence="This is a sample sentence. This sentence is for testing.";
        String[] words=sentence.toLowerCase().split("\\W+"); //split the string into array of substrings
        Map<String,Integer> wordCount=new HashMap<>();
        for(String word:words){
            wordCount.put(word,wordCount.getOrDefault(word,0)+1);
        }
        for(Map.Entry<String,Integer> en:wordCount.entrySet()){
            System.out.println(en.getKey()+" : "+en.getValue()); //both key and value we get
        }

        //add values in map
        Map<Integer,String> map=new HashMap<>();
        map.put(101,"Mohan");
        map.put(102,"Sohan");
        map.put(103,"Rohan");
        for(Integer id:map.keySet()){ //only keys we get (key unique)
            System.out.println(id);
        }
        for(String name:map.values()){ //only values we get (values may be duplicate)
            System.out.println(name);
        }     

        //remove elements from list safely while iterating(use Iterator)
        List<Integer> numbers=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Iterator<Integer> iterator=numbers.iterator();
        while(iterator.hasNext()){
            Integer num=iterator.next();
            if(num%2==0){
                iterator.remove(); //removes even numbers safely
            }
        }
        System.out.println(numbers);
        // or
        // numbers.removeIf(num -> num % 2 == 0); //removes even numbers safely (fail-fast behaviour=thread-safety guarantee,sturctural modification during iteration, and prevent concurrent modification exceptions)
        // System.out.println(numbers);

        //Queue for processing tasks in order (FIFO)
        Queue<String> taskQueue=new ArrayDeque<>();
        taskQueue.offer("Task 1");  //order processing, msg processing, Job processing, Print queue, Request Processing
        taskQueue.offer("Task 2");
        taskQueue.offer("Task 3"); 
    }
}

// collection ***
// generic and annotation
// exception handling *
// multithreading and concurrency ***
// file handling 
// java 8 features ***

// spring boot *** and all practice advance coding ***

// R1 = PS, R3 = APT, R4 = communication
// R2 = CJ + CS + SQL + SpringBoot + React fundamentals 

//why use Stream APIs: describes what you want to do with the data, rather than how to do it.
//they make our data processing code shorter, easier to read, and less bug-prone by replacing manual loops.