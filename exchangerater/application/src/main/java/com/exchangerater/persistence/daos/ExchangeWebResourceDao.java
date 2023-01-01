package com.exchangerater.persistence.daos;

import com.exchangerater.persistence.daos.base.BaseDao;
import com.exchangerater.persistence.entities.ExchangeWebResourceEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ExchangeWebResourceDao extends BaseDao<ExchangeWebResourceEntity> {

    @Override
    protected Class<ExchangeWebResourceEntity> initTypeParamerterClass() {
        return ExchangeWebResourceEntity.class;
    }

    public List<ExchangeWebResourceEntity> getAllActiveResources() {
        return null;
    }
}
