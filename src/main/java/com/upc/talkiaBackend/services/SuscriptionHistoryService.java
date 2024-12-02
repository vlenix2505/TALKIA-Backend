package com.upc.talkiaBackend.services;

import com.upc.talkiaBackend.dtos.queries.*;
import com.upc.talkiaBackend.entities.SuscriptionsHistory;

import java.time.LocalDate;
import java.util.List;

public interface SuscriptionHistoryService {
    public String insertInManyToManyTable(int userID, int suscriptionID, int paymentTypeId);
    public List<HistoryByObjectDTO> listHistoryByUser(String userName);
    public List<HistoryByObjectDTO> listHistoryByPaymentType(String paymentTypeName);
    public List<HistoryByObjectDTO> listHistoryByUserAndSuscription(int userId, String suscriptionName);
    public List<HistoryByObjectDTO> listHistoryByAllFilters(int userId, String paymentTypeName, String suscriptionName);
    public List<HistoryByObjectDTO> listHistoryBySuscription(String suscriptionName);
    public List<HistoryByObjectDTO> listHistoryByPaymentTypeAndSuscription(String paymentTypeName, String suscriptionName);
    public List<HistoryByObjectDTO> listHistoryByUserAndPaymentType(int userId, String paymentTypeName);
    public List<CountHistoriesByObjectDTO> countHistoriesByPaymentType(LocalDate startDate, LocalDate endDate);
    public List<TotalAmountBySubTypeDTO> listTotalAmountBySubType(LocalDate startDate, LocalDate endDate);
    public SuscriptionsHistory getSuscriptionsHistoriesByActiveStatus(int userId);
    public List<SuscriptionsHistory> getActiveSubscriptions(LocalDate currentDate);
    List<HistoryByObjectDTO> listHistories();
    List<HistoryByObjectDTO> listHistoryByUserId(int userId);


}
