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
	@JSONDBContainer(value=Account.class, filepath="db/account.json")
	public static JSONTable<Account> accountTable;
	
    @Override
    public JSONTable<Account> getJSONTable() { return accountTable; }

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
        	accountTable.add(new Account(name, email, password, 0));
        	success = true;
        }
        catch (Throwable throwable) { throwable.printStackTrace(); }
    	return success;
    }
}