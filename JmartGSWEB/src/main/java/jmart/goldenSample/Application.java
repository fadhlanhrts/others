package jmart.goldenSample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jmart.goldenSample.controller.PaymentInstrumentator;
import jmart.goldenSample.dbjson.JSONDBEngine;

@SpringBootApplication
public class Application
{
	public static void main(String[] args)
	{
		JSONDBEngine.fetch(Application.class);
		SpringApplication.run(Application.class, args);
		new Thread(new PaymentInstrumentator()).start();
	}
}
