package GenshinHelper;



public class Stats {
    private WishItems[] items;
    private WishItems[] sortedItems;
    private int pity;
    private int counter = 0;
    private int weaponCounter = 0;
    private int characterCounter = 0;
    private int fiveStarsCount;
    private int fourStarsCount;
    private int threeStarsCount;

    public Stats() {
        this.pity = databaseHandler.getPity();
        this.items = new WishItems[databaseHandler.dbMaxID()];
    }
    private DatabaseHandler databaseHandler = new DatabaseHandler();
    private WishItemHandler wishItemHandler = new WishItemHandler();
    public int getPity() {
        return pity;
    }

    public void setItems(WishItems tempItems) {
        items[counter] = tempItems;
        counter++;
    }

    public String outName(int i){
        return items[i--].getRewardName();
    }

    public int arrayLength() {
        return items.length;
    }

    public String getRewardType(int i){
        return items[i].getRewardType();
    }

    public void initialiseCounters(Stats stats ){
        wishItemHandler.countWeapons(stats);
        wishItemHandler.countStars(stats);
        this.characterCounter=wishItemHandler.getCharacterCount();
        this.weaponCounter=wishItemHandler.getWeaponCount();
        this.threeStarsCount=wishItemHandler.getThreeStarsCount();
        this.fourStarsCount=wishItemHandler.getFourStarsCount();
        this.fiveStarsCount=wishItemHandler.getFiveStarsCount();
        this.sortedItems=items;
    }

    public void orderedArray(){
        boolean sorted = false;
        WishItems temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < sortedItems.length - 1; i++) {
                if (sortedItems[i].getRarity() > sortedItems[i+1].getRarity()) {
                    temp = sortedItems[i];
                    sortedItems[i] = sortedItems[i+1];
                    sortedItems[i+1] = temp;
                    sorted = false;
                }
            }
        }
        for (WishItems sortedItem : sortedItems) {
            System.out.println((sortedItem.getRewardType()+": " + sortedItem.getRewardName() + ", Star: " + sortedItem.getRarity()));
        }

    }

    public int getWeaponCounter() {
        return weaponCounter;
    }

    public int getCharacterCounter() {
        return characterCounter;
    }

    public int getRarity(int i) {
        return items[i--].getRarity();
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
