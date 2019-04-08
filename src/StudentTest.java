import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class StudentTest {

  @Test
  public void testGetAvgRating() {

    assertEquals(Student.getAvgRating(), 0.0d, "Average rating is wrong");

    Student student1 = new Student("Petro");
    student1.setRating(15);
    Student student2 = new Student("Volodymyr");
    student2.setRating(30);

    assertEquals(Student.getAvgRating(), 22.5d, "Average rating is wrong");
  }

  @Test
  public void testGetName() {
    Student student = new Student("Petro");

    assertEquals(student.getName(), "Petro", "Student's name is wrong");
  }

  @Test
  public void testSetName() {
    Student student = new Student("Petro");
    student.setName("Volodymyr");

    assertEquals(student.getName(), "Volodymyr", "Student's name is wrong");
  }

  @Test
  public void testGetRating() {
    Student student1 = new Student("Volodymyr");

    assertEquals(student1.getRating(), 0, "Student's name is wrong");

    Student student2 = new Student("Petro");
    student2.setRating(51);

    assertEquals(student2.getRating(), 51, "Student's name is wrong");
  }

  @Test
  public void testSetRating() {
    Student student = new Student("Volodymyr");
    student.setRating(30);

    assertEquals(student.getRating(), 30, "Student's name is wrong");
  }

  @Test
  public void testBetterStudent() {
    Student student1 = new Student("Petro");
    student1.setRating(15);

    Student student2 = new Student("Volodymyr");
    student2.setRating(30);

    assertFalse(student1.betterStudent(student2),
        student1 + " is not better than " + student2);

    Student student3 = new Student("Petro");
    student3.setRating(51);

    Student student4 = new Student("Volodymyr");
    student4.setRating(30);

    assertTrue(student3.betterStudent(student4),
        student1 + " is not better than " + student2);
  }

  @Test
  public void testChangeRating() {

    assertEquals(Student.getAvgRating(), 0.0d, "Average rating is wrong");

    Student student1 = new Student("Petro");
    student1.setRating(15);
    Student student2 = new Student("Volodymyr");
    student2.setRating(30);

    assertEquals(Student.getAvgRating(), 22.5d, "Average rating is wrong");

    student2.changeRating(51);

    assertEquals(Student.getAvgRating(), 40.5d, "Average rating is wrong");
  }

  @Test
  public void testToString() {
    Student student = new Student("Petro");
    student.setRating(51);

    assertTrue(student.toString().contains("Petro"),
        "toString method does not contains student's name");

    assertTrue(student.toString().contains("51"),
        "toString method does not contains student's rating");
  }
}