import java.util.LinkedList;

abstract class Animal {
    private int order;
    protected String name;
    public Animal(String name) { this.name = name; }
    public void setOrder(int order) { this.order = order; }
    public int getOrder() { return order; }
    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}

public class AnimalQueue {
    LinkedList<Cat> cats = new LinkedList<>();
    LinkedList<Dog> dogs = new LinkedList<>();
    private int order; // timestamp
    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if (a instanceof Dog) dogs.addLast((Dog) a);
        else if (a instanceof Cat) cats.add((Cat) a);
    }
    public Animal dequeueAny() {
        if (cats.size() == 0)
            return dequeueDog();
        else if (dogs.size() == 0)
            return dequeueCat();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat))
            return dequeueDog(); // smaller timestamp means older
        else return dequeueCat();

    }
    public Cat dequeueCat() { return cats.poll(); }
    public Dog dequeueDog() { return dogs.poll(); }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}
