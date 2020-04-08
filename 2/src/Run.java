public class Run {
    public static void main(String[] args) {
        Main.Student std1 = new Main.Student("Ehsan","Edalat", "9031066");
        Main.Student std2 = new Main.Student("Seyed", "Ahmadpanah", "9031806");
        Main.Student std3 = new Main.Student("Ahmad", "Asadi", "9031054");

        std1.setGrade(15);

        std2.setGrade(11);

        std3.setFirstName("HamidReza");
        Main.Student[] students = {std1, std2, std3};
        Main.Lab lab = new Main.Lab(3, "MON");
        lab.setStudents(students);
        lab.print();

    }
}
