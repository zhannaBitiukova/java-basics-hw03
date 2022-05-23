public class Student {
  private int rating;
  private String name;
  public static int count = 0;
  public static int totalRating = 0;
  public static double avgRating = 0.0d;

  // implement Student class according to the instructions provided in the README.md file
  public Student() {
    count++;
  }

  public Student(String name) {
    this.name = name;
    count++;
  }

  public Student(String name, int rating) {
    this.name = name;
    this.rating = rating;
    count++;
    totalRating += rating;
  }

  public static double getAvgRating() {
    // return average rating of all students
    if (count == 0) {
      avgRating = 0.0d;
    }
    else {
      avgRating = (double) totalRating / (double)  count;
    }
    return avgRating;
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
    // when a rating is set to a student for the first time
    // we need to add the rating to totalRating
    // This method MUST NOT be used to change rating second and further times
    this.rating = rating;
    totalRating += rating;
  }

  public boolean betterStudent(Student student) {
    boolean isBetterStudent = false;

    if (this.rating > student.rating) {
      isBetterStudent = true;
    }

    return isBetterStudent;
  }

  public void changeRating(int rating) {
    // TODO change this student's rating and average rating of all students
    // when a new rating is set to a student NOT for the first time
    // we need to remove their old rating from totalRating
    //and then add the new rating to totalRating
    totalRating -= this.rating;
    this.rating = rating;
    totalRating += rating;
  }

  public static void removeStudent(Student student) {
    // when removing student we must update the static fields:
    //1. decrement count of students
    //2. take student's rating out of the total rating
    //3. re-calcuate average rating using the new count and totalRating
    count--;
    totalRating -= student.rating;
    getAvgRating();
  }

  @Override
  public String toString() {
    // return String with name and rating of this student
    String studentInfoString = this.name + ", rating " + this.rating;
    return studentInfoString;
  }

  public static void main(String[] args) {
/*
    double averageRating = Student.getAvgRating();

    System.out.println(Student.count);
    System.out.println(Student.totalRating);
    System.out.println(Student.avgRating);
    System.out.println(averageRating);
    */


    //Student student1 = new Student("Marichka",15);
    //Student student2 = new Student("Olena", 30);
    //Student student3 = new Student("Bohdan", 13);
/*
    averageRating = Student.getAvgRating();
    System.out.println(averageRating);

    student1.setRating(45);
    averageRating = Student.getAvgRating();
    System.out.println(averageRating);
*/

    double averageRating = Student.getAvgRating();
    System.out.println(averageRating);

    /*
    Student student1 = new Student("Petro");
    student1.setRating(15);
    Student student2 = new Student("Volodymyr");
    student2.setRating(30);
     */
    Student student1 = new Student("Marichka",15);
    Student student2 = new Student("Olena", 30);
    Student student3 = new Student("Bohdan", 13);

    averageRating = Student.getAvgRating();
    System.out.println("Average student rating is " + averageRating);

  }
}


