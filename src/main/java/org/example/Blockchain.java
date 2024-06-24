package org.example;

import java.util.ArrayList;

public class Blockchain {
    private ArrayList<Block> chain;
    private ArrayList<Transaction> pendingTransactions;
    private int difficulty;
    private double miningReward;

    public Blockchain(int difficulty, double miningReward) {
        this.chain = new ArrayList<>();
        this.pendingTransactions = new ArrayList<>();
        this.difficulty = difficulty;
        this.miningReward = miningReward;

        // 创建创世区块
        Block genesisBlock = new Block("0", Integer.toString(difficulty));
        genesisBlock.mineBlock();
        chain.add(genesisBlock);
    }

    public void minePendingTransactions(String minerAddress) {
        Block block = new Block(chain.get(chain.size() - 1).getHash(), Integer.toString(difficulty));
        for (Transaction transaction : pendingTransactions) {
            block.addTransaction(transaction);
        }

        block.mineBlock();
        System.out.println("Block successfully mined!");
        chain.add(block);

        pendingTransactions.clear();
        pendingTransactions.add(new Transaction("System", minerAddress, miningReward));
    }

    public void addTransaction(Transaction transaction) {
        pendingTransactions.add(transaction);
    }

    public ArrayList<Block> getChain() {
        return chain;
    }
}

