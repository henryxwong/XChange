package org.knowm.xchange.cryptofacilities.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.cryptofacilities.Util;

import java.text.ParseException;
import java.util.Date;

public class CryptoFacilitiesEditOrderStatus {

    private final Date receivedTime;

    private final String status;

    private final String orderId;

    public CryptoFacilitiesEditOrderStatus(
            @JsonProperty("status") String status,
            @JsonProperty("orderId") String orderId,
            @JsonProperty("receivedTime") String strReceivedTime)
            throws ParseException {

        this.status = status;
        this.orderId = orderId;
        this.receivedTime = Util.parseDate(strReceivedTime);
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public String getStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "CryptoFacilitiesEditOrderStatus{" +
                "receivedTime=" + receivedTime +
                ", status='" + status + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
