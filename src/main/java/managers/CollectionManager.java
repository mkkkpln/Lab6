package managers;

import data.HumanBeing;

import java.util.HashMap;

public class CollectionManager {
    private HashMap<Integer, HumanBeing> human;

    public  CollectionManager(){
        human = new HashMap<>();
    }

    public HashMap<Integer, HumanBeing> getHuman() {

        return human;
    }

    public void setHuman(HashMap<Integer, HumanBeing> human) {

        this.human = human;
    }
    public void clearAllPeople() {
        human.clear();
    }
}
