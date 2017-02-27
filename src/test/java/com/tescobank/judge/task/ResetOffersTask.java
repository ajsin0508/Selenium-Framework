package com.tescobank.judge.task;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.tbcukesupport.rest.RestRequest;
import com.tescobank.judge.tbcukesupport.rest.RestResponse;
import com.tescobank.judge.tbcukesupport.rest.RestSupport;
import com.tescobank.tests.tbcukesupport.ConfigHelper;

import static com.tescobank.judge.state.StateKey.OFFERID;
import static com.tescobank.judge.state.StateKey.TBID;
import static org.junit.Assert.assertEquals;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class ResetOffersTask {

    public static void resetOffers() {
        RestRequest request = new RestRequest();
        request.setMethod(RestRequest.GET);
        request.setEndPoint(ConfigHelper.getBasePageUrl() + "/resetOffer/" + Actor.getString(OFFERID) + "/" + Actor.getString(TBID));
        RestResponse response = RestSupport.execute(request);
        assertEquals(200, response.getResponseCode());
    }
}
