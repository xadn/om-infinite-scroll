(ns om-infinite-scroll.core
  (:require [om.core :as om :include-macros true]
            [sablono.core :as html :refer-macros [html]]
            [clojure.test.check.generators :as gen]
            ))

(enable-console-print!)

(println "hello")

(defn widget [data]
  (om/component
   (html [:div {:className "is-panel"}
          [:ol {:className "is-content"} (for [n (range 1 1000)]
                 [:li {:className "is-item"}
                   [:div "Banh mi selfies shabby chic disrupt polaroid roof party. Portland High Life brunch sustainable, plaid Kickstarter pickled four loko 3 wolf moon whatever."]
                 ])]])))

(om/root widget {} {:target js/document.body})