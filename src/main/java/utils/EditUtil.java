package utils;

public class EditUtil {
    public static Long keyParser(String word, Environment environment) throws WrongIdException, NumberFormatException {
        Long key = 0L;
        //aboba
        try {
            key = Long.parseLong(word);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        if(environment.getCollectionManager().findByKey(key)==null){
            return key;
        }
        throw new WrongIdException();
    }


    public static String nameParser(){
        return " ";
    }


    public static boolean realHeroParser(String word) throws WrongHeroException {
        boolean answer;
        word = word.trim();
        if(word.equals("yes")){
            return true;
        }
        if(word.equals("no")){
            return false;
        }
        throw new WrongHeroException();
    }
}

