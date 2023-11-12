package resources;

public enum ApiResources {

    AddPlaceAPI("/maps/api/place/add/json"),
    GetPlaceAPI("/maps/api/place/get/json"),
    DeletePlaceAPI("/maps/api/place/delete/json");

    public String resource;

    ApiResources(String resource) {
        this.resource = resource;
    }

    public String getApiResource() {
        return resource;
    }



}
