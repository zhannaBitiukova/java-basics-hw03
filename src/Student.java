public class Student {
  private int rating;
  private String name;
  private boolean ratingInitialized = false;
  public static int count = 0;
  public static int totalRating = 0;
  public static double avgRating = 0.0d;

  public Student() {
    count++;
  }

  public Student(String name) {
    count++;
    this.name = name;
  }

  public Student(String name, int rating) {
    count++;
    this.name = name;
    this.rating = rating;
    totalRating += rating;
    ratingInitialized = true;
    calculateAvgRating();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRating() {
    return this.rating;
  }

  public void setRating(int rating) {
    if (ratingInitialized) totalRating -= this.rating;
    this.rating = rating;
    totalRating += rating;
    calculateAvgRating();
    this.ratingInitialized = true;
  }

  public static double getAvgRating() {
    return avgRating;
  }

  public static void calculateAvgRating() {
    if (count == 0) {
      avgRating = 0.0d;
    }
    else {
      avgRating = (double) totalRating / (double) count;
    }
  }

  public void changeRating(int rating) {
    if (ratingInitialized) totalRating -= this.rating;
    this.rating = rating;
    totalRating += rating;
    calculateAvgRating();
    this.ratingInitialized = true;
  }

  public boolean betterStudent(Student student) {
    return this.rating > student.rating;
  }

  public static void removeStudent(Student student) {
    count--;
    totalRating -= student.rating;
    calculateAvgRating();
  }

  public static void printCommonStats() {
    String roundedAvgRating = String.format("%.02f", Student.getAvgRating());
    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    System.out.println("Student count:  " + Student.count);
    System.out.println("Total rating:   " + Student.totalRating);
    System.out.println("Average rating: " + roundedAvgRating);
  }

  public static void printPersonalData(Student... student) {
    System.out.println("----------------------------------------------------------------");
    for (Student person : student)
      System.out.println(person.toString());
  }

  @Override
  public String toString() {
    return "               - " + this.name + ", rating " + this.rating;
  }

  public static void main(String[] args) {
    printCommonStats();

    Student student1 = new Student();
    student1.setName("Marichka");
    student1.setRating(50);

    Student student2 = new Student("Olena");
    student2.setRating(16);

    Student student3 = new Student("Bohdan", 68);

    printCommonStats();
    printPersonalData(student1, student2, student3);

    student1.changeRating(4);

    printCommonStats();
    printPersonalData(student1, student2, student3);
  }
}


