package models;

public class Transfer {
    String amountTransfer;
    String debitAccount;
    String creditAccount;
    String descriptionTransfer;

    public Transfer(String amountTransfer, String debitAccount, String creditAccount, String descriptionTransfer) {
        this.amountTransfer = amountTransfer;
        this.debitAccount = debitAccount;
        this.creditAccount = creditAccount;
        this.descriptionTransfer = descriptionTransfer;
    }

    public String getAmountTransfer() {
        return amountTransfer;
    }

    public void setAmountTransfer(String amountTransfer) {
        this.amountTransfer = amountTransfer;
    }

    public String getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
    }

    public String getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(String creditAccount) {
        this.creditAccount = creditAccount;
    }

    public String getDescriptionTransfer() {
        return descriptionTransfer;
    }

    public void setDescriptionTransfer(String descriptionTransfer) {
        this.descriptionTransfer = descriptionTransfer;
    }
}
