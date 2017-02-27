package com.tescobank.judge.state;

import com.tescobank.judge.view.*;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class Questions {

    public static LoginView getLoginView() {
        return (LoginView) SingletonFactory.getOrCreateWithWebDriver(LoginView.class);
    }

    public static PspView getPspView() {
        return (PspView) SingletonFactory.getOrCreateWithWebDriver(PspView.class);
    }

    public static LoanOfferDetailsView getLoanOfferDetailView() {
        return (LoanOfferDetailsView) SingletonFactory.getOrCreateWithWebDriver(LoanOfferDetailsView.class);
    }

    public static PcaOfferDetailsView getPcaOfferDetailView() {
        return (PcaOfferDetailsView) SingletonFactory.getOrCreateWithWebDriver(PcaOfferDetailsView.class);
    }

    public static IncomeView getIncomeView() {
        return (IncomeView) SingletonFactory.getOrCreateWithWebDriver(IncomeView.class);
    }

    public static GeneralBeInformedView getGeneralBeInformedView() {
        return (GeneralBeInformedView) SingletonFactory.getOrCreateWithWebDriver(GeneralBeInformedView.class);
    }

    public static OverdraftView getOverdraftView() {
        return (OverdraftView) SingletonFactory.getOrCreateWithWebDriver(OverdraftView.class);
    }

    public static ChequeBookView getChequeBookView() {
        return (ChequeBookView) SingletonFactory.getOrCreateWithWebDriver(ChequeBookView.class);
    }

    public static CountryBirthNationalityView getCountryBirthNationalityView() {
        return (CountryBirthNationalityView) SingletonFactory.getOrCreateWithWebDriver(CountryBirthNationalityView.class);
    }

    public static AccountDetailsView getAccountDetailsView() {
        return (AccountDetailsView) SingletonFactory.getOrCreateWithWebDriver(AccountDetailsView.class);
    }

    public static PreferredPaymentDateView getPreferredPaymentDateView() {
        return (PreferredPaymentDateView) SingletonFactory.getOrCreateWithWebDriver(PreferredPaymentDateView.class);
    }

    public static MotherMaidenNameView getMotherMaidenNameView() {
        return (MotherMaidenNameView) SingletonFactory.getOrCreateWithWebDriver(MotherMaidenNameView.class);
    }

    public static DocumentPreferencesView getDocumentPreferencesView() {
        return (DocumentPreferencesView) SingletonFactory.getOrCreateWithWebDriver(DocumentPreferencesView.class);
    }

    public static PCADocumentationSummaryView getPCADocumentationSummaryView() {
        return (PCADocumentationSummaryView) SingletonFactory.getOrCreateWithWebDriver(PCADocumentationSummaryView.class);
    }

    public static PaperlessView getPaperlessView() {
        return (PaperlessView) SingletonFactory.getOrCreateWithWebDriver(PaperlessView.class);
    }

    public static FSCSView getFSCSView() {
        return (FSCSView) SingletonFactory.getOrCreateWithWebDriver(FSCSView.class);
    }

    public static RatesFeesPCAView getRatesFeesPCAView() {
        return (RatesFeesPCAView) SingletonFactory.getOrCreateWithWebDriver(RatesFeesPCAView.class);
    }

    public static PreContractPCAView getPreContractPCAView() {
        return (PreContractPCAView) SingletonFactory.getOrCreateWithWebDriver(PreContractPCAView.class);
    }

    public static PCASignatureView getPCASignatureView() {
        return (PCASignatureView) SingletonFactory.getOrCreateWithWebDriver(PCASignatureView.class);
    }

    public static PCAAllDoneView getPCAAllDoneView() {
        return (PCAAllDoneView) SingletonFactory.getOrCreateWithWebDriver(PCAAllDoneView.class);
    }

    public static LoanDocumentationSummaryView getLoanDocumentationSummaryView() {
        return (LoanDocumentationSummaryView) SingletonFactory.getOrCreateWithWebDriver(LoanDocumentationSummaryView.class);
    }

    public static UnderstandingLoanView getUnderstandingLoanView() {
        return (UnderstandingLoanView) SingletonFactory.getOrCreateWithWebDriver(UnderstandingLoanView.class);
    }

    public static PreContractLoanView getPreContractLoanView() {
        return (PreContractLoanView) SingletonFactory.getOrCreateWithWebDriver(PreContractLoanView.class);
    }

    public static LoanSignatureView getLoanSignatureView() {
        return (LoanSignatureView) SingletonFactory.getOrCreateWithWebDriver(LoanSignatureView.class);
    }

    public static LoanAllDoneView getLoanAllDoneView() {
        return (LoanAllDoneView) SingletonFactory.getOrCreateWithWebDriver(LoanAllDoneView.class);
    }

    public static BeInformedDataView getBeInformedDataView() {
        return (BeInformedDataView) SingletonFactory.getOrCreate(BeInformedDataView.class);
    }

    public static EmailAddressView getEmailAddressView() {
        return (EmailAddressView) SingletonFactory.getOrCreateWithWebDriver(EmailAddressView.class);
    }

    public static MobileNumberView getMobileNumberView() {
        return (MobileNumberView) SingletonFactory.getOrCreateWithWebDriver(MobileNumberView.class);
    }

    public static PdfView getPdfQuestion() {
        return (PdfView) SingletonFactory.getOrCreateWithWebDriver(PdfView.class);
    }
}
