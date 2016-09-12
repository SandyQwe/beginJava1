package geekbrains.java2.lesson1.homework;

class Cat extends Animal {
    public Cat(String name) {
        this.name = name;
        this.type = "Cat";
        this.maxSwimDistance = 0.0f;
        this.maxJumpHeight = 3.0f;
        this.maxRunDistance = 500.0f;
        onDistance = true;
    }
}
