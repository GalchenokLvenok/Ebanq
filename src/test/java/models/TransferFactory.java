package models;

import com.github.javafaker.Faker;

public class TransferFactory {

    public static Transfer get() {
        Faker faker = new Faker();
        return Transfer.builder()
                .amountTransfer(faker.number().randomDigitNotZero())
                .debitAccount("EBQ11223487456")
                .creditAccount("EBQ11113487654")
                .descriptionTransfer(faker.toString())
                .build();
    }

    public static Transfer get(String debitAccount, String creditAccount) {
        Transfer transfer = get();
        transfer.setDebitAccount(debitAccount);
        transfer.setCreditAccount(creditAccount);
        return transfer;
    }
}
