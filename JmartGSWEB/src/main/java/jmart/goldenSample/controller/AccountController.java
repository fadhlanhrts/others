package jmart.goldenSample.controller;

import jmart.goldenSample.Algorithm;
import jmart.goldenSample.dataset.Serializable;
import org.springframework.web.bind.annotation.*;

import jmart.goldenSample.dataset.Account;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static JSONTable<Account> table;

    public AccountController()
    {
        try {
            table = JSONTable.createFromFile(Account.class, "account.json");
            final Account accountMaxId = Algorithm.max(table.table);
            Serializable.setClosingId(Account.class, accountMaxId.id);
        }
        catch (Throwable throwable) { System.err.println(throwable); }
    }

    @Override
    public JSONTable<Account> getJSONTable() { return table; }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public boolean register
    (
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String password
    )
    {
    	table.table.add(new Account(name, email, password));
        try { table.write(); }
        catch (Throwable throwable) { throwable.printStackTrace(); }
    	return true;
    }
    
    @RequestMapping(value="/delete", method=RequestMethod.DELETE)
    public boolean delete
    (
        @RequestParam int id,
        @RequestParam String password
    )
    {
        int idx = Algorithm.<Account>findIndex(table.table, (e) -> e.id == id);
        if (idx != -1)
        {
            Account object = table.table.get(idx);
            if (object.password.equals(password))
            {
                table.table.remove(idx);
                return true;
            }
        }
        return false;
    }
}