package structural.decorator;

public class ParagraphTagDecorator extends TagDecorator {

    public ParagraphTagDecorator(HtmlTag decoratedTag){
        super(decoratedTag);
    }

    @Override
    public String wrapTag() {
        return "<p> "+super.wrapTag()+" </p>";
    }
}
