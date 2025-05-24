package Controller;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.Iterator;
import java.util.List;

public class iterator implements Iterator<GameObject> {

    List<GameObject> list;
    private int loopCounter=0;

    public iterator(List<GameObject> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (loopCounter< list.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public GameObject next() {
        return list.get(loopCounter++);
    }
}
