import org.scalatest.selenium.Chrome
import org.scalatest.{FlatSpec, ShouldMatchers}

/**
  * Created by bgokce on 16/11/2016.
  */
class Apple extends FlatSpec with ShouldMatchers with Chrome{

  val apple = "http://www.apple.com/"
  webDriver.manage().window().setSize(new org.openqa.selenium.Dimension(1000,1000))

  "Apple's home page" should "navigate to all iPhone's information page" in {
    go to apple
    click on className("ac-gn-link-iphone")
    click on cssSelector("a[href='/iphone-7/']")
  }

  "iPhone 7 information page" should "also has keynote and watch the tv adds options" in {
    click on cssSelector("a[href='/apple-events/september-2016/']")
    Thread.sleep(2000)
    find(className("more-link"))
    goBack()
    click on cssSelector("a[href='/iphone-7/films/#film-dive']")
    click on className("modal-close")
    goBack()
  }

  "iPhone 7 information page" should "also has desing and product film videos " in {
    click on cssSelector("a[href='http://images.apple.com/media/us/iphone-7/2016/5937a0dc_edb0_4343_af1c_41ff71808fe5/films/materials/iphone7-materials-tft-cc-us-20160907_1536x640h.mp4']")
    click on className("modal-close")
    click on cssSelector("a[href='http://images.apple.com/media/us/iphone-7/2016/5937a0dc_edb0_4343_af1c_41ff71808fe5/films/feature/iphone7-feature-tft-cc-us-20160907_1536x640h.mp4']")
    click on className("modal-close")
  }

  "iPhone 7 information page" should "also has learn more option" in {
    click on cssSelector("button[data-analytics-title='design - learn more']")
    find(className("card-detail-content"))
    click on xpath("//*[@id=\"design\"]/div[2]/button/span[2]")
  }

  "iPhone 7 information page" should "also navigate to shopping page" in {
    click on className("ac-ln-button")
    find(className("nowrap")).get.text should be ("4.7-inch display")
    click on ("dimensionScreensize-4_7inch-select")
  }

  "Apple shopping page" should "also give another option for simcard" in {
    Thread.sleep(10)
    find(cssSelector("img[src='http://store.storeimages.cdn-apple.com/4973/as-images.apple.com/is/image/AppleInc/aos/published/images/l/og/logo/sprint/logo-sprint-2x?wid=87&hei=37&fmt=png-alpha&qlt=95&.v=P8pkB3']"))
    click on xpath("//*[@id=\"tabs_\"]/fieldset/div[3]/ul/li/div")
    //find(className("as-dimension-title")).get.text should be ("Select your carrier.")
  }

  "Apple shopping page" should "also give color options" in {
    click on xpath("//*[@id=\"tabs_dimensionColor\"]/fieldset/ul/li[4]/div/div[2]/img")
  }

  "Apple shopping page" should "also give different size of capacity" in {
    click on xpath("//*[@id=\"tabs_dimensionCapacity\"]/fieldset/ul/li[3]/div[1]")
    Thread.sleep(10)
    find(xpath("//*[@id='main']/store-provider/step1-modular/materializer[2]/div[1]/summary-builder/div[1]/div[2]/div[1]/form/div/span/button"))
  }

  "Apple shopping page" should "also have add to bag option" in {
    Thread.sleep(5)
    val submitbutton = find(xpath("//*[@id=\"main\"]/store-provider/step1-modular/materializer[2]/div[1]/summary-builder/div[1]/div[2]/div[1]/form/div/span/button"))
    submit()
    click on xpath("//*[@id=\"main\"]/store-provider/step1-modular/materializer[2]/div[1]/summary-builder/div[1]/div[2]/div[1]/form/div/span/button")
    //click on className("ac-gn-link-bag")
    //click on xpath("//*[@id='main']/store-provider/step1-modular/materializer[2]/div[1]/summary-builder/div[1]/accessory-slot/div/div[2]/div/div/div/div[2]")
  }
}
