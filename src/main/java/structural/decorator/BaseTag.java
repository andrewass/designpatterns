package structural.decorator;

public class BaseTag implements HtmlTag{
    
    @Override
    public String wrapTag() {
        return "Hello World";
    }
}
