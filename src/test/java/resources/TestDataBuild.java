package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.List;

public class TestDataBuild {

    public AddPlace getAddPlacePayload(String name, String language, String address) {
        List<String> types = List.of("museum", "gallery");
        Location location = new Location();
        location.setLat(35.12345);
        location.setLng(-20.98765);
        AddPlace addPlace = new AddPlace();
        addPlace.setLocation(location);
        addPlace.setAccuracy(5);
        addPlace.setName(name);
        addPlace.setPhone_number("+381 11 2433 886");
        addPlace.setAddress(address);
        addPlace.setTypes(types);
        addPlace.setWebsite("https://tesla-museum.org/");
        addPlace.setLanguage(language);
        return addPlace;
    }



}
