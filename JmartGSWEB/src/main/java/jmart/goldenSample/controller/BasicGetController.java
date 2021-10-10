package jmart.goldenSample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;


import jmart.goldenSample.*;
import jmart.goldenSample.dataset.*;
import jmart.goldenSample.dbjson.JSONTable;
import jmart.goldenSample.dbjson.Serializable;

@SuppressWarnings("unchecked")
public interface BasicGetController<T extends Serializable>
{
    JSONTable<T> getJSONTable();
    
    public default int getPageSize() { return 5; }
    
    @RequestMapping(value="/page/{page}", method=RequestMethod.GET)
    public default List<T> getPage(@PathVariable int page)
    {
        final JSONTable<T> table = getJSONTable();
        final ArrayList<T> pageList = new ArrayList<>(getPageSize());
        for (int i = getPageSize() * page; i < table.size(); ++i)
        	pageList.add(table.get(i));
        return pageList;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public default T getById(@PathVariable int id)
    {
        return Algorithm.<T>find(getJSONTable(), (e) -> e.id == id);
    }
}
