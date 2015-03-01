(ns arincide.util
  (:require [clojure.java.io :as io])
  (:gen-class))

(defn load-config [filename]
  (with-open [r (io/reader filename)]
    (read (java.io.PushbackReader. r))))
