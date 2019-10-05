package org.knowm.xchange.cryptofacilities.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.cryptofacilities.Util;

import java.text.ParseException;
import java.util.Date;

public class CryptoFacilitiesCancelAllOrdersAfterStatus {

    private final Date currentTime;

    private final Date triggerTime;

    public CryptoFacilitiesCancelAllOrdersAfterStatus(@JsonProperty("currentTime") String strCurrentTime, @JsonProperty("triggerTime") String strTriggerTime) throws ParseException {
        this.currentTime = Util.parseDate(strCurrentTime);
        this.triggerTime = Util.parseDate(strTriggerTime);
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    @Override
    public String toString() {
        return "CryptoFacilitiesCancelAllOrdersAfterStatus{" +
                "currentTime=" + currentTime +
                ", triggerTime=" + triggerTime +
                '}';
    }
}
