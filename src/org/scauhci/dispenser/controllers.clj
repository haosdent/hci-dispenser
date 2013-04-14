(ns org.scauhci.dispenser.controllers
  (:use compojure.core))

(def status (atom 0))

(defn get-status []
  (str @status))

(defn set-status [body]
  (str (reset! status (body "status"))))
