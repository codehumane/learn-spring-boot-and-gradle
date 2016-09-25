package com.codehumane.domain.item;

import com.codehumane.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
