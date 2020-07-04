package pl.MR.apirekrutacyjne;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
class NBPApiParameters {
    private LocalDate startDate;
    private LocalDate endDate;

    @Setter
    private NBPCurrency currency;

    public void setEndDate(String userInput) throws DateTimeParsingException {
        this.endDate = DateTimeUtilities.loadEndDate(userInput);
    }

    public void setStartDate(String userInput) throws DateTimeParsingException  {
        this.startDate = DateTimeUtilities.loadStartDate(userInput, endDate);
    }

}