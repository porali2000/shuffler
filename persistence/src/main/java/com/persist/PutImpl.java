package com.persist;

import com.db.DB;
import com.dto.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Porali_S on 12/15/2016.
 */
@Component
public class PutImpl<T extends Dto> implements Put<T> {


    @Autowired
    DB database;

    public boolean save(T dto){

        if(null == dto) {
            return false;
        }
        database.write(dto);
        return true;
    }
}
