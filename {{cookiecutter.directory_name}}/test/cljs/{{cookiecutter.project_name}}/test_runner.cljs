(ns chromatica2.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [chromatica2.core-test]
   [chromatica2.common-test]))

(enable-console-print!)

(doo-tests 'chromatica2.core-test
           'chromatica2.common-test)
