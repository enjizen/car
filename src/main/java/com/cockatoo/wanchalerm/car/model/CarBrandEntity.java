package com.cockatoo.wanchalerm.car.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author wanchalermyuphasuk
 */
@Data
@Entity
@Table(name = "car_brand", catalog = "car")
public class CarBrandEntity implements Serializable {

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

    @Column(name = "car_type_id")
    private Integer carTypeId;
}
