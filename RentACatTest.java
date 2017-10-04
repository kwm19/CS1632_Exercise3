// Jonathan Kenneson & Kyle Monto
// jkenneson & kwm19
// CS1632 Exercise 3

import static org.junit.Assert.*;

import java.util.*;
import org.junit.*;
import org.mockito.*;

public class RentACatTest {

     public RentACat _rac;

     @Before
     public void setup(){
          this._rac = new RentACat();
     }

     // Testing functionality of listCats() method.
     // This test uses the happy path from the exercise description, using all
     // three cats from the README.md.
     @Test
     public void testListCats(){
          ArrayList<Cat> catList = new ArrayList<Cat>();
          Cat _c1 = Mockito.mock(Cat.class);
          Mockito.when(_c1.toString()).thenReturn("ID 1. Jennyanydots");
          Cat _c2 = Mockito.mock(Cat.class);
          Mockito.when(_c2.toString()).thenReturn("ID 2. Old Deuteronomy");
          Cat _c3 = Mockito.mock(Cat.class);
          Mockito.when(_c3.toString()).thenReturn("ID 3. Mistoffelees");
          catList.add(_c1);
          catList.add(_c2);
          catList.add(_c3);
          String result = _rac.listCats(catList);
          assertEquals("ID 1. Jennyanydots\nID 2. Old Deuteronomy\nID 3. Mistoffelees\n", result);
     }

     // Testing functionality of listCats() method.
     // This test creates a null arraylist and passes it into the listCats()
     // method, and should return a null value.
     @Test
     public void testListCatsNullList(){
          ArrayList<Cat> catList = null;
          String result = _rac.listCats(catList);
          assertEquals(null, result);
     }

     // Testing functionality of rentCat() method.
     // This test mocks a valid cat object and stubs its getRented() method
     // call, to simulate a cat that has been rented out.
     @Test
     public void testRentCatRented(){
          Cat _c1 = Mockito.mock(Cat.class);
          Mockito.when(_c1.getRented()).thenReturn(true);
          boolean result = _rac.rentCat(_c1);
          assertFalse(result);
     }

     // Testing functionality of rentCat() method.
     // This test mocks a valid cat object and stubs its getRented() method
     // call, to simulate a cat that has not been rented out.
     @Test
     public void testRentCatNotRented(){
          Cat _c1 = Mockito.mock(Cat.class);
          Mockito.when(_c1.getRented()).thenReturn(false);
          boolean result = _rac.rentCat(_c1);
          assertTrue(result);
     }

     // Testing functionality for catExists() method.
     // This test ensures that if a cat is present in the given ArrayList
     // along with the ID provided, then the method will return a boolean value
     // of true.
     @Test
     public void testCatExistsPresent(){
          ArrayList<Cat> catList = new ArrayList<Cat>();
          Cat _c1 = Mockito.mock(Cat.class);
          Mockito.when(_c1.getId()).thenReturn(1);
          Cat _c2 = Mockito.mock(Cat.class);
          Mockito.when(_c2.getId()).thenReturn(2);
          Cat _c3 = Mockito.mock(Cat.class);
          Mockito.when(_c3.getId()).thenReturn(3);
          catList.add(_c1);
          catList.add(_c2);
          catList.add(_c3);
          boolean result = _rac.catExists(2, catList);
          assertTrue(result);
     }

     // Testing functionality for catExists() method.
     // This test ensures that if a cat is not present in the given ArrayList
     // along with the ID provided, then the method will return a boolean value
     // of false.
     @Test
     public void testCatExistsNotPresent(){
          ArrayList<Cat> catList = new ArrayList<Cat>();
          Cat _c1 = Mockito.mock(Cat.class);
          Mockito.when(_c1.getId()).thenReturn(1);
          Cat _c2 = Mockito.mock(Cat.class);
          Mockito.when(_c2.getId()).thenReturn(2);
          Cat _c3 = Mockito.mock(Cat.class);
          Mockito.when(_c3.getId()).thenReturn(3);
          catList.add(_c1);
          catList.add(_c2);
          catList.add(_c3);
          boolean result = _rac.catExists(0, catList);
          assertFalse(result);
     }

     // Testing functionality of returnCat() method.
     // This test mocks a valid cat object and stubs its getRented() method
     // call, to simulate a cat that has been rented out.
     @Test
     public void testReturnCatRented(){
          Cat _c1 = Mockito.mock(Cat.class);
          Mockito.when(_c1.getRented()).thenReturn(true);
          boolean result = _rac.returnCat(_c1);
          assertTrue(result);
     }

     // Testing functionality of returnCat() method.
     // This test mocks a valid cat object and stubs its getRented() method
     // call, to simulate a cat that has not been rented out.
     @Test
     public void testReturnCatNotRented(){
          Cat _c1 = Mockito.mock(Cat.class);
          Mockito.when(_c1.getRented()).thenReturn(false);
          boolean result = _rac.returnCat(_c1);
          assertFalse(result);
     }
}
