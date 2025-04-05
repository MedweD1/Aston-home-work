public class Main {
    public static void main(String[] args) {
        Employeer[] persArray = new Employeer[5];

        persArray[0] = new Employeer("Ivanov Ivan", "Engineer", "iviivan@mail.com", "8923452", 30000, 35);
        persArray[1] = new Employeer("Pert Sergeev", "QA Java", "pert@mail.com", "8943543", 40000, 33);
        persArray[2] = new Employeer("Serger Chikov", "Devops", "team@mail.com", "89243534", 35000, 34);
        persArray[3] = new Employeer("Ilhat Nurgaliev", "Designer", "ilham@mailbox.com", "845355522", 32000, 34);
        persArray[4] = new Employeer("Novikov Viktor", "Stager", "vik@mailbox.com", "893455543532", 38000, 19);

        for (Employeer employee : persArray) {
            employee.displayInfo();
            System.out.println("--------------------------");
        }

    }
}