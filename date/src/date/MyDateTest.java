package date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import org.junit.Test;

public class MyDateTest {


  /**
   * Test method for {@link MyDate#getDay()}.
   */
  @Test
  public void testGetDay() {
    MyDate d = new MyDate(31, 12, 2006);
    assertEquals(31, d.getDay());
	d = new MyDate(1, 1, 2000);
	assertTrue("Le jour devrait être 1", d.getDay() == 1);
	d = new MyDate(10, 5, 2000);
	MyDate dp = d;
	assertFalse("Les jours devrait être égaux", d.getDay() != dp.getDay());
  }

  /**
   * Test method for {@link MyDate#getMonth()}.
   */
  @Test
  public void testGetMonth() {
    MyDate d = new MyDate(31, 12, 2006);
    assertEquals(12, d.getMonth());
	d = new MyDate(1, 1, 2000);
	assertTrue("Le mois devrait être 1", d.getMonth() == 1);
	d = new MyDate(10, 5, 2000);
	MyDate dp = d;
	assertFalse("Les mois devrait être égaux", d.getMonth() != dp.getMonth());
  }

  /**
   * Test method for {@link MyDate#getYear()}.
   */
  @Test
  public void testGetYear() {
    MyDate d = new MyDate(31, 12, 2006);
    assertEquals(2006, d.getYear());
	d = new MyDate(1, 1, 2000);
	assertTrue("L'année devrait être 2000", d.getYear() == 2000);
	d = new MyDate(10, 5, 2000);
	MyDate dp = d;
	assertFalse("Les année devrait être égaux", d.getYear() != dp.getYear());
  }

  /**
   * Test method for {@link MyDate#checkData()} .
   */
  @Test
  public void testCheckData() {
	MyDate d = new MyDate(1, 1, 2006);
	assertTrue("01/01/2006 est valide", d.checkData());
	d = new MyDate(31, 12, 2006);
	assertTrue("31/12/2006 est valide", d.checkData());
	d = new MyDate(29, 2, 2004);
	assertTrue("29/02/2004 est valide", d.checkData());
	d = new MyDate(29, 2, 2006);
	assertFalse("29/02/2006 n'est pas valide", d.checkData());
	d = new MyDate(0, 3, 2006);
	assertFalse("00/03/2006 n'est pas valide", d.checkData());
	d = new MyDate(31, 11, 2006);
	assertFalse("31/11/2006 n'est pas valide", d.checkData());
  }

  /**
   * Test simple valid dates
   */
  @Test
  public void testSimpleValidDates() {
    boolean b = MyDate.isValidDate(1, 1, 2000);
    assertTrue("1/1/2000 est valide", b);
    b = MyDate.isValidDate(25, 12, 2000);
    assertTrue("25/12/2000 est valide", b);
	b = MyDate.isValidDate(12, 4, 0);
    assertTrue("12/04/0000 est valide", b);
  }

  /**
   * Test simple invalid dates
   */
  @Test
  public void testSimpleInvalidDates() {
    boolean b = MyDate.isValidDate(0, 1, 2000);
    assertFalse("0 est invalide pour le jour", b);
    b = MyDate.isValidDate(32, 12, 2000);
    assertFalse("32/12/2000 n'est pas valide", b);
	b = MyDate.isValidDate(31, 0, 2000);
    assertFalse("0 est invalide pour le mois", b);
	b = MyDate.isValidDate(1, 13, 2000);
    assertFalse("01/13/2000 n'est pas valide", b);
  }

  /**
   * Test valid limit dates
   */
  @Test
  public void testValidLimitDates() {
    boolean b = MyDate.isValidDate(31, 1, 2000);
    assertTrue("31 janvier est une date valide", b);
	b = MyDate.isValidDate(30, 11, 2000);
    assertTrue("30/11/2000 est valide", b);
	b = MyDate.isValidDate(31, 5, 2000);
    assertTrue("31/04/2000 est valide", b);
	b = MyDate.isValidDate(1, 9, 2000);
    assertTrue("01/09/2000 est valide", b);
  }

  /**
   * Test invalid limit dates
   */
  @Test
  public void testInvalidLimitDates() {
    boolean b = MyDate.isValidDate(31, 4, 2000);
    assertFalse("31 avril est une date invalide", b);
    b = MyDate.isValidDate(0, 12, 2000);
    assertFalse("0/12/2000 n'est pas valide", b);
	b = MyDate.isValidDate(32, 1, 2000);
    assertFalse("32/01/2000 n'est pas valide", b);
	b = MyDate.isValidDate(32, 13, 2000);
    assertFalse("32/13/2000 n'est pas valide", b);
  }

  /**
   * Test February valid limit dates
   */
  @Test
  public void testFebruaryValidLimitDates() {
    boolean b = MyDate.isValidDate(29, 2, 2000);
    assertTrue("29 fevrier 2000 est une date valide", b);
	b = MyDate.isValidDate(28, 2, 2001);
    assertTrue("28/02/2001 est valide", b);
	b = MyDate.isValidDate(28, 2, 0);
    assertTrue("29/02/0000 est valide", b);
  }

  /**
   * Test February invalid limit dates
   */
  @Test
  public void testFebruaryInvalidLimitDates() {
    boolean b = MyDate.isValidDate(29, 2, 2001);
    assertFalse("29 fevrier 2001 est une date invalide", b);
	b = MyDate.isValidDate(29, 2, 2001);
    assertFalse("29/02/2001 n'est pas valide", b);
	b = MyDate.isValidDate(30, 2, 0);
    assertFalse("29/02/0000 n'est pas valide", b);
  }

  /**
   * Test method for {@link MyDate#equals()}.
   */
  @Test
  public void testEquals() {
	MyDate d = new MyDate(24, 5, 2004);
	MyDate dp = new MyDate(24, 5, 2004);
	assertTrue(d.equals(dp));
  }
  
  /**
   * Test method for {@link MyDate#nextDay()}.
   */
  @Test
  public void testNextDay() {
	MyDate d = new MyDate(24, 5, 2004);
	MyDate dp = new MyDate(25, 5, 2004);
	assertTrue(d.nextDay().equals(dp));
	d = new MyDate(28, 2, 2001);
	dp = new MyDate(1, 3, 2001);
	assertTrue(d.nextDay().equals(dp));
	d = new MyDate(31, 12, 2001);
	dp = new MyDate(1, 1, 2002);
	assertTrue(d.nextDay().equals(dp));
  }
}
