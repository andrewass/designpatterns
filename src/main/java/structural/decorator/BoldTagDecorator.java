package structural.decorator;

public class BoldTagDecorator extends TagDecorator {

    public BoldTagDecorator(HtmlTag decoratedTag) {
        super(decoratedTag);
    }

    @Override
    public String wrapTag(){
        return "<b> " + super.wrapTag() + " </b>";
    }
}
