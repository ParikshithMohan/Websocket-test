(ns ^:figwheel-no-load webtest.dev
  (:require
    [webtest.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
