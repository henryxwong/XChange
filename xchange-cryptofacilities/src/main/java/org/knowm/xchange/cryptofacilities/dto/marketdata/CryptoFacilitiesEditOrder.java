package org.knowm.xchange.cryptofacilities.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.cryptofacilities.Util;
import org.knowm.xchange.cryptofacilities.dto.CryptoFacilitiesResult;

import java.text.ParseException;
import java.util.Date;

public class CryptoFacilitiesEditOrder extends CryptoFacilitiesResult {

    private final Date serverTime;

    private final CryptoFacilitiesEditOrderStatus editStatus;

    public CryptoFacilitiesEditOrder(
            @JsonProperty("result") String result,
            @JsonProperty("serverTime") String strServerTime,
            @JsonProperty("editStatus") CryptoFacilitiesEditOrderStatus editStatus,
            @JsonProperty("error") String error)
            throws ParseException {

        super(result, error);
        this.serverTime = Util.parseDate(strServerTime);
        this.editStatus = editStatus;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public CryptoFacilitiesEditOrderStatus getEditStatus() {
        return editStatus;
    }

    @Override
    public String toString() {
        return "CryptoFacilitiesEditOrder{" +
                "result=" + getResult() +
                ", serverTime=" + serverTime +
                ", editStatus=" + editStatus +
                ", error=" + getError() +
                '}';
    }
}
