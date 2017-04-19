package com.model;

import kr.co.aim.nanoframe.orm.info.DataInfo;
import kr.co.aim.nanoframe.orm.info.access.UdfAccessor;
import kr.co.aim.nanotrack.durable.management.data.DurableKey;

import java.sql.Timestamp;

/**
 * Created by admin on 2017/2/14.
 */
public class Durable extends UdfAccessor //implements DataInfo<DurableKey>
{
//    private DurableKey	key;

    public String getDurableName() {
        return durableName;
    }

    public void setDurableName(String durableName) {
        this.durableName = durableName;
    }

    private String durableName;

    private String		durableType;

    private String		durableSpecName;

    private String		durableSpecVersion;

    private String		materialLocationName;

    private String		transportGroupName;

    private double		timeUsedLimit;

    private double		durationUsedLimit;

    private double		timeUsed;

    private double		durationUsed;

    private long		capacity;

    private long		lotQuantity;

    private String		factoryName;

    private String		areaName;

    private String		durableState;

    private String		durableCleanState;

    private String		lastEventName;

    private String		lastEventTimeKey;

    private Timestamp	lastEventTime;

    private String		lastEventUser;

    private String		lastEventComment;

    private String		lastEventFlag;

    private Timestamp	createTime;

    private String		createUser;

    private String		reasonCodeType;

    private String		reasonCode;

    public Durable()
    {
    }

//    public DurableKey getKey()
//    {
//        return this.key;
//    }
//
//    public void setKey(DurableKey key)
//    {
//        this.key = key;
//    }

    public String getDurableType()
    {
        return this.durableType;
    }

    public void setDurableType(String durableType)
    {
        this.durableType = durableType;
    }

    public String getDurableSpecName()
    {
        return this.durableSpecName;
    }

    public void setDurableSpecName(String durableSpecName)
    {
        this.durableSpecName = durableSpecName;
    }

    public String getDurableSpecVersion()
    {
        return this.durableSpecVersion;
    }

    public void setDurableSpecVersion(String durableSpecVersion)
    {
        this.durableSpecVersion = durableSpecVersion;
    }

    public String getMaterialLocationName()
    {
        return this.materialLocationName;
    }

    public void setMaterialLocationName(String materialLocationName)
    {
        this.materialLocationName = materialLocationName;
    }

    public String getTransportGroupName()
    {
        return this.transportGroupName;
    }

    public void setTransportGroupName(String transportGroupName)
    {
        this.transportGroupName = transportGroupName;
    }

    public double getTimeUsedLimit()
    {
        return timeUsedLimit;
    }

    public void setTimeUsedLimit(double timeUsedLimit)
    {
        this.timeUsedLimit = timeUsedLimit;
    }

    public double getDurationUsedLimit()
    {
        return this.durationUsedLimit;
    }

    public void setDurationUsedLimit(double durationUsedLimit)
    {
        this.durationUsedLimit = durationUsedLimit;
    }

    public double getTimeUsed()
    {
        return this.timeUsed;
    }

    public void setTimeUsed(double timeUsed)
    {
        this.timeUsed = timeUsed;
    }

    public double getDurationUsed()
    {
        return this.durationUsed;
    }

    public void setDurationUsed(double durationUsed)
    {
        this.durationUsed = durationUsed;
    }

    public long getCapacity()
    {
        return this.capacity;
    }

    public void setCapacity(long capacity)
    {
        this.capacity = capacity;
    }

    public long getLotQuantity()
    {
        return this.lotQuantity;
    }

    public void setLotQuantity(long lotQuantity)
    {
        this.lotQuantity = lotQuantity;
    }

    public String getFactoryName()
    {
        return this.factoryName;
    }

    public void setFactoryName(String factoryName)
    {
        this.factoryName = factoryName;
    }

    public String getAreaName()
    {
        return this.areaName;
    }

    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }

    public String getDurableState()
    {
        return this.durableState;
    }

    public void setDurableState(String durableState)
    {
        this.durableState = durableState;
    }

    public String getDurableCleanState()
    {
        return this.durableCleanState;
    }

    public void setDurableCleanState(String durableCleanState)
    {
        this.durableCleanState = durableCleanState;
    }

    public String getLastEventName()
    {
        return this.lastEventName;
    }

    public void setLastEventName(String lastEventName)
    {
        this.lastEventName = lastEventName;
    }

    public String getLastEventTimeKey()
    {
        return this.lastEventTimeKey;
    }

    public void setLastEventTimeKey(String lastEventTimeKey)
    {
        this.lastEventTimeKey = lastEventTimeKey;
    }

    public Timestamp getLastEventTime()
    {
        return this.lastEventTime;
    }

    public void setLastEventTime(Timestamp lastEventTime)
    {
        this.lastEventTime = lastEventTime;
    }

    public String getLastEventUser()
    {
        return this.lastEventUser;
    }

    public void setLastEventUser(String lastEventUser)
    {
        this.lastEventUser = lastEventUser;
    }

    public String getLastEventComment()
    {
        return this.lastEventComment;
    }

    public void setLastEventComment(String lastEventComment)
    {
        this.lastEventComment = lastEventComment;
    }

    public String getLastEventFlag()
    {
        return this.lastEventFlag;
    }

    public void setLastEventFlag(String lastEventFlag)
    {
        this.lastEventFlag = lastEventFlag;
    }

    public Timestamp getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime)
    {
        this.createTime = createTime;
    }

    public String getCreateUser()
    {
        return this.createUser;
    }

    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
    }

    public String getReasonCodeType()
    {
        return this.reasonCodeType;
    }

    public void setReasonCodeType(String reasonCodeType)
    {
        this.reasonCodeType = reasonCodeType;
    }

    public String getReasonCode()
    {
        return this.reasonCode;
    }

    public void setReasonCode(String reasonCode)
    {
        this.reasonCode = reasonCode;
    }

}
