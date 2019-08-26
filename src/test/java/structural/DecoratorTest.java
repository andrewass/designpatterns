package structural;

import org.junit.jupiter.api.Test;
import structural.decorator.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoratorTest {

    @Test
    void shouldCreateSequenceOfHtmlTags() {
        HtmlTag wrappedTags = new DivTagDecorator(
                new ParagraphTagDecorator(
                        new BoldTagDecorator(
                                new BaseTag())));

       assertEquals("<div> <p> <b> Hello World </b> </p> </div>", wrappedTags.wrapTag());
    }
}
