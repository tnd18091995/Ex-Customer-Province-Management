package jintran.cpm.formatter;

import jintran.cpm.model.Province;
import jintran.cpm.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Province> {
    private final IProvinceService provinceService;
    @Autowired
    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }
    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        try {
            Long id = Long.parseLong(text);
            Optional<Province> provinceOptional = provinceService.findById(id);
            if (provinceOptional.isPresent()) {
                return provinceOptional.get();
            } else {
                throw new ParseException("Province not found for id: " + text, 0);
            }
        } catch (NumberFormatException e) {
            throw new ParseException("Invalid province id: " + text, 0);
        }
    }


    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
