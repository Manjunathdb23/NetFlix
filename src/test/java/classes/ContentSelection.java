package classes;

import org.testng.annotations.Test;

import pages.driverClass;

public class ContentSelection extends driverClass {
	
	@Test(dependsOnMethods = "generPick")
	public void contentrail() throws InterruptedException
	{
		
		sn.selectitem();
	}
	
	@Test(dependsOnMethods = "contentrail")
		public void contentSelection() throws InterruptedException {
			sn.addToWatchlist();
		}
	}
	
	

