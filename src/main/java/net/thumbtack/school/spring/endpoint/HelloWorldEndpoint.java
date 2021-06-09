package net.thumbtack.school.spring.endpoint;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloWorldEndpoint {

    @RequestMapping(value = "/test/{whom}", method = RequestMethod.GET)
    public String helloWorld(@PathVariable("whom") String whom,
                             @RequestParam(value = "caps", required = false, defaultValue = "false") boolean isCaps) {
        String text = "Hello world from " + whom;
        if (isCaps) {
            return text.toUpperCase();
        }
        return text;
    }
}
