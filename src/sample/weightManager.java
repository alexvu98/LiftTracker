package sample;

public class weightManager {
    private float currentHalfWeight;
    private float currentWeight;


    private float fifty,twentyFive,twenty,fifteen,ten,five,twoFive,oneTwentyFive,zeroFive,zeroTwentyFive;

    private int numPlates;




    public void setWeight(float weight)
    {
        weight = (weight-20)/2;      //subtracts weight of bar then divides weight in half for plate calculations.
        float weightHolder = weight; // holds the original weight before being modified

        if(weight/50 >= 1) {
            fifty = (weight - weight % 50)/50;
            weight = weight % 50;
        }
        if(weight/25 >= 1) {
            twentyFive = (weight - weight % 25)/25;
            weight = weight % 25;
        }
        if(weight/20 >= 1) {
            twenty = (weight - weight % 20)/20;
            weight = weight % 20;
        }
        if(weight/15 >= 1) {
            fifteen = (weight - weight % 15)/15;
            weight = weight % 15;
        }
        if(weight/10 >= 1) {
            ten = (weight - weight % 10)/10;
            weight = weight % 10;
        }
        if(weight/5 >= 1) {
            five = (weight - weight % 5)/5;
            weight = weight % 5;
        }
        if(weight/2.5f >= 1) {
            twoFive = (weight - weight % 2.5f)/2.5f;
            weight = weight % 2.5f;
        }
        if(weight/1.5f >= 1) {
            oneTwentyFive = (weight - weight % 1.25f)/1.25f;
            weight = weight % 1.25f;
        }
        if(weight/.5f >= 1) {
            zeroFive = (weight - weight % .5f)/.5f;
            weight = weight % .5f;
        }
        if(weight/.25f >= 1) {
            zeroTwentyFive = (weight - weight % .25f)/.25f;
            weight = weight % .25f;
        }

        currentHalfWeight = (weightHolder+10)-weight; // cuts off any remaining weight(unable to add with current plates).
        currentWeight = currentHalfWeight*2;

    }



    public void clear(){
        currentWeight = 0;
        currentHalfWeight = 0;
        fifty =0;
        twentyFive = 0;
        twenty = 0;
        fifteen =0;
        ten = 0;
        five = 0;
        twoFive =0;
        oneTwentyFive = 0;
        zeroFive =0;
        zeroTwentyFive =0;
    }

    public int getNumPlates()
    {
        return (int)fifty + (int)twentyFive + (int)fifteen + (int)ten + (int)five + (int)twoFive + (int)oneTwentyFive + (int)zeroFive + (int)zeroTwentyFive;

    }

    public float getCurrentHalfWeight(){
        return currentHalfWeight;
    }
    public float getCurrentWeight(){ return currentWeight;}

    public float getFifty() { return fifty; }
    public float getTwentyFive()
    {
        return twentyFive;
    }
    public float getTwenty() { return twenty; }
    public float getFifteen()
    {
        return fifteen;
    }
    public float getTen() { return ten; }
    public float getFive()
    {
        return five;
    }
    public float getTwoFive()
    {
        return twoFive;
    }
    public float getOneTwentyFive()
    {
        return oneTwentyFive;
    }
    public float getZeroFive()
    {
        return zeroFive;
    }
    public float getZeroTwentyFive()
    {
        return zeroTwentyFive;
    }




}
