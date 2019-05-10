package pl.edu.agh.mwo;

import java.util.*;

public class TripManager {

    private HashMap<String, Trip> tripList;

    public TripManager() {
        tripList = new HashMap<>();
    }

    public void add(Trip trip) throws TripAlreadyExistsException {
        if (tripList.get(trip.getName()) != null) {
            throw new TripAlreadyExistsException();
        } else {
            tripList.put(trip.getName(), trip);
        }
    }

    public HashMap<String, Trip> getTrips() {
        return tripList;
    }

    public List<Trip> searchForTrip(String searchKey) {
        List<Trip> trips;
        if (searchKey.equals("")) {
            trips = (List<Trip>) tripList.values();
        } else {
            trips = new ArrayList<>();
            for (Trip trip : tripList.values()) {

                if (trip.getName().contains(searchKey)) {
                    trips.add(trip);
                }
            }
            for (Trip trip : tripList.values()) {

                if (trip.getDescription().contains(searchKey)) {
                    trips.add(trip);
                }
            }
            for (Trip trip : tripList.values()) {
                Set<Photo> photos = trip.getPhotos();
                for (Photo photo : photos) {
                    if (photo.getComment().contains(searchKey)) {
                        trips.add(trip);
                    }
                }
            }
        }
        if (trips.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return trips;
        }

    }

    public void remove(String name) {
        tripList.remove(name);
    }

}
