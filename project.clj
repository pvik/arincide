(defproject arincide "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[ragtime/ragtime.lein "0.3.8"]
            [lein-deps-tree "0.1.2"]]
  :repositories {"local" ~(str (.toURI (java.io.File. "local_maven_repo")))}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.namespace "0.2.10"]
                 [log4j/log4j "1.2.17"]
                 [org.clojure/java.jdbc "0.3.3"]
                 [ragtime/ragtime.sql.files "0.3.8"]
                 [korma "0.4.0"]
                 [com.h2database/h2 "1.4.185"]
                 [com.bmc.arsys/arapi "8.1"]]
  :ragtime {:migrations ragtime.sql.files/migrations
            :database "jdbc:h2:~/.h2db/arincide.db"}
  :main ^:skip-aot arincide.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
