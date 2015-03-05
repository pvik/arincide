(ns arincide.arapi.core
  (:import [com.bmc.arsys.api ARServerUser Constants])
  (:require [arincide.arapi.maps :as constant-maps])
  (:gen-class))

(defn connect
  "Connects to the AR Server and returns a ARServerUser object"
  [server port user password]
  (new ARServerUser user password nil nil server port))


;; Object retreivers

;; Groups
(defn groups
  "Retreives all the groups from ARS"
  [arConn]
  (.getListGroup arConn nil nil))

;; Users
(defn users
  "Retreives all registered users from ARS"
  [arConn]
  (.getListUser arConn Constants/AR_USER_LIST_REGISTERED))

;; Menus
(defn menus
  "Retreive all Menus from ARS"
  [arConn]
  (reduce #(conj % (.getMenu arConn %2 nil)) [] (.getListMenu arConn 0 nil nil)))

;; Forms
(defn forms
  "Retreives all forms from ARS"
  [arConn]
  (.getListFormObjects arConn 0 Constants/AR_LIST_SCHEMA_ALL nil nil nil))

;; Views
(defn views
  "Retreives all Views for the given Form"
  [arConn form]
  (.getListViewObjects arConn form 0 nil))

;;Fields
(defn fields
  "Retreives all fields in the given Form"
  [arConn form]
  (.getListFieldObjects arConn form))

;; Active Links


;; Filters


;; Escalations


;; helper functions to constant map

(defn make-positive [int]
  (* (Long/signum int) int))

(defn getFormId [form]
  (make-positive (.hashCode form)))

(defn getFormType [formType]
  (get constant-maps/formTypeMap formType "Invalid Form Type"))

(defn getFieldType [dataType]
  (get constant-maps/fieldDataTypeMap dataType "Invalid Data Type"))

(defn getFieldAuditOption [auditType]
  (get constant-maps/fieldAuditOptionMap auditType "Invalid Audit Type"))

(defn getFieldEntryMode [entryMode]
  (get constant-maps/fieldEntryModeMap entryMode "Invalid Entry Mode"))

(defn getFieldCreateMode [createMode]
  (get constant-maps/fieldCreateModeMap createMode "Invalid Create Mode"))


;; *-detail functions to generate maps for AR Objects

(defn permission-details [permission objectId objectType]
  {:groupid (.getGroupID permission)
   :access (.getPermissionValue permission)
   :objectid objectId
   :objecttype (.toUpperCase objectType)})

(defn group-details [group]
  {:id (.getId group) :name (.getName group) :type (.getGroupType group) :category (.getCategory group)})

(defn user-details [user]
  {:name (.getUserName user)
   :email (.getEmailAddress user)})

(defn form-details [form]
  {:id (getFormId form)
   :key (.getKey form)
   :name (.getName form)
   :owner (.getOwner form)
   :type (getFormType (.getFormType form))
   :defaultvui (.getDefaultVUI form)
   :helptext (.getHelpText form)
   :lastupdatetime (.getValue (.getLastUpdateTime form))
   :lastchangedby (.getLastChangedBy form)
   :permission (reduce #(conj % (permission-details %2 (getFormId form) "form")) [] (.getPermissions form))})

(defn field-details [field]
  {:id (.getFieldID field)
   :entrymode (getFieldEntryMode (.getFieldOption field))
   :name (.getName field)
   :type (getFieldType (.getDataType field))
   :defaultvalue (.toString (.getDefaultValue field))
   :auditoption (getFieldAuditOption (.getAuditOption field))
   :owner (.getOwner field)
   :lastupdatetime (.getValue (.getLastUpdateTime field))
   :lastchangedby (.getLastChangedBy field)
   :createmode (getFieldCreateMode (.getCreateMode field)) ;; allow any user to submit
   :permission (reduce #(conj % (permission-details %2 (.getFieldID field) "field")) [] (.getAssignedGroup field))
   })
