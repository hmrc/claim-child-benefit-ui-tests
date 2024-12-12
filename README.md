# claim-child-benefit-ui-tests

## Running the tests

Prior to executing the tests ensure you have:
 - Docker - to run mongo inside a container 
 - Installed/configured [service manager](https://github.com/hmrc/service-manager).  

Run the following command to start services locally:

```sm2 --start CLAIM_CHILD_BENEFIT_ALL```

Then execute the `run_tests.sh` script:

    ./run_tests.sh

The `run_tests.sh` script defaults to using `chrome` in the `local` environment.  For a complete list of supported param values, see:
 - `src/test/resources/application.conf` for **environment** 
 - [webdriver-factory](https://github.com/hmrc/webdriver-factory#2-instantiating-a-browser-with-default-options) for **browser-driver**