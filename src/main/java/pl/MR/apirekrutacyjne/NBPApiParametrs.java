package pl.MR.apirekrutacyjne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NBPApiParametrs {
    private LocalDate startDate;
    private LocalDate endDate;
    private NBPCurrency currency;
}
