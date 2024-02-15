package control;

public class MainConttroller {
}

@controller
public class MainConteroller {

    @GetMapping("/")
    public String index(){
        return "main/index";
    }
}