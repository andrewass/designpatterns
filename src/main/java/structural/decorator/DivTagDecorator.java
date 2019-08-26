package structural.decorator;

public class DivTagDecorator extends TagDecorator  {

    public DivTagDecorator(HtmlTag decoratedTag){
        super(decoratedTag);
    }

    @Override
    public String wrapTag() {
        return "<div> "+super.wrapTag()+" </div>";
    }
}
