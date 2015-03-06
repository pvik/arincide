(ns arincide.db
  (:require [korma.db :as korma-db]
            [korma.core :as korma-core]
            [clojure.string :as str])
  (:gen-class))


(def properties (util/load-config "conf.clj"))
(def db-properties (:db properties))

(def db-class (:class db-properties))
(def db-protocol (:protocol db-properties))
(def db-subname (:subname db-properties))

;; create a connection map
(def dbmap {:classname   db-class
            :subprotocol db-protocol
            :subname     db-subname
            :delimiters  ""})

;; Pass the connection map to the defdb macro:
(korma-db/defdb db dbmap)

;; Define all table entities

;; Groups Enity
(korma-core/defentity groups
  ;; Basic configuration
  (korma-core/pk :id)
  (korma-core/table :groups)
  (korma-core/database db)
  (korma-core/entity-fields :id :name :category :type)) ;; default fields for selects

;; Groups Enity
(korma-core/defentity permissions
  ;; Basic configuration
  (korma-core/table :permissions)
  (korma-core/database db)
  (korma-core/entity-fields :groupId :access :objectkey :objecttype)) ;; default fields for selects

(korma-core/defentity forms
  ;; Basic configuration
  (korma-core/pk :id) ;; by default "id". This line is unnecessary.
  ;; it's used for relationships joins.
  (korma-core/table :forms) ;; by default the name of the symbol.
  (korma-core/database db) ;; if none is specified the last defdb
  ;; will be used. Also unnecessary.
  (korma-core/entity-fields :id :name :type)) ;; default fields for selects


(defn insert-into
  [table-name field-val-map]
  (korma-core/insert table-name (korma-core/values field-val-map)))
