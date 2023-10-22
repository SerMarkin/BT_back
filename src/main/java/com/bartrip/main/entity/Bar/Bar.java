package com.bartrip.main.entity.Bar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bartrip.main.entity.BaseModel.BaseModel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bars")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Bar extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_enable")
    private boolean isEnable;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "name_location")
    private String nameLocation;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;
}