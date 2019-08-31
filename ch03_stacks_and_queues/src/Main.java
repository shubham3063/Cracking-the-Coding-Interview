import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
//        ThreeInOne threeInOne = new ThreeInOne();
//        StackMin<Integer> stackMin = new StackMin<Integer>();
//        for (int i = 0; i < 20; i++) {
//            int queryId = random.nextInt(5);
//            int item = random.nextInt(10);
//            stackMin.run(queryId, item);
//        }

//        SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(5);
//        for (int i = 0; i < 20; i++) {
//            setOfStacks.push(random.nextInt(10));
//        }
//        for (int i = 0; i < 20; i++) {
//            System.out.print(setOfStacks.pop() + " ");
//        }

//        QueueViaStack<Integer> queueViaStack = new QueueViaStack<>();
//        for (int i = 0; i < 20; i++)
//            queueViaStack.add(random.nextInt(10));
//
//        for (int i = 0; i < 20; i++)
//            System.out.print(queueViaStack.remove() + " ");

//        SortStack sortStack = new SortStack();
//        for (int i = 0; i < 20; i++)
//            sortStack.push(random.nextInt(20));
//        sortStack.sort();


//        AnimalShelter animalShelter = new AnimalShelter();
//        for (int i = 0; i < 20; i++)
//            animalShelter.enqueue(random.nextInt(2));
//        for (int i = 0; i < 20; i++)
//            animalShelter.enqueue(random.nextInt(2));
//        for (int i = 0; i < 25; i++) {
//            animalShelter.dequeAny();
//            animalShelter.dequeDog();
//        }

        AnimalQueue animalQueue = new AnimalQueue();
        for (int i = 0; i < 20; i++) {
            int idx = random.nextInt(2);
            Animal a;
            if (idx == 0)
                a = new Dog("woof");
            else a = new Cat("meww");
            animalQueue.enqueue(a);
        }
        for (int i = 0; i < 20; i++) {
            int idx = random.nextInt(3);
            Animal a;
            if (idx == 0)
                a = animalQueue.dequeueDog();
            else if (idx == 1)
                a = animalQueue.dequeueCat();
            else
                a = animalQueue.dequeueAny();

            System.out.println("Animal is: " + a.name);
        }

    }
}
