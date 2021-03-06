package pl.edu.agh.mwo;

import java.util.NoSuchElementException;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TripManagerTest {

    public TripManagerTest() {
    };
    
    
    Photo p;
    TripManager tripManager;
    Trip trip;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws TripAlreadyExistsException {
        trip = new Trip("Tatry 2019", "Wycieczka w Tatry organizowana przez biuro turystyczne 'W��czykij'");
        trip.setName("Tatry 2019");
        trip.setDescription("Wycieczka w Tatry organizowana przez biuro turystyczne 'W��czykij'");
        
        p = new Photo("Tatry o zachodzie s�o�ca");
        p.setComment("Tatry o zachodzie s�o�ca");
        tripManager = new TripManager();

    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAdd() throws TripAlreadyExistsException {
        Assert.assertEquals(0, tripManager.getTrips().size());
        tripManager.add(trip);
        Assert.assertEquals(1, tripManager.getTrips().size());
    }

    @Test(expected = TripAlreadyExistsException.class)
    public void testAddTripTwice() throws TripAlreadyExistsException {
        Assert.assertEquals(0, tripManager.getTrips().size());
        tripManager.add(trip);
        Assert.assertEquals(1, tripManager.getTrips().size());
        tripManager.add(trip);
    }

    @Test
    public void testRemoveTripByName() throws Exception {
        tripManager.add(trip);
        Assert.assertEquals(1, tripManager.getTrips().size());
        tripManager.remove(trip.getName());
        Assert.assertEquals(0, tripManager.getTrips().size());
    }

    @Test
    public void searchForTripTest() throws TripAlreadyExistsException {
        trip.addPhoto(p);
        tripManager.add(trip); //we added only 1 trip to this manager, so there is 1 trip with 1 photo

        Assert.assertEquals(1, tripManager.searchForTrip("").size());
        Assert.assertEquals(1, tripManager.searchForTrip("Tatry").size());
        Assert.assertEquals(1, tripManager.searchForTrip("W��czykij").size());
        Assert.assertEquals(1, tripManager.searchForTrip("zachodzie").size()); 
    }
    
    @Test(expected = NoSuchElementException.class)
    public void searchForTripInEmptyTripManagerExceptionCatch(){
        tripManager.getTrips().clear();
        tripManager.searchForTrip("");
    }
}
