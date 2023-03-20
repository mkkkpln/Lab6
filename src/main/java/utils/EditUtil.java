package utils;

public class EditUtil {
    public static Long keyParser(String word, Environment environment) throws WrongIdException, NumberFormatException {
        Long key = 0L;
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


    public static String nameParser(String name) throws WrongNameException {
        char[] chars = new char[name.length()];

        for (int i = 0; i <chars.length ; i++) {
            chars[i] = name.charAt(i);
            if((chars[i]<0x41 && chars[i]>0x7a && chars[i]!=' ') ){
                throw new WrongNameException();
            }
        }
        return name;
    }


    public static boolean boolParser(String word) throws WrongHeroException {
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

