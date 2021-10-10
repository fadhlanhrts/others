package jmart.goldenSample.controller;

import jmart.goldenSample.Algorithm;

import java.nio.file.FileAlreadyExistsException;

import org.springframework.web.bind.annotation.*;

import jmart.goldenSample.dataset.*;
import jmart.goldenSample.dataset.Invoice.Status;
import jmart.goldenSample.dbjson.*;

@RestController
@RequestMapping("/account")
class AccountController implements BasicGetController<Account>
{
	private final JSONTable<Account> table;
	
	public AccountController() throws FileAlreadyExistsException, ClassNotFoundException 
	{ table = DBContainer.fetch(Account.class, "db/account.json"); }
	
    @Override
    public JSONTable<Account> getJSONTable() { return table; }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    boolean register
    (
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String password
    )
    {
    	boolean success = false;
        try
        { 
        	table.add(new Account(name, email, password, 0));
        	table.write();
        	success = true;
        }
        catch (Throwable throwable) { throwable.printStackTrace(); }
    	return success;
    }
}