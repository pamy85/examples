package wecc.examples.springboot.test.mockito.components;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wecc.examples.springboot.test.mockito.entities.Product;
import wecc.examples.springboot.test.mockito.repositories.ProductRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class DatabaseLoaderTests {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private DatabaseLoader databaseLoader;

    @Before
    public void setUp(){
        databaseLoader = new DatabaseLoader(productRepository);
    }

    @Test
    public void checkLoader(){

        // mock
        when(productRepository.save(any(Product.class))).thenReturn(new Product());

        // then
        databaseLoader.initDatabase();

        // check
        verify(productRepository, times(2)).save(any(Product.class));

    }

}
