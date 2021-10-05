package jmart.goldenSample.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import jmart.goldenSample.*;
import jmart.goldenSample.dataset.*;

public interface BasicGetController<T extends Serializable>
{
    JSONTable<T> getJSONTable();

    @RequestMapping(value="/page/{page}", method=RequestMethod.GET)
    public default ArrayList<T> getPage(@PathVariable int page)
    {
        return null;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public default T getById(@PathVariable int id)
    {
        final ArrayList<T> table = getJSONTable().table;
        return Algorithm.<T>find(table, (e) -> e.id == id);
    }
}
