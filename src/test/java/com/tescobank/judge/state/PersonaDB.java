package com.tescobank.judge.state;

import static com.tescobank.tests.tbcukesupport.TestDataHelper.data;

/**
 * Created by pabloarroyo on 09/07/16.
 */
public class PersonaDB {
    public static void appendPersonaState(String userName) throws Exception {
        SharedState.put(StateKey.ID, userName);
        // get from cucumber_constants.xls or a json resource file or something like this (maybe a DB)
        String userKey = userName.replace(" ","");
        SharedState.put(StateKey.USERNAME, data(userKey + ".username"));
        SharedState.put(StateKey.FIRST_NAME, data(userKey + ".first_name"));
        SharedState.put(StateKey.SURNAME, data(userKey + ".surname"));
        SharedState.put(StateKey.PASSWORD, data(userKey + ".password"));
        SharedState.put(StateKey.AGE, data(userKey + ".age"));
        SharedState.put(StateKey.DOB, data(userKey + ".dob"));
        SharedState.put(StateKey.MARITAL_STATUS, data(userKey + ".marital_status"));
        SharedState.put(StateKey.GENDER, data(userKey + ".gender"));
        SharedState.put(StateKey.POSTCODE, data(userKey + ".postcode"));
        SharedState.put(StateKey.ADDRESS, data(userKey + ".address"));
        SharedState.put(StateKey.TOWN, data(userKey + ".town"));
        SharedState.put(StateKey.EMAIL, data(userKey + ".email"));
        SharedState.put(StateKey.MOBILE_NUMBER, data(userKey + ".mobile_number"));
        SharedState.put(StateKey.HOUSE_PHONE, data(userKey + ".house_phone"));
        SharedState.put(StateKey.SECURITY_NUMBER_1, data(userKey + ".sec1"));
        SharedState.put(StateKey.SECURITY_NUMBER_2, data(userKey + ".sec2"));
        SharedState.put(StateKey.SECURITY_NUMBER_3, data(userKey + ".sec3"));
        SharedState.put(StateKey.SECURITY_NUMBER_4, data(userKey + ".sec4"));
        SharedState.put(StateKey.SECURITY_NUMBER_5, data(userKey + ".sec5"));
        SharedState.put(StateKey.SECURITY_NUMBER_6, data(userKey + ".sec6"));
        SharedState.put(StateKey.OFFERID, data(userKey + ".offer_id"));
        SharedState.put(StateKey.TBID, data(userKey + ".tbid"));
        SharedState.put(StateKey.INCOME, data(userKey + ".income"));
        SharedState.put(StateKey.ADDITIONAL_INCOME, data(userKey + ".additional_income"));
        SharedState.put(StateKey.OVERDRAFT, data(userKey + ".overdraft"));
        SharedState.put(StateKey.CHEQUE_BOOK, data(userKey + ".cheque_book"));
        SharedState.put(StateKey.LOAN_AMOUNT, data(userKey + ".loan_amount"));
        SharedState.put(StateKey.LOAN_TERM, data(userKey + ".loan_term"));
        SharedState.put(StateKey.LOAN_APR, data(userKey + ".loan_apr"));
        SharedState.put(StateKey.TOTAL_AMOUNT, data(userKey + ".total_amount"));
        SharedState.put(StateKey.ANNUAL_INTEREST, data(userKey + ".annual_interest"));
        SharedState.put(StateKey.MONTHLY_REPAYMENT, data(userKey + ".monthly_repayment"));
        SharedState.put(StateKey.NUMBER_REPAYMENTS, data(userKey + ".number_repayments"));
        SharedState.put(StateKey.TOTAL_INTEREST, data(userKey + ".total_interest"));
        SharedState.put(StateKey.SORTCODE, data(userKey + ".sortcode"));
        SharedState.put(StateKey.ACCOUNT_NUMBER, data(userKey + ".account_number"));
        SharedState.put(StateKey.BANK_STATEMENT_NAME, data(userKey + ".bank_statement_name"));
        SharedState.put(StateKey.OPEN_ACCOUNT_YEAR, data(userKey + ".open_account_year"));
        SharedState.put(StateKey.OPEN_ACCOUNT_MONTH, data(userKey + ".open_account_month"));
        SharedState.put(StateKey.COUNTRY_OF_BIRTH, data(userKey + ".country_birth"));
        SharedState.put(StateKey.NATIONALITY, data(userKey + ".nationality"));
        SharedState.put(StateKey.MAIDEN_NAME, data(userKey + ".maiden_name"));
        SharedState.put(StateKey.DOCUMENTATION_PREFERENCE, data(userKey + ".documentation_preference"));
        SharedState.put(StateKey.GO_PAPERLESS, data(userKey + ".go_paperless"));
    }
}
