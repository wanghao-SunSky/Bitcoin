package org.example;

public class Main {
    public static void main(String[] args) {
        Blockchain bitcoin = new Blockchain(4, 50);

        // 添加交易
        bitcoin.addTransaction(new Transaction("address1", "address2", 100));
        bitcoin.addTransaction(new Transaction("address2", "address1", 50));

        // 挖矿
        bitcoin.minePendingTransactions("minerAddress");

        // 输出区块链信息来验证
        for (Block block : bitcoin.getChain()) {
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Current Hash: " + block.getHash());
            System.out.println("Transactions: ");
            for (Transaction transaction : block.getTransactions()) {
                System.out.println("    " + transaction.getSender() + " -> " + transaction.getRecipient() + " : " + transaction.getAmount());
            }
        }
    }
}
