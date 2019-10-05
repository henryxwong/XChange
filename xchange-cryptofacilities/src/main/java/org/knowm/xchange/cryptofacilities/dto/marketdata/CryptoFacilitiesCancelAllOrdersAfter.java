package org.knowm.xchange.cryptofacilities.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.cryptofacilities.Util;
import org.knowm.xchange.cryptofacilities.dto.CryptoFacilitiesResult;

import java.text.ParseException;
import java.util.Date;

public class CryptoFacilitiesCancelAllOrdersAfter extends CryptoFacilitiesResult {

    private final CryptoFacilitiesCancelAllOrdersAfterStatus status;

    private final Date serverTime;

    public CryptoFacilitiesCancelAllOrdersAfter(@JsonProperty("result") String result,
                                                @JsonProperty("status") CryptoFacilitiesCancelAllOrdersAfterStatus status,
                                                @JsonProperty("serverTime") String strServerTime,
                                                @JsonProperty("error") String error) throws ParseException {
        super(result, error);
        this.status = status;
        this.serverTime = Util.parseDate(strServerTime);
    }

    public CryptoFacilitiesCancelAllOrdersAfterStatus getStatus() {
        return status;
    }

    public Date getServerTime() {
        return serverTime;
    }

    @Override
    public String toString() {
        return "CryptoFacilitiesCancelAllOrdersAfterResult{" +
                "result=" + getResult() +
                ", status=" + status +
                ", serverTime=" + serverTime +
                ", error=" + getError() +
                '}';
    }
}
