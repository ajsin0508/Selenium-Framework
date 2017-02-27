package com.tescobank.judge.state;

import com.tescobank.judge.actions.*;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class Actions {

    public static BrowseAction getBrowseAction() {
        return (BrowseAction) SingletonFactory.getOrCreateWithWebDriver(BrowseAction.class);
    }

    public static LoginAction getLoginAction() {
        return (LoginAction) SingletonFactory.getOrCreateWithWebDriver(LoginAction.class);
    }

    public static PasswordAction getPasswordAction() {
        return (PasswordAction) SingletonFactory.getOrCreateWithWebDriver(PasswordAction.class);
    }

    public static PspAction getPspAction() {
        return (PspAction) SingletonFactory.getOrCreateWithWebDriver(PspAction.class);
    }

    public static PcaOfferAction getPcaOfferAction() {
        return (PcaOfferAction) SingletonFactory.getOrCreateWithWebDriver(PcaOfferAction.class);
    }

    public static LoanOfferAction getLoanOfferAction() {
        return (LoanOfferAction) SingletonFactory.getOrCreateWithWebDriver(LoanOfferAction.class);
    }

    public static BeInformedGeneralAction getBeInformedGeneralAction() {
        return (BeInformedGeneralAction) SingletonFactory.getOrCreateWithWebDriver(BeInformedGeneralAction.class);
    }

    public static IncomeAction getIncomeAction() {
        return (IncomeAction) SingletonFactory.getOrCreateWithWebDriver(IncomeAction.class);
    }

    public static OverdraftAction getOverdraftAction() {
        return (OverdraftAction) SingletonFactory.getOrCreateWithWebDriver(OverdraftAction.class);
    }

    public static ChequeBookAction getChequeBookAction() {
        return (ChequeBookAction) SingletonFactory.getOrCreateWithWebDriver(ChequeBookAction.class);
    }

    public static AccountDetailsAction getAccountDetailsAction() {
        return (AccountDetailsAction) SingletonFactory.getOrCreateWithWebDriver(AccountDetailsAction.class);
    }

    public static PreferredPaymentDateAction getPreferredPaymentDateAction() {
        return (PreferredPaymentDateAction) SingletonFactory.getOrCreateWithWebDriver(PreferredPaymentDateAction.class);
    }

    public static CountryBirthNationalityAction getCountryBirthNationalityAction() {
        return (CountryBirthNationalityAction) SingletonFactory.getOrCreateWithWebDriver(CountryBirthNationalityAction.class);
    }

    public static MotherMaidenNameAction getMotherMaidenNameAction() {
        return (MotherMaidenNameAction) SingletonFactory.getOrCreateWithWebDriver(MotherMaidenNameAction.class);
    }

    public static DocumentationPreferencesAction getDocumentationPreferencesAction() {
        return (DocumentationPreferencesAction) SingletonFactory.getOrCreateWithWebDriver(DocumentationPreferencesAction.class);
    }

    public static PaperlessAction getPaperlessAction() {
        return (PaperlessAction) SingletonFactory.getOrCreateWithWebDriver(PaperlessAction.class);
    }

    public static PCASignatureAction getPCASignatureAction() {
        return (PCASignatureAction) SingletonFactory.getOrCreateWithWebDriver(PCASignatureAction.class);
    }

    public static LoanSignatureAction getLoanSignatureAction() {
        return (LoanSignatureAction) SingletonFactory.getOrCreateWithWebDriver(LoanSignatureAction.class);
    }

    public static EmailAddressAction getEmailAddressAction() {
        return (EmailAddressAction) SingletonFactory.getOrCreateWithWebDriver(EmailAddressAction.class);
    }

    public static MobileNumberAction getMobileNumberAction() {
        return (MobileNumberAction) SingletonFactory.getOrCreateWithWebDriver(MobileNumberAction.class);
    }

    public static PdfAction getPdfAction() {
        return (PdfAction) SingletonFactory.getOrCreateWithWebDriver(PdfAction.class);
    }

    public static UnderstandingYourLoanAction getUnderstandingYourLoanAction() {
        return (UnderstandingYourLoanAction) SingletonFactory.getOrCreateWithWebDriver(UnderstandingYourLoanAction.class);
    }

    public static LoanSECCIAction getLoanSECCIAction() {
        return (LoanSECCIAction) SingletonFactory.getOrCreateWithWebDriver(LoanSECCIAction.class);
    }

    public static PreparePDFTemplateAction gePreparePDFTemplateAction(){
        return (PreparePDFTemplateAction) SingletonFactory.getOrCreateWithWebDriver(PreparePDFTemplateAction.class);
    }


}
