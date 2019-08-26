package structural.decorator;

/**
 * A class forming a base for each decorator variant
 */
public abstract class TagDecorator implements HtmlTag{

    private final HtmlTag decoratedTag;

    public TagDecorator(HtmlTag decoratedTag){
        this.decoratedTag = decoratedTag;
    }

    @Override
    public String wrapTag() {
        return decoratedTag.wrapTag();
    }
}
