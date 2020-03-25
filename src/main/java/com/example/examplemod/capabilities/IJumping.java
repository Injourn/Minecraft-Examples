package com.example.examplemod.capabilities;

public interface IJumping{
    public void SpendJump();
    public void ResetJump(int amount);
    public int JumpsAvailable();
    public boolean JumpsLeft();
}