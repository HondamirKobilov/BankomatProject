package com.example.bankomatbeckend.Entity.Abstrakt;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public  abstract class Absrakt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedBy
    private Integer kimTomonidanYaratilgan;

    @LastModifiedBy
    private Integer kimTomonidanTahrirlangan;

    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp yaratilganVaqt;

    @Column(nullable = false)
    @UpdateTimestamp
    private Timestamp tahrirlanganVaqt;


}
