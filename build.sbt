name := "SLogo"

version := "1.0"

mainClass := Some("slogo.SLogo")

scalaSource in Compile <<= baseDirectory(_ / "src")

scalacOptions ++= "-deprecation -feature -language:implicitConversions".split(" ").toSeq
