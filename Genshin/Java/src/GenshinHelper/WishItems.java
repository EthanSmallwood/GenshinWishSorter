package GenshinHelper;

public class WishItems {
    private String rewardName;
    private String rewardType;
    private int rarity;
    private int amount=0;


    public WishItems(String rewardName, String rewardType, int rarity) {
        this.rewardName = rewardName;
        this.rewardType = rewardType;
        this.rarity = rarity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }
}
