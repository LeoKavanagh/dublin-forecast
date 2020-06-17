import $ivy.`com.lihaoyi::requests:0.5.1` // mill

import requests._
import sys._

// updated at 6pm
val url = "https://www.met.ie/Open_Data/xml/xDublin.xml"
val lambda_url = sys.env("LAMBDA_URL")

val response = requests.get(url)

val xml_response = xml.XML.loadString(response.text)

xml_response.foreach(println)

val tomorrow: Map[String, String] = Map("msg" -> (xml_response \ "tomorrow")
  .text
  .replace("\n", "")
  )

requests.post(lambda_url, headers=tomorrow)

