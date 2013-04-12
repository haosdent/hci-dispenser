(ns hci-dispenser.handler
  (:use compojure.core
        org.scauhci.dispenser.controllers
        )
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/status" [] "0")
  (POST "/status" [] "0")
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
