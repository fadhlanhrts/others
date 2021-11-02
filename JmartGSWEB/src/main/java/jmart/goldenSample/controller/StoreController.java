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
	@JSONDBContainer(value=Store.class, filepath="db/store.json")
	public static JSONTable<Store> storeTable;
	
	@Override
	public JSONTable<Store> getJSONTable() { return storeTable; }
	
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
			storeTable.add(store);
			success = true;
		}
		catch (Throwable t) { t.printStackTrace(); } 
		return success;
    }
}
