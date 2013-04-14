(ns org.scauhci.dispenser.routes
  (:use [compojure.core])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [cheshire.core :refer :all :as json]
            [org.scauhci.dispenser.controllers :as controllers]))

(defroutes app-routes
  (GET "/status" [] (controllers/get-status))
  (POST "/status" {body :body} (controllers/set-status (json/parse-string (slurp body))))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
