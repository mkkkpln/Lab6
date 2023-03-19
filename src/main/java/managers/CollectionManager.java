package managers;

import data.HumanBeing;

import java.time.LocalDate;
import java.util.HashMap;

public class CollectionManager {
    private HashMap<Long, HumanBeing> people;
    private final LocalDate creationDate = LocalDate.now();

    public CollectionManager(){
        people = new HashMap<>();
    }

    public HashMap<Long, HumanBeing> getPeople() {
        return people;
    }

    public void setHuman(HashMap<Long, HumanBeing> people) {
        this.people = people;
    }
    public void clearAllPeople() {
        people.clear();
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public HumanBeing findByKey(Long key){
        return this.people.get(key);
    }

    public void addPerson(HumanBeing human){
        if(findByKey(human.getId()) == (null)){
            this.people.put(human.getId(), human);
        }
    }

    public boolean removeByKeyBool(Long key){
        HumanBeing human = findByKey(key);
        if (key != null){
            return this.people.remove(key, human);
        }
        return  false;
    }

    public void removeById(Long key){
        this.people.remove(key);
    }


    @Override
    public String toString() {
        String answer = "";
        int counter = 1;
        for(HashMap.Entry<Long, HumanBeing> entry : this.people.entrySet()){
            Long key = entry.getKey();
            HumanBeing human  = entry.getValue();
            answer += String.format("Элемент номер : %d\n", counter);
            counter++;
            answer += String.format("Key : %s\n",key.toString());
            answer += String.format(human.toString()+"\n\n");
        }
        return answer;
    }
}
