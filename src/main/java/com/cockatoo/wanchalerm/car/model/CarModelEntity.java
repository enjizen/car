/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cockatoo.wanchalerm.car.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author wanchalermyuphasuk
 */
@Entity
@Table(name = "car_model")
@Data
public class CarModelEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name_thai")
    private String nameThai;
    @Column(name = "name_eng")
    private String nameEng;
    @JoinColumn(name = "car_brand_id", referencedColumnName = "id")
    @ManyToOne
    private CarBrandEntity carBrandId;

}
