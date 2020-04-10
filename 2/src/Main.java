public class Main {


    /**
     * The Student class represents a student in a student administration system.
     * It holds the student details relevant in our context.
     *
     * @author Roholla
     * @version 0.0
     */
    public static class Student {
        /**
         * student’s first name
         */
        private String firstName;
        /**
         * student’s last name
         */
        private String lastName;
        /**
         * student's ID
         */
        private String id;
        /**
         * student's grade
         */
        private int grade;

        /**
         * Create a new student with a given name and ID number.
         *
         * @param fName student's first name
         * @param lName student's last name
         * @param sID student's ID
         */
        public Student(String fName, String lName, String sID) {
            firstName = fName;
            lastName = lName;
            id = sID;
            grade = 0;
        }

        /**
         * @return  student's first name
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * @return student's last name
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * @return student's id
         */
        public String getId() {
            return id;
        }

        /**
         * @return student's grade
         */
        public int getGrade() {
            return grade;
        }

        /**
         * @param firstName student's first name to be set
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /**
         * @param lastName student's last name to be set
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        /**
         * @param id student's id to be set
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @param grade student's grade to be set
         */
        public void setGrade(int grade) {
            this.grade = grade;
        }

        /**
         * Print the student’s last name and ID number to the output terminal.
         */
        public void print() {
            System.out.println(lastName + ", student ID: " + id + ", grade: " + grade);
        }

    }

    /**
     * This class is a representation of an actual lab
     * It holds some info about the lab and has some useful methods
     */
    public static class Lab {
        /**
         * array of students in the lab
         */
        private Student[] students;
        /**
         * the average of student's grades
         */
        private int avg;
        /**
         * the day of the week on which each lab session is held
         */
        private String day;
        /**
         * maximum number of students
         */
        private int capacity;
        /**
         * current number of students
         */
        private int currentSize;

        /**
         * constructs a new lab
         * @param capacity lab's capacity
         * @param day the day of the week on which each lab session is held
         */
        public Lab(int capacity, String day) {
            students = new Student[capacity];
            this.capacity = capacity;
            this.day = day;
            currentSize = 0;
            avg = 0;
        }

        /**
         * adds the new kid(student) to our lab if possible
         * @param std the new kid
         */
        public void enrollStudent(Student std) {
            if (currentSize < capacity)
                students[currentSize++] = std;
            else
                System.out.println("Lab is full!!!");
        }

        /**
         * prints a list of the students to standard output
         */
        public void print() {
            for (int i = 0; i < currentSize; i++) {
                System.out.print((i + 1) + ". ");
                students[i].print();
            }

        }

        /**
         * @return the students array
         */
        public Student[] getStudents() {
            return students;
        }

        /**
         * adds the new kids(students) to our lab one by one;
         * @param students the new kids
         */
        public void setStudents(Student[] students) {
            for(Student si: students)
                enrollStudent(si);
        }

        /**
         * @return the average of student's grades
         */
        public int getAvg() {
            return avg;
        }

        /**
         * sets the avg field to what it should be
         */
        public void calculateAvg() {
            int sum = 0;
            for(int i = 0; i < currentSize; i++)
                sum += students[i].getGrade();
            avg = sum / currentSize;
        }

        /**
         * @return the day of the week on which each lab session is held
         */
        public String getDay() {
            return day;
        }

        /**
         * sets the value of day field
         * @param day the new day of the week on which each lab session is held
         */
        public void setDay(String day) {
            this.day = day;
        }

        /**
         * @return the capacity of the lab
         */
        public int getCapacity() {
            return capacity;
        }

        /**
         * @param capacity the new capacity
         */
        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }
    }

}
