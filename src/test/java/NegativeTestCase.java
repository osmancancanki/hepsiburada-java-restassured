import org.junit.Test;

public class NegativeTestCase {
    TestRequest testRequest = new TestRequest();

    @Test
    public void checkProductByWrongName(){
        testRequest.getProductByWrongName("wrong");
    }

    @Test
    public void addProductWithWrongInfo(){
        testRequest.postProduct();
    }
}
