package cpp.edu.cs356.demo.memento;

import cpp.edu.cs356.demo.Demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jason on 7/20/17.
 */
public class Caretaker {
    private Set<Memento> mementolist;

    public Caretaker(){
        mementolist = new HashSet<>();
    }

    public void addMemento(Demo d){
        Memento tempMomento = new Memento(d);
        mementolist.add(tempMomento);
    }

    public Memento getMomento(){
        //TODO
        return null;
    }



}
