package com.cetera.process.engine.client;

import org.apache.commons.lang3.StringUtils;

public class StableMarriageProblem {
    
    private int findIndexOf(String[] array, String element){
        for(int i = 0 ; i < array.length ; i++){
            if(array[i] != null && array[i].equals(element) ){
                return i;
            }
        }
        return -1;
    }

    private String[] computeStableMarriage(String mens[], String womens[], String[][] menPreferences, String[][] womenPreferences) {
        int totalPeople = mens.length;
        boolean menEngaged[] = new boolean[totalPeople];
        String womenPartner[] = new String[totalPeople];
        
        int engagedCount = 0;
        int counter = 0;
        while(engagedCount < totalPeople){
            for(int womenIndex =0 ; womenIndex < womenPreferences.length ; womenIndex++){
                
                if(engagedCount == mens.length){
                    break;
                }
                
                String[] womenPreference = womenPreferences[womenIndex];
                String menPartner = womenPreference[counter];
                String currentWomen = womens[womenIndex];
                
                if(findIndexOf(womenPartner, currentWomen) > 0){
                    continue;
                }
                
                int menAtIndex = 0;
                for(int menIndex = 0 ; menIndex < mens.length; menIndex++){
                    String men = mens[menIndex];
                    if(men.equals(menPartner)){
                        menAtIndex = menIndex;
                        break;
                    }
                }
                
                String[] menPreference = menPreferences[menAtIndex];
                String women = womenPartner[menAtIndex];
                if(women == null || StringUtils.isBlank(women)){
                    womenPartner[menAtIndex] = womens[womenIndex];
                    engagedCount++;
                }else{
                    int previousWomenIndex = findIndexOf(menPreference, women);
                    int currentWomenIndex = findIndexOf(menPreference, currentWomen);
                    if(previousWomenIndex > currentWomenIndex){
                        womenPartner[menAtIndex] = currentWomen;
                        menEngaged[menAtIndex] = true;
                    }
                }
                
            }
            counter++;//Days incrementing
        }
        return womenPartner;
    }

    public static void main(String[] args) {
        String men[] = { "M1", "M2", "M3","M4" };
        String women[] = { "W1", "W2", "W3" ,"W4"};
        String[][] menPreference = new String[][] { { "W1", "W2", "W3" , "W4" }, { "W3", "W2", "W1" , "W4" }, { "W2", "W1", "W3" , "W4" } , {"W4","W3","W2","W1"} };
        String[][] womenPreference = new String[][] { { "M3", "M2", "M1" , "M4" }, { "M3", "M2", "M1" ,"M4"}, { "M4", "M3", "M1" , "M2" } , {"M2" ,"M1" ,"M3" ,"M4"} };
        String womenPartner[] = new StableMarriageProblem().computeStableMarriage(men, women, menPreference, womenPreference);
        for(String partner : womenPartner){
            System.out.println("Partner name is =>" + partner);
        }
    }

}
