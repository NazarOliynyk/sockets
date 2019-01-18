package oktenweb.sockets.controllers;

import oktenweb.sockets.models.InputModel;
import oktenweb.sockets.models.OutputModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    // it gets an incoming message and gives it back throug OutputModel
    @MessageMapping("/msg")
    @SendTo("/chanelName/outPoint")
    public OutputModel greeting(InputModel message) throws Exception{
        System.out.println(message);
        return new OutputModel(message);
    }
}
// try sending messages from 2 different browser windows - it allows
// to create a chat to
