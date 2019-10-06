package org.knowm.xchange.cryptofacilities.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.cryptofacilities.CryptoFacilitiesAdapters;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.exceptions.NotAvailableFromExchangeException;
import org.knowm.xchange.service.trade.TradeService;
import org.knowm.xchange.service.trade.params.CancelAllOrders;
import org.knowm.xchange.service.trade.params.CancelOrderByCurrencyPair;
import org.knowm.xchange.service.trade.params.CancelOrderByIdParams;
import org.knowm.xchange.service.trade.params.CancelOrderParams;
import org.knowm.xchange.service.trade.params.TradeHistoryParams;
import org.knowm.xchange.service.trade.params.orders.OpenOrdersParams;

import java.io.IOException;

/** @author Jean-Christophe Laruelle */
public class CryptoFacilitiesTradeService extends CryptoFacilitiesTradeServiceRaw
    implements TradeService {

  /**
   * Constructor
   *
   * @param exchange
   */
  public CryptoFacilitiesTradeService(Exchange exchange) {

    super(exchange);
  }

  @Override
  public OpenOrders getOpenOrders() throws IOException {
    return getOpenOrders(createOpenOrdersParams());
  }

  @Override
  public OpenOrders getOpenOrders(OpenOrdersParams params) throws IOException {
    return CryptoFacilitiesAdapters.adaptOpenOrders(super.getCryptoFacilitiesOpenOrders());
  }

  @Override
  public String placeMarketOrder(MarketOrder marketOrder) throws IOException {

    throw new NotAvailableFromExchangeException();
  }

  @Override
  public String placeLimitOrder(LimitOrder limitOrder) throws IOException {

    return CryptoFacilitiesAdapters.adaptOrderId(super.sendCryptoFacilitiesLimitOrder(limitOrder));
  }

  @Override
  public boolean cancelOrder(String orderId) throws IOException {

    return CryptoFacilitiesAdapters.adaptCryptoFacilitiesCancel(
        super.cancelCryptoFacilitiesOrder(orderId));
  }

  @Override
  public boolean cancelOrder(CancelOrderParams orderParams) throws IOException {
    if (orderParams instanceof CancelOrderByIdParams) {
      return cancelOrder(((CancelOrderByIdParams) orderParams).getOrderId());
    } else if (orderParams instanceof CancelAllOrders) {
      return CryptoFacilitiesAdapters.adaptCryptoFacilitiesCancelAllOrders(
              super.cancelAllCryptoFacilitiesOrder(null));
    } else if (orderParams instanceof CancelOrderByCurrencyPair) {
      return CryptoFacilitiesAdapters.adaptCryptoFacilitiesCancelAllOrders(
              super.cancelAllCryptoFacilitiesOrder(((CancelOrderByCurrencyPair) orderParams).getCurrencyPair().base.toString()));
    } else {
      return false;
    }
  }

  @Override
  public UserTrades getTradeHistory(TradeHistoryParams params) throws IOException {

    return CryptoFacilitiesAdapters.adaptFills(super.getCryptoFacilitiesFills());
  }

  @Override
  public TradeHistoryParams createTradeHistoryParams() {

    return null;
  }

  @Override
  public OpenOrdersParams createOpenOrdersParams() {
    return null;
  }
}
