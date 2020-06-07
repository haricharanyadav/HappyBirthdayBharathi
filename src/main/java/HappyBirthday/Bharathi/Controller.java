package HappyBirthday.Bharathi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@RestController
public class Controller {

    @Autowired
    private MyResourceHttpRequestHandler handler;

    @Component
    final static class MyResourceHttpRequestHandler extends ResourceHttpRequestHandler {

        private final static String ATTR_FILE = MyResourceHttpRequestHandler.class.getName() + ".file";

        @Override
        protected Resource getResource(HttpServletRequest request) throws IOException {

            final File file = (File) request.getAttribute(ATTR_FILE);
            return new FileSystemResource(file);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String welcome() {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/main/java/index.html"));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }
        String content = contentBuilder.toString();
            return  content;
        }

    @RequestMapping(method = RequestMethod.GET, value = "/index.js")
    public String js() {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/main/java/index.js"));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }
        String content = contentBuilder.toString();
            return  content;
        }

    @RequestMapping(method = RequestMethod.GET, value = "/index.css")
    public String css() {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/main/java/index.css"));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }
        String content = contentBuilder.toString();
            return  content;
        }

    @RequestMapping(value = "/sendAnswer", method = RequestMethod.POST)
    public ResponsePojo answer(@RequestBody RequestPojo request) {
        System.out.println(request.getQuestion()+"/n"+ "Ans: "+request.getAns());

        if(request.getQuestionNumber().equals("First")) {
            ResponsePojo res = new ResponsePojo();
            res.setQuestionNumber("Second");
            res.setQuestion("Whom do you like the most?");
            res.setOption1("Niharika");
            res.setOption2("Lasya");
            res.setOption3("Akhil");
            res.setImage("/image/second.PNG");
            return res;
        }
        else if(request.getQuestionNumber().equals("Second")) {
            ResponsePojo res = new ResponsePojo();
            res.setQuestionNumber("Third");
            res.setQuestion("Whom do you hate the most?");
            res.setOption1("Niharika");
            res.setOption2("Lasya");
            res.setOption3("Peddireddy");
            res.setImage("/image/third.JPG");
            return res;
        }
        else if(request.getQuestionNumber().equals("Third")) {
            ResponsePojo res = new ResponsePojo();
            res.setQuestionNumber("Fourth");
            res.setQuestion("What do you desire the most?");
            res.setOption1("To Do Drugs");
            res.setOption2("To Drink Alcohol");
            res.setOption3("To have Boyfriend");
            res.setImage("/image/fourth.png");
            return res;
        }
        else if(request.getQuestionNumber().equals("Fourth")) {
            ResponsePojo res = new ResponsePojo();
            res.setQuestionNumber("Fifth");
            res.setQuestion("What is the one thing, you want to change about yourself?");
            res.setOption1("My Brain");
            res.setOption2("My Attitude");
            res.setOption3("My Life");
            res.setImage("/image/fifth.PNG");
            return res;
        }
        else if(request.getQuestionNumber().equals("Fifth")) {
            ResponsePojo res = new ResponsePojo();
            res.setQuestionNumber("Sixth");
            res.setQuestion("What do you want for this birthday?");
            res.setOption1("A kiss from someone SPECIAL!");
            res.setOption2("To Kill someone");
            res.setOption3("To Marry someone SPECIAL!");
            res.setImage("/image/sixth.JPG");
            return res;
        }
        else if(request.getQuestionNumber().equals("Sixth")) {
            ResponsePojo res = new ResponsePojo();
            res.setQuestionNumber("Seventh");
            res.setQuestion("If you were to become a boy now, Who would you date?");
            res.setOption1("Niharika");
            res.setOption2("Lasya");
            res.setOption3("Yourself(as girl)");
            res.setImage("/image/seventh.PNG");
            return res;
        }
        else  if(request.getQuestionNumber().equals("Seventh")) {
            ResponsePojo res = new ResponsePojo();
            res.setQuestionNumber("Eighth");
            res.setQuestion("What superpower to do want?");
            res.setOption1("Flying");
            res.setOption2("Invisibility");
            res.setOption3("Speed");
            res.setImage("/image/eighth.JPG");
            return res;
        }
        else {
            return null;

        }
    }

    private ResourceLoader resourceLoader = new DefaultResourceLoader();

    @ResponseBody
    @RequestMapping(value = "/image/{image}",  produces = "image/bmp")
    public Resource texture(@PathVariable("image") String image) {
        return resourceLoader.getResource(image);
    }

}
