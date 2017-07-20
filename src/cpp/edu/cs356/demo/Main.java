package cpp.edu.cs356.demo;

import cpp.edu.cs356.demo.memento.Caretaker;

public class Main {

    public static void main(String[] args)
    {

        Caretaker caretaker = new Caretaker();
        Demo demo = new Demo(caretaker);

    }
	
}
