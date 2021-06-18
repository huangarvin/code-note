package main

import (
	"fmt"
	"github.com/casbin/casbin/v2"
	"testing"
)

func TestAcl(test *testing.T) {
	enforcer, _ := casbin.NewEnforcer("conf.d/model_acl.conf", "conf.d/policy.csv")
	ok, _ := enforcer.Enforce("yitian", "tuya.com.feng", "POST")
	fmt.Println("enforcer is", ok)
}

func TestRBAC(t *testing.T) {
	enforcer, _ := casbin.NewEnforcer("conf.d/model_rbac.conf", "conf.d/policy_rbac.csv")
	ok, _ := enforcer.Enforce("yitian", "tuya.com.feng", "POST")
	fmt.Println("enforcer is", ok)
	user, _ := enforcer.GetRolesForUser("yitian")
	fmt.Println(user)
}

func TestRBACDom(t *testing.T) {
	enforcer, _ := casbin.NewEnforcer("conf.d/model_rbac_dom.conf", "conf.d/policy_rbac_dom.csv")
	ok, _ := enforcer.Enforce("yitian", "tuya.com.feng", "POST")
	fmt.Println("enforcer is", ok)
	user, _ := enforcer.GetRolesForUser("yitian")
	fmt.Println(user)
	subjects := enforcer.GetAllSubjects()
	fmt.Println(subjects)
	role, _ := enforcer.GetUsersForRole("admin")
	fmt.Println(role)
}

func TestABAC(t *testing.T) {

}

func TestRESTFul(t *testing.T) {

}
