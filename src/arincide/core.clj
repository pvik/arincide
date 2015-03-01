(ns arincide.core
  (:require [arincide.db :as db]
            [arincide.util :as util]
            [arincide.arapi.core :as arapi]
            [clojure.tools.namespace.repl :refer [refresh]]
            [clojure.pprint :refer [pprint]])
  (:gen-class))

(def properties (util/load-config "conf.clj"))
(def ars-properties (:ars properties))

(def ars-server (:server ars-properties))
(def ars-port (:port ars-properties))
(def ars-username (:username ars-properties))
(def ars-password (:password ars-properties))

;; Create connection to ARS
(def arConn (arapi/connect ars-server ars-port ars-username ars-password))

;; for debugging
(def forms (arapi/forms arConn))
(def form (first forms))
(def formd (arapi/form-details form))
(def fields (arapi/fields arConn (:name formd)))
(def field (first fields))
(def fieldd (arapi/field-details field))

(defn -main
  [& args]
  (println "Processing Groups")
  (let [groups (arapi/groups arConn)
        group-details (reduce #(conj % (arapi/group-details %2)) [] groups)]
    (reduce #(db/insert-into db/groups %2) group-details)
    (reduce #(println %2) group-details)))
