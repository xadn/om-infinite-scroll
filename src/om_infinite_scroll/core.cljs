(ns om-infinite-scroll.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))
            ; [sablono.core :as html :refer-macros [html]]

(enable-console-print!)
(println "hello")


(defn panel-item [data]
  (let [name "Banh mi selfies shabby chic disrupt polaroid roof party. Portland High Life brunch sustainable, plaid Kickstarter pickled four loko 3 wolf moon whatever."]
    (dom/li #js {:className "is-item"}
      (dom/div #js {} (:id data))
      (dom/div #js {} name)
      )))

; DOM read + set-state
; (defn handleScroll [owner e]
;   (let [node (om/get-node owner)]
;         (om/set-state! owner :scrollTop (.-scrollTop node))))

; DOM read + set-state
(defn handleScroll [owner e]
  (let [node (om/get-node owner)
        scrollTop (.-scrollTop node)
        state (om/get-render-state owner)]
        (if (not= scrollTop (:scrollTop node)) (om/set-state! owner :scrollTop scrollTop))
        ))

; DOM read
; (defn handleScroll [owner e]
;   (let [node (om/get-node owner)]
;         (println (.-scrollTop node))))

; Set-state only
; (defn handleScroll [owner e]
;   (om/set-state! owner :scrollTop 1))

; Nothing
; (defn handleScroll [owner e])

(defn panel [data owner]
  (reify
    om/IRenderState
    (render-state [this state]
      (. js/console (count "render"))
      (dom/div #js {:className "is-panel" :onScroll (partial handleScroll owner)}
        (apply dom/ol #js {:className "is-content"}
          (map (fn [n] (panel-item {:id n})) (range 1 1000)))))
    ))

(om/root panel {:text "Hello world!"} {:target js/document.body})

    ; om/IShouldUpdate
    ; (should-update [this _ nextState]
    ;   false
    ;   )
      ; (let [prevState (om/get-render-state owner)]
        ; (not= (:scrollTop nextState) (:scrollTop prevState))
