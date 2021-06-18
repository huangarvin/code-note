package main

import (
	"fmt"
	"github.com/casbin/casbin/v2"
)

func main() {
	enforcer, err := casbin.NewEnforcer("casbin_test/main/conf.d/model_restful.conf", "casbin_test/main/conf.d/policy.csv")
	if nil != err {
		fmt.Println("enforcer load error", err)
		return
	}
	ok, err := enforcer.Enforce("yitian", "tuya.com.feng", "POST")

	if nil != err {
		fmt.Println("enforcer error", ok)
		return
	}
	fmt.Println("enforcer is", ok)

	user, err := enforcer.GetDomainsForUser("alice")
	if err == nil {
		fmt.Println(user)
	}
}
