package com.tescobank.judge.question;

import com.tescobank.judge.state.Questions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by er63 on 12/29/2016.
 */
public class LoanSignatureQuestion {



    @Then("^I am presented the digital signature for loans$")
    public void i_am_presented_the_digital_signature_for_loans() throws Throwable {
        Questions.getLoanSignatureView().assertInView();
    }

    @Then("^I see a link to download a pdf copy of the credit agreement for my records including the pdf size$")
    public void i_see_a_link_to_download_a_pdf_copy_of_the_credit_agreement_for_my_records_including_the_pdf_size() throws Throwable {
         Questions.getLoanSignatureView().assertPdfLinkPresent();

    }


    @Then("^the downloaded pdf has an easily recognisable filename$")
    public void the_downloaded_pdf_has_an_easily_recognisable_filename() throws Throwable {
         Questions.getLoanSignatureView().assertDownloadedPDFName();

    }
    @Then("^I see a message explaining the error- This field is required$")
    public void i_see_a_message_explaining_the_error_This_field_is_required() throws Throwable {
       Questions.getLoanSignatureView().errorMsgRequiredIsPresent();
    }


    @And("^I see that continue will trigger the money into my given account$")
    public void iSeeThatContinueWillTriggerTheMoneyIntoMyGivenAccount() throws Throwable {
        Questions.getLoanSignatureView().accountDetailsIsPresent();

    }

    @And("^the downloaded pdf has an easily recognisable \"([^\"]*)\"$")
    public void theDownloadedPdfHasAnEasilyRecognisable(String pdfName) throws Throwable {
        Questions.getLoanSignatureView().assertPdfMatchesName(pdfName);
    }
}
