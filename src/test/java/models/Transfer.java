package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transfer {
    int amountTransfer;
    String debitAccount;
    String creditAccount;
    String descriptionTransfer;
}
