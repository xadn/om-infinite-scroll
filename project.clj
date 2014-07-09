(defproject om-infinite-scroll "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2173"]
                 [com.cemerick/clojurescript.test "0.3.1"]
                 [com.cemerick/double-check "0.5.7"]
                 [om "0.6.4"]
                 [sablono "0.2.17"]]

  :plugins [[lein-cljsbuild "1.0.2"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "om-infinite-scroll"
              :source-paths ["src"]
              :compiler {
                :libs [""]
                :output-to "om_infinite_scroll.js"
                :output-dir "out"
                :optimizations :simple
                :preamble ["react/react.js"]
                :externs ["react/externs/react.js"]
                }}]})
