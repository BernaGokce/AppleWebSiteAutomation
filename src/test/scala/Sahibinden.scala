import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.support.ui.ExpectedCondition
import org.scalatest._
import org.scalatest.selenium.Chrome
import org.scalatest.time.{Seconds, Span}

/**
  * Created by bgokce on 15/11/2016.
  */
class Sahibinden extends FlatSpec with  ShouldMatchers with Chrome {

  val host = "https://www.sahibinden.com/"
  webDriver.manage().window().setSize(new org.openqa.selenium.Dimension(1000,1000))

  "Sahibindenin ana sayfasindan" should "kiralik ve satilik ev sayfasina" in {
    go to host
    textField("searchText").value = "bostanci"
    click on cssSelector("button[type='submit']")
    textField("price_min").value = "500000"
    textField("price_max").value = "1000000"
    textField("a24_min").value = "110"
    textField("a24_max").value = "220"
    click on className("facetedCheckbox")
    close()
    //click on cssSelector(".checked")





    //click on partialLinkText("a[data-value='38473")
    //click on xpath("//a[data-value='38473']")
    //find("js-attribute facetedCheckbox checked")
    // find("i[tabindex='3']")
    //checkbox("a[data-value='38473']").select()
    //click on cssSelector("img[title='E5 YANI METROBÜS DURAĞINDA ŞARTSIZ KOŞULSUZ GÜNLÜK LÜX DAİRELER']")



  }

}
