public class Main {
    public static void main(String[] args){
        Person[] personArray = new Person[5];

        personArray[0] = new Person("Иванов Иван Иванович", "кладовщик", "ivanov@mail.ru", "123 45 56", 1700.5,  62);
        personArray[1] = new Person("Петров Петр Петрович", "слесарь", "petrov@mail.ru", "453 67 25", 3400.78,  49);
        personArray[2] = new Person("Максимов Максим Мксимович", "аудитор", "maksimov@mail.ru", "321 57 12", 6723.1,  35);
        personArray[3] = new Person("Антонов Антон Антонович", "водитель", "antonov@mail.ru", "739 23 66", 8700.8,  38);
        personArray[4] = new Person("Семенов Семен Семенович", "директор", "semenov@mail.ru", "475 42 78", 100600.0,  45);

        selectPersonUnder40(personArray);
    }

    public static void selectPersonUnder40(Person[] personArray){
        for (Person person: personArray) {
            if (person.getAge() > 40){
                person.printPersonInfo();
            }
        }
    }

}
