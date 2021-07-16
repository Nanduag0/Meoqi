package com.example.meoqi.Models;

public class RewardData {

    private String reward_image_url;
    private String reward_name;
    private String reward_count;
    private String left;

    public RewardData() {
    }

    public RewardData(String reward_image_url, String reward_name, String reward_count, String left) {
        this.reward_image_url = reward_image_url;
        this.reward_name = reward_name;
        this.reward_count = reward_count;
        this.left = left;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getReward_image_url() {
        return reward_image_url;
    }

    public void setReward_image_url(String reward_image_url) {
        this.reward_image_url = reward_image_url;
    }

    public String getReward_name() {
        return reward_name;
    }

    public void setReward_name(String reward_name) {
        this.reward_name = reward_name;
    }

    public String getReward_count() {
        return reward_count;
    }

    public void setReward_count(String reward_count) {
        this.reward_count = reward_count;
    }
}
