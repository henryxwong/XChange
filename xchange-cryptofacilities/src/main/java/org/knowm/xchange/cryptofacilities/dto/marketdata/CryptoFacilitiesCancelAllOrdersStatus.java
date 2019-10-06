package org.knowm.xchange.cryptofacilities.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;

public class CryptoFacilitiesCancelAllOrdersStatus extends CryptoFacilitiesCancelStatus {

    private final String cancelOnly;

    public CryptoFacilitiesCancelAllOrdersStatus(
            @JsonProperty("receivedTime") String strReceivedTime, @JsonProperty("status") String status, @JsonProperty("cancelOnly") String cancelOnly)
            throws ParseException {
        super(strReceivedTime, status);
        this.cancelOnly = cancelOnly;
    }

    public String getCancelOnly() {
        return cancelOnly;
    }

    @Override
    public String toString() {
        return "CryptoFacilitiesCancelAllOrdersStatus{" +
                "status='" + getStatus() + '\'' +
                ", receivedTime='" + getReceivedTime() + '\'' +
                ", cancelOnly='" + cancelOnly + '\'' +
                '}';
    }
}
