package org.knowm.xchange.cryptofacilities.dto.trade;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * https://www.cryptofacilities.com/resources/hc/en-us/articles/360000547454-Batch-Order
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderEdit implements OrderCommand {

    public final String order = "edit";

    @JsonProperty("order_id")
    public final String orderId;

    public final BigDecimal size;

    public final BigDecimal limitPrice;

    public final BigDecimal stopPrice;

    public final String cliOrdId;

    public OrderEdit(String orderId, BigDecimal size, BigDecimal limitPrice, BigDecimal stopPrice, String cliOrdId) {
        this.orderId = orderId;
        this.size = size;
        this.limitPrice = limitPrice;
        this.stopPrice = stopPrice;
        this.cliOrdId = cliOrdId;
    }
}
