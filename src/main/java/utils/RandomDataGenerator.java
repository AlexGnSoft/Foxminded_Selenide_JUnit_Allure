package utils;

import java.util.Random;

public class RandomDataGenerator {

    /**
     * Method is used to generate random Boolean state
     */
    public Boolean randomBoolean(){
        Random random = new Random();

        return random.nextBoolean();
    }

    /**
     * Method is used to generate random sequence of int values, where
     * intRange - sets the max int range;
     * quantityOfRandomInt - sets quantity of int values to be added to each other in a sequence;
     *
     */
    public String randomInt(int intRange, int quantityOfRandomInt){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        String randomIntSequence;

        for (int i = 0; i < quantityOfRandomInt; i++) {
            int randomNumber = random.nextInt(intRange);
            sb.append(randomNumber);
        }
        randomIntSequence = sb.toString();
        return randomIntSequence;
    }

    /**
     * Method is used to generate different random Strings, where
     * strLength - is a string length
     * Boolean parameters: if true > we get certain String:
     * email -  with @ and .com
     * login, skype  - random chars and digits
     * name - random First Name with 1st Capital letter and Last Name
     */
    public String randomString(int strLength, Boolean isEmail, Boolean isLoginOrSkype, Boolean isName){
        String randomString = "";
        String firstLetter = "";
        if (strLength < 1) throw new IllegalArgumentException();
        //create a string for all characters
        String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";

        //create a random string builder
        StringBuilder sb = new StringBuilder(strLength);
        //create an object of random string
        Random random = new Random();
        int index;

        for (int i = 0; i < strLength; i++) {
            index = random.nextInt(AlphaNumericStr.length());
            char rndChar = AlphaNumericStr.charAt(index);
            sb.append(rndChar);
        }

        String randomStrTemp = sb.toString(); //random String creation

        //first letter in a string should be a letter only, not a digit. Implementation:
        for (int j = 0; j < randomStrTemp.length(); j++) {
            boolean flag = Character.isAlphabetic(randomStrTemp.charAt(j));
            if(flag){
                firstLetter = randomStrTemp.substring(0, 1).toUpperCase();
            }
        }

        String remainingLetters = randomStrTemp.substring(1);
        if(isEmail){
            randomString = firstLetter + "@" + remainingLetters + ".com";
        }else if(isLoginOrSkype){
            randomString = firstLetter + remainingLetters;
        }else if(isName){
            randomString = remainingLetters;
        }else{
            System.out.println("Please, select a type of random string");
        }
        return randomString;
    }
}
