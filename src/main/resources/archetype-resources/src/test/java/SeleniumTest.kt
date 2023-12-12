package `archetype-resources`.src.test.java
import jdk.incubator.vector.VectorOperators.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver


class SeleniumTest {
    var driver: WebDriver? = null
    @BeforeEach
    fun setUp() {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe")
        driver = ChromeDriver()
        driver.manage().window().maximize()
    }

    @Test
    fun testCadastroUsuario() {
        // Acessar o site
        driver.get("https://automacaocombatista.herokuapp.com/users/new")

        // Preencher os dados do usuário
        driver.findElement(By.id("user_name")).sendKeys("Paulo2")
        driver.findElement(By.id("user_lastname")).sendKeys("Junior1")
        driver.findElement(By.id("user_email")).sendKeys("paulojunior2@teste.com.br")
        driver.findElement(By.id("user_address")).sendKeys("Av. Afonso Pena, 4000")

        // Clicar em "Criar"
        driver.findElement(By.name("commit")).click()

        // Verificar a mensagem de sucesso
        val mensagem: String = driver.findElement(By.id("notice")).getText()
        assertEquals("Usuário Criado com sucesso.", mensagem)
    }

    @Test
    fun testPreencherCampoTexto() {
        driver.get("https://automacaocombatista.herokuapp.com/users/new")

        // Encontrar o campo de texto pelo ID "user_name"
        val campoNome = driver.findElement(By.id("user_name"))

        // Preencher o campo com um valor
        campoNome.sendKeys("ExemploNome")

        // Verificar se o valor foi preenchido corretamente
        assert(campoNome.getAttribute("value") == "ExemploNome") { "O campo de texto não foi preenchido corretamente" }
    }

    @Test
    fun testMoveToElement() {
        driver.get("https://automacaocombatista.herokuapp.com/")
        val elemento = driver.findElement(By.id("user_email")) // Substitua "elementoParaMover" pelo ID real do elemento
        driver.actions().moveToElement(elemento).perform()
    }

    @Test
    fun testSubmit() {
        driver.get("https://automacaocombatista.herokuapp.com/")
        val formulario = driver.findElement(By.id("user_lastname")) // Substitua "formulario" pelo ID real do formulário
        formulario.submit()
        // Adicione verificações adicionais conforme necessário
    }

    @Test
    fun testSelectByIndex() {
        driver.get("https://automacaocombatista.herokuapp.com/")
        val dropdown = driver.findElement(By.id("$0")) // Substitua "seuDropdownId" pelo ID real do dropdown
        val select = Select(dropdown)
        select.selectByIndex(2) // Substitua o índice pela opção desejada
        // Adicione verificações adicionais conforme necessário
    }

    @Test
    fun testPreencherCampoTexto() {
        driver.get("https://automacaocombatista.herokuapp.com/users/new")

        // Encontrar o campo de texto usando By.id()
        val campoNome = driver.findElement(By.id("user_adress"))

        // Preencher o campo com um valor
        campoNome.sendKeys("ExemploAdress")

        // Verificar se o valor foi preenchido corretamente
        assert(campoNome.getAttribute("value") == "ExemploAdress") { "O campo de texto não foi preenchido corretamente" }
    }


    @AfterEach
    fun tearDown() {
        // Fechar o navegador após cada teste
        driver.quit()
    }
}