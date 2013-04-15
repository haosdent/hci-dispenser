(defproject hci-dispenser "0.1.0-SNAPSHOT"
  :description "The server side of hci-dispenser."
  :url "https://github.com/haosdent/hci-dispenser"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.5"]]
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler org.scauhci.dispenser.routes/app}
  :profiles
  {:dev {:dependencies [
                        [ring-mock "0.1.3"]
                        [cheshire "5.1.1"]
                        ]}})
