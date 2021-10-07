package jmart.goldenSample.controller;

import jmart.goldenSample.Algorithm;

import java.nio.file.FileAlreadyExistsException;

import org.springframework.web.bind.annotation.*;

import jmart.goldenSample.dataset.Account;
import jmart.goldenSample.dataset.Payment;
import jmart.goldenSample.dbjson.DBContainer;
import jmart.goldenSample.dbjson.JSONTable;
import jmart.goldenSample.dbjson.Serializable;

@RestController
@RequestMapping("/account")
class AccountController implements BasicGetController<Account>
{
	private final JSONTable<Account> table;
	
	public AccountController() throws FileAlreadyExistsException, ClassNotFoundException 
	{ table = DBContainer.fetch(Account.class, "account.json"); }
	
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
        	table.list.add(new Account(name, email, password));
        	table.write();
        	success = true;
        }
        catch (Throwable throwable) { throwable.printStackTrace(); }
    	return success;
    }
    
    @RequestMapping(value="/delete", method=RequestMethod.DELETE)
    boolean delete
    (
        @RequestParam int id,
        @RequestParam String password
    )
    {
        final int idx = Algorithm.<Account>findIndex(table.list, (e) -> e.id == id);
        if (idx == -1) return false;
        final Account object = table.list.get(idx);
        if (object.password.equals(password))
        {
        	table.list.remove(idx);
        	return true;
        }
        return false;
    }
}