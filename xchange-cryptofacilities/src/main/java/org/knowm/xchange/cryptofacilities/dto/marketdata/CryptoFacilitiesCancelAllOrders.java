package org.knowm.xchange.cryptofacilities.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.cryptofacilities.Util;
import org.knowm.xchange.cryptofacilities.dto.CryptoFacilitiesResult;

import java.text.ParseException;
import java.util.Date;

public class CryptoFacilitiesCancelAllOrders extends CryptoFacilitiesResult {

    private final Date serverTime;

    private final CryptoFacilitiesCancelAllOrdersStatus cancelStatus;

    public CryptoFacilitiesCancelAllOrders(
            @JsonProperty("result") String result,
            @JsonProperty("serverTime") String strServerTime,
            @JsonProperty("cancelStatus") CryptoFacilitiesCancelAllOrdersStatus cancelStatus,
            @JsonProperty("error") String error
    ) throws ParseException {
        super(result, error);
        this.serverTime = Util.parseDate(strServerTime);
        this.cancelStatus = cancelStatus;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public CryptoFacilitiesCancelAllOrdersStatus getCancelStatus() {
        return cancelStatus;
    }

    @Override
    public String toString() {
        return "CryptoFacilitiesCancelAllOrders{" +
                "result=" + getResult() +
                ", serverTime=" + serverTime +
                ", cancelStatus=" + cancelStatus +
                ", error=" + getError() +
                '}';
    }
}
