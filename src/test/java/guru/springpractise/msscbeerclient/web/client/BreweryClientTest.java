package guru.springpractise.msscbeerclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springpractise.msscbeerclient.web.model.BeerDto;
import guru.springpractise.msscbeerclient.web.model.CustomerDto;

@SpringBootTest
class BreweryClientTest {
	
	@Autowired
	BreweryClient client;

	@Test
	void getBeerById() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		
		assertNotNull(dto);
	}
	
	@Test
	void testSaveNewBeer() {
		//given
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		URI uri = client.saveNewBeer(beerDto);
		assertNotNull(uri);
		
		System.out.println(uri.toString());
	}
	
	@Test
	void testUpdateBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		client.updateBeer(UUID.randomUUID(), beerDto);
	}
	
	@Test
	void testDeleteBeer() {
		client.deleteBeer(UUID.randomUUID());
	}
	
	
	@Test
	void getCustomerById() {
		CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
		assertNotNull(customerDto);
	}
	
	
	@Test
	void testSaveNewCustomer() {
		CustomerDto customerDto = CustomerDto.builder().name("New Cusotmer").build();
		URI uri = client.saveNewCustomer(customerDto);
		assertNotNull(uri);
		
		System.out.println(uri.toString());
	}
	
	@Test
	void testUpdateCustomer() {
		CustomerDto customerDto = CustomerDto.builder().name("New Cusotmer").build(); 
		client.updateCustomer(UUID.randomUUID(), customerDto);
	}
	
	
	@Test
	void testDeleteCustomer() {
		client.deleteCustomer(UUID.randomUUID());
	}
	
	
	
	
	

}
