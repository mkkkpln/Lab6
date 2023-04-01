package utils;

import data.Car;
import data.Coordinates;
import data.HumanBeing;
import data.Mood;
import managers.CollectionManager;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditUtil {
    private static final char maxLetter = 0x7a; // Максимальное значение, которое допустимо при вводе слова (код таблицы ASCII)
    private static final char minLetter = 0x41; // Минимальное значение, которое допустимо при вводе слова (код таблицы ASCII)


    public static Long keyParser(String word, Environment environment) throws WrongIdException, NumberFormatException {
        Long key = 0L;
        try {
            key = Long.parseLong(word);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        if(environment.getCollectionManager().findByKey(key)==null){
            throw new WrongIdException();
        }
        return key;
    }


    public static String nameParser(String name) throws WrongNameException {
        char[] chars = new char[name.length()];

        for (int i = 0; i <chars.length ; i++) {
            chars[i] = name.charAt(i);
            if(((chars[i]< minLetter) && (chars[i] > maxLetter) && (chars[i]!=' ')) ){
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

    public static CollectionManager XMLParser(String link) throws ParserConfigurationException, IOException, SAXException {
        class Box{
            public long variable = 0;
            public Box(long variable){
                this.variable = variable;
            }
        }
        Box box = new Box(0);
        CollectionManager collectionManager = new CollectionManager();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File(link));
        doc.getDocumentElement().normalize();
        NodeList all = doc.getElementsByTagName("entry");
        for (int count = 0; count < all.getLength(); count++) {
            Node first = doc.getElementsByTagName("entry").item(count);
            HumanBeing humanBeing = new HumanBeing();
            Car car = new Car();
            NodeList nodeList = first.getChildNodes();
            int n = nodeList.getLength();
            Node current;
            for (int i = 0; i < n; i++) {

                Coordinates coordinates = new Coordinates(0f, 0);
                current = nodeList.item(i);
                if (current.getNodeType() == Node.ELEMENT_NODE) {
                    switch (current.getNodeName()) {
                        case "key":
                            box.variable = Long.parseLong(current.getTextContent());
                            break;
                        case "value":
                            NodeList inner = current.getChildNodes();
                            Node parameters;
                            for (int j = 0; j < inner.getLength(); j++) {
                                parameters = inner.item(j);
                                if (parameters.getNodeType() == Node.ELEMENT_NODE) {
                                    if (parameters.getNodeType() == Node.ELEMENT_NODE) {
                                        switch (parameters.getNodeName()) {
                                            case "name":
                                                String name = parameters.getTextContent();
                                                humanBeing.setName(name);
                                                break;
                                            case "id":
                                                Long id = Long.parseLong(parameters.getTextContent());
                                                humanBeing.setId(id);
                                                break;
                                            case "mood":
                                                Mood mood = Mood.valueOf(parameters.getTextContent());
                                                humanBeing.setMood(mood);
                                                break;
                                            case "realHero":
                                                boolean flag = Boolean.parseBoolean(parameters.getTextContent());
                                                humanBeing.setRealHero(flag);
                                                break;
                                            case "coordinates":
                                                NodeList coordinateChildren = parameters.getChildNodes();

                                                for (int t = 0; t < coordinateChildren.getLength(); t++) {
                                                    Node variable = coordinateChildren.item(t);
                                                    if (variable.getNodeType() == Node.ELEMENT_NODE) {
                                                        switch (variable.getNodeName()) {
                                                            case "x":
                                                                float x = Float.parseFloat(variable.getTextContent());
                                                                coordinates.setX(x);
                                                                break;
                                                            case "y":
                                                                int y = Integer.parseInt(variable.getTextContent());
                                                                coordinates.setY(y);
                                                                break;
                                                            default:
                                                                break;
                                                        }
                                                    }
                                                }
                                                break;
                                            case "impactSpeed":
                                                float speed = Float.parseFloat(parameters.getTextContent());
                                                humanBeing.setImpactSpeed(speed);
                                                break;
                                            case "soundtrackName":
                                                humanBeing.setSoundtrackName(parameters.getTextContent());
                                                break;
                                            case "hasToothpick":
                                                humanBeing.setHasToothpick(Boolean.parseBoolean(parameters.getTextContent()));
                                                break;
                                            case "minutesOfWaiting":
                                                humanBeing.setMinutesOfWaiting(Float.parseFloat(parameters.getTextContent()));
                                                break;
                                            case "creationDate":
                                                humanBeing.setCreationDate(LocalDate.parse(parameters.getTextContent(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                                                break;
                                            case "car":

                                                NodeList carChildren = parameters.getChildNodes();
                                                for (int t = 0; t < carChildren.getLength(); t++) {
                                                    Node variable = carChildren.item(t);
                                                    if (variable.getNodeType() == Node.ELEMENT_NODE) {
                                                        switch (variable.getNodeName()) {
                                                            case "cool":
                                                                boolean cool = Boolean.parseBoolean(variable.getTextContent());
                                                                car.setCool(cool);
                                                                break;
                                                            case "name":
                                                                car.setName(variable.getTextContent());
                                                                break;
                                                            default:
                                                                break;
                                                        }
                                                    }
                                                }
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                            }
                            humanBeing.setCoordinates(coordinates);
                            humanBeing.setCar(car);
                            collectionManager.getPeople().put(box.variable, humanBeing);
                            break;
                    }
                }
            }
        }
        return collectionManager;
    }
}

