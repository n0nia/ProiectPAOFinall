package readwrite.read;

import com.opencsv.CSVReader;
import models.Actor;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//import static org.graalvm.compiler.options.OptionType.User;

public class ActorReader extends Reader<Actor> {

    private static List<Actor> actorList = new ArrayList<>();

    public static void readData() {

        ActorReader actorReader = new ActorReader();

        actorList = actorReader.readAndCreateObjects(
                "F:\\FMI\\Anul_II\\Sem_2\\PAO\\Proiect-PAO-master\\src\\readwrite\\resources\\Actors.csv");

        for (Actor actor : actorList) {
            System.out.println(actor);
        }
    }

    public static List<Actor> getClientList() {
        return Collections.unmodifiableList(actorList);
    }

    @Override
    Actor createObject(String[] objectDetails) {
        return new Actor(objectDetails[0], objectDetails[1], Integer.parseInt(objectDetails[2]), Integer.parseInt(objectDetails[3]),
                Integer.parseInt(objectDetails[4]), objectDetails[5]);
    }
}