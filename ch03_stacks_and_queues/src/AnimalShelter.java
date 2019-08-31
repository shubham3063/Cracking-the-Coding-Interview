public class AnimalShelter {
    MyQueue<Integer> cats, dogs;
    static int time;
    AnimalShelter() {
        cats = new MyQueue<>();
        dogs = new MyQueue<>();
        time = 1;

    }
    public void enqueue(int animalType) {
        if (animalType == 0)
            cats.add(time);
        else dogs.add(time);
        time++;
    }

    public void dequeAny() {

        int catTime = Integer.MAX_VALUE, dogTime = Integer.MAX_VALUE;
        if (!cats.isEmpty())
            catTime = cats.peek();
        if(!dogs.isEmpty())
            dogTime = dogs.peek();

        if (catTime < dogTime)
            System.out.println("Cat removed: " + cats.remove());
        else
            System.out.println("Dog removed: " + dogs.remove());
    }

    public void dequeDog() {
        if (dogs.isEmpty()) {
            System.out.println("No dog in shelter");
            return;
        }
        System.out.println("Dog removed: " + dogs.remove());
    }

    public void dequeCat() {
        if (cats.isEmpty()) {
            System.out.println("No cat in shelter");
            return;
        }
        System.out.println("Cat removed: " + cats.remove());
    }
}
