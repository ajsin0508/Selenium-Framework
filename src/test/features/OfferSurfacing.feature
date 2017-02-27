@CIAll
@Offer
Feature: Offer surfacing
  As marketing I want to present my customers with the most relevant offer
  so that they can apply for it

  @BDDexample
  Scenario: Loan offer surfacing when loan offer is available
    # PERSONA (implies data and some setup. Only if few and well known, otherwise go for USER_WITH_THIS_AND_THAT_STATUS)
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    # TASK we are testing for.
    When I get in the PSP page
    # QUESTION/ASSERTION to prove the behaviour
    Then I see an offer for a loan

#  Scenario: Loan offer surfacing when loan and PCA offers are available
#    Given I log in as "CUSTOMER_WITH_BOTH_LOAN_AND_PCA_OFFER"
#    When I get in the PSP page
#    Then I see an offer for a loan

  Scenario: PCA offer surfacing when no loan offer is available and PCA offer is available
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_AND_NO_LOAN_OFFER"
    When I get in the PSP page
    Then I see an offer for PCA account

#  Scenario: No offer surfacing when no offers are available
#    Given I log in as "CUSTOMER_WITH_NO_OFFERS"
#    When I get in the PSP page
#    Then I see no offers
