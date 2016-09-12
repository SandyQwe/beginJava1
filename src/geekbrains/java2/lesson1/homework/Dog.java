package geekbrains.java2.lesson1.homework;

class Dog extends Animal {
    public Dog(String name) {
        this.name = name;
        this.type = "Dog";
        this.maxSwimDistance = 20.0f;
        this.maxJumpHeight = 1.5f;
        this.maxRunDistance = 1500.0f;
        onDistance = true;
    }
}
