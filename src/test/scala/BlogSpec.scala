import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest.selenium.{Chrome, HtmlUnit}
import org.scalatest.time.{Seconds, Span}
import org.scalatest.{FlatSpec, ShouldMatchers}

/**
  * Created by bgokce on 14/11/2016.
  */
class BlogSpec extends FlatSpec with ShouldMatchers with Chrome {

  val host = "https://mobile.twitter.com/login"
  webDriver.manage().window().setSize(new org.openqa.selenium.Dimension(1000,2000))


  "The twitter home page" should "navigate to login page with incorrect passwords" in {
    go to host
    executeScript("window.resizeTo(1000,10000)")
    textField("session[username_or_email]").value = "bernottit"
    pwdField("session[password]").value = "dfdsfdsf"
    submit()
    pageTitle should be ("Log in")
    //implicitlyWait(Span(10, Seconds))
  }

  "The twitter home page" should "navigate to user page with correct passwords" in {
    go to host
    textField("session[username_or_email]").value = "bernottit"
    pwdField("session[password]").value = "Kubber2992"
    submit()
    click on cssSelector("img[alt='Berna Gokce']")
    find(cssSelector("h1[role='heading']")).get.text should be ("Berna Gokce")
    //deneme should be "Berna Gokce"
    close()

  }

}
