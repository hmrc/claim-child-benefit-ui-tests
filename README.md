# claim-child-benefit-ui-tests

## Running the tests

To executing the tests ensure you start service profile:
 
    sm2 --start CLAIM_CHILD_BENEFIT_ALL --clean --wait 100


Using the `--wait 100` argument ensures a health check is run on all the services started as part of the profile. `100` refers to the given number of seconds to wait for services to pass health checks.

Then execute the `run_tests.sh` script:

    ./run_tests.sh

The `run_tests.sh` script defaults to using `chrome` in the `local` environment.  For a complete list of supported param values, see:
 - `src/test/resources/application.conf` for **environment** 
 - [webdriver-factory](https://github.com/hmrc/webdriver-factory#2-instantiating-a-browser-with-default-options) for **browser-driver**