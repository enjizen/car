package com.cockatoo.wanchalerm.car.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author wanchalermyuphasuk
 */

@Data
@Entity
@Table(name = "car_type", catalog = "car")
public class CarType implements Serializable {

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

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @OneToMany(mappedBy = "carTypeId", fetch = FetchType.LAZY)
    private List<CarBrand> carBrandList;
}
