public class Park {
    private String name;
    private String location;

    public Park(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public class Attraction {
        private String attractionName;
        private String workingHours;
        private double cost;

        public Attraction(String attractionName, String workingHours, double cost) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void printInfo() {
            System.out.println("Attraction Name: " + attractionName);
            System.out.println("Working Hours: " + workingHours);
            System.out.println("Cost: " + cost + " Руб");
            System.out.println("--------------------------");
        }
    }

    public static void main(String[] args) {
        Park park = new Park("Wonderland", "Парк Горького");
        Attraction rollerCoaster = park.new Attraction("Американские горки", "10:00 AM - 8:00 PM", 5.0);
        Attraction ferrisWheel = park.new Attraction("Колесо обозрения", "9:00 AM - 10:00 PM", 3.0);
        Attraction carousel = park.new Attraction("Карусель", "12:00 PM - 12:00 AM", 4.0);

        rollerCoaster.printInfo();
        ferrisWheel.printInfo();
        carousel.printInfo();
    }
}