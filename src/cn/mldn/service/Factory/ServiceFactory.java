package cn.mldn.service.Factory;

import cn.mldn.service.IAreaService;
import cn.mldn.service.IAreaplusService;
import cn.mldn.service.impl.AreaServiceImpl;
import cn.mldn.service.impl.AreaplusServiceImpl;

public class ServiceFactory {
	public static IAreaService getIAreaServiceInstance(){
		return new AreaServiceImpl();
	}
	public static IAreaplusService getIAreaplusServiceInstance(){
		return new AreaplusServiceImpl();
	}
}
