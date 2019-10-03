package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def home = myhome("")

  def yourhome = Action {implicit request:Request[AnyContent] =>
    Redirect(routes.Application.myhome("Fabian")).flashing("fromYourHome" -> ". I know it's you")
  }

  def myhome(id: String) = Action { implicit request:Request[AnyContent] =>
    request.session.get("count").map {
      count =>  Ok(views.html.home(s"This is the nice new home page${request.flash.get("fromYourHome").getOrElse("")}${if (!id.equals("")) s", $id" else ""}, version number $count, I hope you like it ;)")).withSession("count" -> (count.toInt+1).toString)
    }.getOrElse{
      Ok(views.html.home(s"This is the home page${if (!id.equals("")) s", $id" else ""} I hope you like it ;)")).withSession("count" -> (1).toString)
    }
  }

  def about = Action{
    InternalServerError("")
  }

}