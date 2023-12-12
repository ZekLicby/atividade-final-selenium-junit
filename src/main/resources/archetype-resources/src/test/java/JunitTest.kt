package archetype-resources.src.test.java
import jdk.incubator.vector.VectorOperators.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class JunitTest {

    private lateinit var driver: WebDriver

    @BeforeEach
    fun setUp() {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe")
        driver = ChromeDriver()
        driver.manage().window().maximize()
    }

    @Test
    fun testTituloPagina() {
        driver.get("https://automacaocombatista.herokuapp.com/")
        val titulo = driver.title
        val expectedTitulo = "Título Esperado"
        assertEquals(expectedTitulo, titulo)
    }
    @Test
    fun testElementoPresente() {
        driver.get("https://automacaocombatista.herokuapp.com/")
        val elemento = driver.findElement(By.id("$0")) 
        assertTrue(elemento.isDisplayed)
    }

    @Test
    fun testElementoAusente() {
        driver.get("https://automacaocombatista.herokuapp.com/")
        val elemento = driver.findElement(By.id("merlin-preview-link")) 
        assertTrue(elemento.isDisplayed)
    }

    @Test
    fun testElementoBtn() {
        driver.get("https://automacaocombatista.herokuapp.com/")
        val elemento = driver.findElement(By.id("merlin-context-btn")) 
        assertTrue(elemento.isDisplayed)
    }
    
    @After
    fun tearDown() {
        driver.quit()
    }
}