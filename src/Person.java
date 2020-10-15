public class Person {
    private String fio;
    private String dolg;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Person(String fio, String dolg, String email, String phone, double salary, int age){
        this.fio = fio;
        this.dolg = dolg;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void printPersonInfo(){
        System.out.println("Сотрудник: " + fio + "; Должность: " + dolg  + "; E-mail: " + email + "; Телефон: " + phone + "; Зарплата: " + salary + "; Возраст: " + age);
    }

    public int getAge() {
        return age;
    }
}
