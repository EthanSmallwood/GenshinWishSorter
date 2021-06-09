package GenshinHelper;

public class WishItemHandler {
    private int weaponCount;
    private int characterCount;
    private int fiveStarsCount=0;
    private int fourStarsCount=0;
    private int threeStarsCount=0;


    public void countWeapons(Stats stats){
        for(int i = 0; i < stats.arrayLength();i++){
            if(stats.getRewardType(i).equalsIgnoreCase("weapon")){
                this.weaponCount++;
            }else{
                this.characterCount++;
            }
        }
    }

    public int getWeaponCount() {
        return weaponCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public void countStars(Stats stats){
        for(int i = 0; i < stats.arrayLength();i++){
            switch (stats.getRarity(i)) {
                case 3 -> this.threeStarsCount++;
                case 4 -> this.fourStarsCount++;
                case 5 -> this.fiveStarsCount++;
            }
        }
    }

    public int getFiveStarsCount() {
        return fiveStarsCount;
    }

    public int getFourStarsCount() {
        return fourStarsCount;
    }

    public int getThreeStarsCount() {
        return threeStarsCount;
    }



}
