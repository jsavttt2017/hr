package cn.mldn.service.junit;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import cn.mldn.factory.DAOFactory;
import cn.mldn.service.Factory.ServiceFactory;

public class IAreaServiceTest {

	@Test
	public void testList() {
		try {
			TestCase.assertTrue(ServiceFactory.getIAreaServiceInstance().list().size()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
