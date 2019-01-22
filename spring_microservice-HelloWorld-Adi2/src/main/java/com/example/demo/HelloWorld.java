package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // rodzaj beana (typu klasy zarządzanej przez Spring)
@RequestMapping("/api")
public class HelloWorld {

	// wywolanie http://localhost:8090/api/hello
	@RequestMapping("/hello") // wskazanie pod jakim adresem dostępna jest metoda (EndPoint)
	@ResponseBody // wskazówka dla kontekstu Spring, aby zawartość metody (w tym przypadku String) był zwracany nie do modelu dla widoku lecz jako obiekt
	public String hello() { // sygnatura metody
        return "Hello World! :)"; // zwracana wartość przez przeglądarkę 
    }
	
	// curl --header "number: 123" http://localhost:8090/api/getExampleRequestHeader
	@RequestMapping("/getExampleRequestHeader")
	@ResponseBody
	public String requestHeaderExample(@RequestHeader("number") Long number) {
	    return "delivered by RequestHeader: " + number;
	}

	// curl http://localhost:8090/api/getRequestParam?number=2
	@RequestMapping("/getRequestParam")
	@ResponseBody
	public String requestParamExample(@RequestParam("number") Long number) {
	    return "delivered by RequestParam: " + number;
	}
	
	// curl http://localhost:8090/api/getExamplePathVariable/1
	@RequestMapping("/getExamplePathVariable/{number}")
	@ResponseBody
	public String pathVariableExample(@PathVariable("number") Long number) {
	    return "delivered by PathVariable: " + number;
	}
	
	// curl --header "Content-Type: application/json" --request POST --data '{"username":"xyz","password":"xyz"}' http://localhost:8090/api/getRequestBody
	@RequestMapping(value = "/getRequestBody", method = RequestMethod.POST)
	@ResponseBody
	public String requestBodyExample(@RequestBody String number) {
	    return "delivered by RequestBody: " + number;
	}
	
	@RequestMapping("/getExample")
	@ResponseBody
	public String implicitTransfer(HttpServletRequest request) {
	    String browserName = request.getHeader("User-Agent");
	    String ipAddress = request.getRemoteAddr();
	    return "Browser name: " + browserName + System.lineSeparator()+
	            "IP address: " + ipAddress;
	}
	
	
}
