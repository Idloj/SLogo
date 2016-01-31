name := "SLogo"

version := "1.0"

mainClass := Some("slogo.SLogo")

scalaSource in Compile <<= baseDirectory(_ / "src")
