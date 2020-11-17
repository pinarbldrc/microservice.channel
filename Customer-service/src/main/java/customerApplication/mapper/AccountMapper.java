package customerApplication.mapper;

import customerApplication.dto.request.AccountRequestDto;
import customerApplication.repository.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    Account toAccount(AccountRequestDto accountRequestDto);

    AccountRequestDto toAccountRequestDto(Account account);
}
