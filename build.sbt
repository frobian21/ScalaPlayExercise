name := "ScalaPlayExercise"
 
version := "1.0" 
      
lazy val `scalaplayexercise` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq( jdbc , cache , ws , specs2 % Test )
libraryDependencies += "com.typesafe.play" %% "play" % "2.5.19"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      