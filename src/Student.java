public class Student {
  private int rating;
  private String name;
  public static int count = 0;
  public static int totalRating = 0;
  public static double avgRating = 0.0d;

  public Student() {
    // create an empty Student entity
    count++;
  }

  public Student(String name) {
    // create a student with specified name
    count++;
    this.name = name;
  }

  public Student(String name, int rating) {
    // create a student with specified name and rating
    count++;
    this.name = name;
    this.rating = rating;
    totalRating += rating;
    calculateAvgRating();
  }

  public String getName() {
    // get student name
    return name;
  }

  public void setName(String name) {
    // set student name
    this.name = name;
  }

  public int getRating() {
    // get student rating
    return this.rating;
  }

  public void setRating(int rating) {
    // initialise (set for the first time) student's rating
    // DO NOT USE this method to update an existent student rating
    this.rating = rating;
    totalRating += rating;
    calculateAvgRating();
  }

  public static double getAvgRating() {
    // return average rating of all students
    return avgRating;
  }

  public static void calculateAvgRating() {
    // calculate average rating of all students
    if (count == 0) {
      avgRating = 0.0d;
    }
    else {
      avgRating = (double) totalRating / (double) count;
    }
  }

  public void changeRating(int rating) {
    // update current student rating
    // DO NOT use this method to initialize student rating
    // Use this method every time when need to update existing rating
    totalRating -= this.rating;
    this.rating = rating;
    totalRating += rating;
    calculateAvgRating();
  }

  public boolean betterStudent(Student student) {
    // compare if the current student is better than another selected one
    return this.rating > student.rating;
  }

  public static void removeStudent(Student student) {
    // remove student
    count--;
    totalRating -= student.rating;
    calculateAvgRating();
  }

  public static void printCommonStats() {
    // print data related to all students
    String roundedAvgRating = String.format("%.02f", Student.getAvgRating());

    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    System.out.println("Student count:  " + Student.count);
    System.out.println("Total rating:   " + Student.totalRating);
    System.out.println("Average rating: " + roundedAvgRating);
  }

  public static void printPersonalData(Student... student) {
    // print data related to all students
    System.out.println("----------------------------------------------------------------");
    for (Student person : student)
      System.out.println(person.toString());
  }

  @Override
  public String toString() {
    // return String with name and rating of the current student
    return "               - " + this.name + ", rating " + this.rating;
  }

  public static void main(String[] args) {
    // Display initial data
    printCommonStats();

    // Create 3 objects of Student type and input information about them
    Student student1 = new Student();
    student1.setName("Marichka");
    student1.setRating(50);

    Student student2 = new Student("Olena");
    student2.setRating(16);

    Student student3 = new Student("Bohdan", 68);

    // Display the average rating of all students
    printCommonStats();
    printPersonalData(student1, student2, student3);

    // Change the rating of a student.
    student1.changeRating(4);

    // Display the new average rating.
    printCommonStats();
    printPersonalData(student1, student2, student3);
  }
}


