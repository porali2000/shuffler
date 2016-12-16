package com.persist;

import com.dto.Dto;

/**
 * Created by Porali_S on 12/15/2016.
 */
public interface Put<T extends Dto> {
    boolean save(T dto);
}
