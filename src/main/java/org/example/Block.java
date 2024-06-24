package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Block {

    private String previousHash;

    private String hash;

    private String merkleRoot;

    private long timeStamp;

    private String target;

    private int nonce;

    private ArrayList<Transaction> transactions;

    public Block(String previousHash,String target){
        this.previousHash = previousHash;
        this.target = target;
        this.timeStamp = new Date().getTime();
        this.transactions = new ArrayList<>();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String dataToHash = previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + merkleRoot;
        String calculatedhash = Util.applySha256(dataToHash);
        return calculatedhash;
    }

    public boolean addTransaction(Transaction transaction){
        if (transaction==null) return false;
        if (!transaction.processTransaction()) return false;
        transactions.add(transaction);
        System.out.println("Transaction Successfully added to Block");
        return true;
    }

    public void mineBlock(){
        merkleRoot = Util.getMerkleRoot(transactions);
        while(!hash.substring(0, target.length()).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }


}
