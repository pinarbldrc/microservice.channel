package customerApplication.mapper;

import customerApplication.dto.request.ClientRequestDto;
import customerApplication.repository.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {


    Client toClient(ClientRequestDto clientRequestDto);
    ClientRequestDto toClientRequestDto(Client client);
}
