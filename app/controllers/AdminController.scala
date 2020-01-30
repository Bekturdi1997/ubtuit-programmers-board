package controllers

import akka.util.Timeout
import com.typesafe.scalalogging.LazyLogging
import javax.inject._
import org.webjars.play.WebJarsUtil
import play.api.mvc._
import views.html.admin._

import scala.concurrent.ExecutionContext
import scala.concurrent.duration.DurationInt

@Singleton
class AdminController @Inject()(val controllerComponents: ControllerComponents,
                                implicit val webJarsUtil: WebJarsUtil,
                                indexTemplate: index,
                              )
                               (implicit val ec: ExecutionContext)
  extends BaseController with LazyLogging {

  implicit val defaultTimeout: Timeout = Timeout(60.seconds)

  def index = Action {
    Ok(indexTemplate())
  }

  def createLanguage: Action[JsValue] = Action.async(parse.json) { implicit request =>
    val name = (request.body \ "name").as[String]
    val logo = (request.body \ "logo").as[String]

  }

}
