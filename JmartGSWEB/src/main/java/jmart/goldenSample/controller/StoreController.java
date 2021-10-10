package jmart.goldenSample.controller;

import java.nio.file.FileAlreadyExistsException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jmart.goldenSample.Algorithm;
import jmart.goldenSample.dataset.*;
import jmart.goldenSample.dataset.Invoice.Status;
import jmart.goldenSample.dbjson.*;

@RestController
@RequestMapping("/store")
class StoreController implements BasicGetController<Store>
{
	private JSONTable<Store> table;
	
	public StoreController() throws FileAlreadyExistsException, ClassNotFoundException 
	{ table = DBContainer.fetch(Store.class, "db/store.json"); }
	
	@Override
	public JSONTable<Store> getJSONTable() { return table; }
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	boolean create
    (
        @RequestParam String name,
        @RequestParam String address,
        @RequestParam String phoneNumber
    )
    {
		boolean success = false;
		try
		{
			final Store store = new Store(name, address, phoneNumber, 0);
			table.add(store);
			table.write();
			success = true;
		}
		catch (Throwable t) { t.printStackTrace(); } 
		return success;
    }
}
