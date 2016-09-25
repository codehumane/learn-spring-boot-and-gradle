package com.woowahan.domain.item;

import domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by chogh on 9/23/16.
 */
@Entity
public class Item extends BaseEntity {

    @Setter
    @Getter
    @Column(nullable = false)
    private String name;

}
