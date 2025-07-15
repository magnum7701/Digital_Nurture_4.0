package com.cognizant.spring_learn.services;

import com.cognizant.spring_learn.models.Country;
import com.cognizant.spring_learn.models.CountryList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class CountryService {

    public Country getCountry(String code) throws Exception {
        InputStream input = getClass().getClassLoader().getResourceAsStream("country.xml");

        if (input == null) throw new RuntimeException("country.xml not found");

        JAXBContext context = JAXBContext.newInstance(CountryList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        CountryList countryList = (CountryList) unmarshaller.unmarshal(input);

        List<Country> countries = countryList.getCountries();

        // Using lambda and case-insensitive match
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Country not found with code: " + code));
    }
}
