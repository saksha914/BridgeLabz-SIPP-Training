interface Worker {
    void performDuties();
}

class Person {
    protected String name;
    protected int id;
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }
    @Override
    public void performDuties() {
        System.out.println(name + " (Chef) is preparing food.");
    }
}

class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }
    @Override
    public void performDuties() {
        System.out.println(name + " (Waiter) is serving customers.");
    }
}

public class RestaurantHybridInheritance {
    public static void main(String[] args) {
        Worker[] workers = {
            new Chef("Alice", 1),
            new Waiter("Bob", 2)
        };
        for (Worker w : workers) {
            w.performDuties();
        }
    }
} 