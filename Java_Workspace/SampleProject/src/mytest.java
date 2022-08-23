import static org.junit.Assert.*;

import newpack.myclass;

import org.junit.Test;


public class mytest {

	@Test
	public void test() {
		myclass obj = new myclass();
		int ans = obj.add(1, 2);
		assertEquals(3, ans);
	}

}
