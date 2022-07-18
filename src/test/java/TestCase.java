import org.junit.Test;

public class TestCase {
    TestRequest testRequest = new TestRequest();

    @Test
    public void checkAllProducts(){
        testRequest.getAllProducts();
    }

    @Test
    public void checkProductByName(){
        testRequest.getProductByName("Apple");
    }

    @Test
    public void addProduct(){
        testRequest.postProduct();
    }
}
