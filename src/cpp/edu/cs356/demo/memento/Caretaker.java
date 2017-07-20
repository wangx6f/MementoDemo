package cpp.edu.cs356.demo.memento;

import cpp.edu.cs356.demo.Demo;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jason on 7/20/17.
 */
public class Caretaker {
    private Map<String, Memento> mementoMap;

    public Caretaker(){
        mementoMap = new Hashtable<>();
    }

    public void addMemento(String k, Demo d){
        Memento tempMomento = new Memento(d);
        mementoMap.put(k, tempMomento);
    }

    public Memento getMomento(String l){
        return mementoMap.get(l);
    }



}
