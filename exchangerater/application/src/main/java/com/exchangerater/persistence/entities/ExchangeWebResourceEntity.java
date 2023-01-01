package com.exchangerater.persistence.entities;

import com.exchangerater.persistence.entities.base.BaseEntity;
import com.exchangerater.webscraper.utils.DbFieldConstraints;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "exchange_web_resource")
public class ExchangeWebResourceEntity implements BaseEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "name", nullable = false, length = DbFieldConstraints.LENGTH_20)
    private String name;

    @Column(name = "active")
    private boolean active;
}
