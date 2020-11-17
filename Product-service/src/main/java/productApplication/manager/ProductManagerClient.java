package productApplication.manager;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import productApplication.dto.request.ClientRequestDto;

@FeignClient(url = "${myserviceurl.customerService}",decode404 = true,name = "productManagerClient")
public interface ProductManagerClient {

    @RequestMapping(value = "/client/{id}",method = RequestMethod.GET)
   public ResponseEntity<ClientRequestDto> getClient(@PathVariable long id);


}






