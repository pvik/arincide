(ns arincide.arapi.maps
  (:import [com.bmc.arsys.api Constants])
  (:gen-class))

(def fieldDataTypeMap
  {(Constants/AR_DATA_TYPE_ATTACH)         "Attachment"
   (Constants/AR_DATA_TYPE_ATTACH_POOL)    "Attachment Pool"
   (Constants/AR_DATA_TYPE_BITMASK)        "Bitmask"
   (Constants/AR_DATA_TYPE_BYTES)          "Bytes"
   (Constants/AR_DATA_TYPE_CHAR)           "Character"
   (Constants/AR_DATA_TYPE_COLUMN)         "Column"
   (Constants/AR_DATA_TYPE_CONTROL)        "Control - Button"
   (Constants/AR_DATA_TYPE_COORDS)         "Coordinate"
   (Constants/AR_DATA_TYPE_CURRENCY)       "Currency"
   (Constants/AR_DATA_TYPE_DATE)           "Date"
   (Constants/AR_DATA_TYPE_DECIMAL)        "Decimal"
   (Constants/AR_DATA_TYPE_DIARY)          "Diary"
   (Constants/AR_DATA_TYPE_DISPLAY)        "Display"
   (Constants/AR_DATA_TYPE_ENUM)           "Enum"
   (Constants/AR_DATA_TYPE_INTEGER)        "Integer"
   (Constants/AR_DATA_TYPE_JOIN)           "Join"
   (Constants/AR_DATA_TYPE_KEYWORD)        "Keyword"
   (Constants/AR_DATA_TYPE_NULL)           "NULL"
   (Constants/AR_DATA_TYPE_PAGE)           "Page"
   (Constants/AR_DATA_TYPE_PAGE_HOLDER)    "Page Holder"
   (Constants/AR_DATA_TYPE_REAL)           "Real"
   (Constants/AR_DATA_TYPE_TABLE)          "Table"
   (Constants/AR_DATA_TYPE_TIME)           "Time"
   (Constants/AR_DATA_TYPE_TIME_OF_DAY)    "Time of Day"
   (Constants/AR_DATA_TYPE_TRIM)           "Trim"
   (Constants/AR_DATA_TYPE_ULONG)          "Unsigned Long"
   (Constants/AR_DATA_TYPE_UNKNOWN)        "Unknown"
   (Constants/AR_DATA_TYPE_VALUE_LIST)     "Value List"
   (Constants/AR_DATA_TYPE_VIEW)           "View"})

(def formTypeMap
  {1 "BASE" 2 "JOIN" 3 "VIEW" 4 "DISPLAY"})

(def fieldAuditOptionMap
  {(Constants/AR_AUDIT_COPY)  "Copy"
   (Constants/AR_AUDIT_LOG)   "Log"
   (Constants/AR_AUDIT_NONE)  "None"})

(def fieldEntryModeMap
  {(Constants/AR_FIELD_OPTION_REQUIRED) "Required"
   (Constants/AR_FIELD_OPTION_OPTIONAL) "Optional"
   (Constants/AR_FIELD_OPTION_SYSTEM)   "System"
   (Constants/AR_FIELD_OPTION_DISPLAY)  "Display Only"})

(def fieldCreateModeMap
  {1 "Yes" 2 "No"})
