package com.tescobank.judge.actions;
import com.tescobank.judge.question.QuestionUtil;
import com.tescobank.judge.state.SharedState;
import com.tescobank.judge.state.StateKey;
import org.openqa.selenium.WebDriver;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IR86 on 1/27/2017.
 */
public class PreparePDFTemplateAction extends JudgeTescoBankInteractionBase {

    public PreparePDFTemplateAction(WebDriver driver) {
        super(driver);
    }
    public String getPdfTemplate(String pdfName) throws Throwable{

        String path = System.getProperty("user.dir")+"\\src\\test\\resources\\"+pdfName+".txt";
        BufferedReader br1 = new BufferedReader(new FileReader(path));

        String sCurrentLine;
        StringBuilder template = new StringBuilder();

        while ((sCurrentLine = br1.readLine()) != null) {
            template.append(sCurrentLine);
        }

        String []valuesToReplace ={"<LOAN_AMOUNT>", "<ANNUAL_INTEREST>","<NUMBER_REPAYMENTS>","<MONTHLY_REPAYMENT>","<REPAYMENT_DATE>" ,"<TOTAL_INTEREST>","<LOAN_APR>","<TOTAL_AMOUNT>","<LOAN_TERM>","<NUMBER_REPAYMENTS>"};

        Map<String,String> valueMap=new HashMap<>();

        valueMap.put("LOAN_AMOUNT", QuestionUtil.formatCurrency((String) SharedState.get(StateKey.LOAN_AMOUNT)));
        valueMap.put("ANNUAL_INTEREST",(String) SharedState.get(StateKey.ANNUAL_INTEREST));
        valueMap.put("NUMBER_REPAYMENTS",(String) SharedState.get(StateKey.NUMBER_REPAYMENTS));
        valueMap.put("MONTHLY_REPAYMENT",(String) SharedState.get(StateKey.MONTHLY_REPAYMENT));
        valueMap.put("REPAYMENT_DATE","18");
        valueMap.put("TOTAL_INTEREST",(String) SharedState.get(StateKey.TOTAL_INTEREST));
        valueMap.put("LOAN_APR",(String) SharedState.get(StateKey.LOAN_APR));
        valueMap.put("TOTAL_AMOUNT",QuestionUtil.formatCurrency((String) SharedState.get(StateKey.TOTAL_AMOUNT)));
        valueMap.put("LOAN_TERM",(String) SharedState.get(StateKey.LOAN_TERM));
        valueMap.put("NUMBER_REPAYMENTS",(String) SharedState.get(StateKey.NUMBER_REPAYMENTS));

        int startPos=0;
        int endPos=0;
        String stateKey="StateKey.";


        StringBuilder key = new StringBuilder();
        String temporary[];
        String temporary1[];
        for(int i=0;i<valuesToReplace.length;i++){


            startPos= template.indexOf(valuesToReplace[i]);

            //Checks whether the value to be replaced is present in the template, if not continue with next iteration
            if(startPos==-1){
                continue;
            }

            endPos = startPos+valuesToReplace[i].length();
            //System.out.println("Start postion: "+startPos);
            //System.out.println("End postion: "+endPos);

             temporary = valuesToReplace[i].split("<");
             temporary1= temporary[1].split(">");


            //key.append(stateKey);
            //key.append(temporary1[0]);
            //System.out.println(valuesToReplace[i]);
            //System.out.println(key);
           // String stateTemp = temporary1[0].toString();

            template.replace(startPos,endPos,valueMap.get(temporary1[0]) );

            key.setLength(0);

        }
        return template.toString();
    }
}
