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
	var policys = make([][]string, 0, 10)
	var policy = make([]string, 0, 10)
	policys = append(policys, policy)
	enforcer.AddPolicies(policys)

	fmt.Println("enforcer is", ok)
	user, _ := enforcer.GetRolesForUser("alice")
	fmt.Println("GetRolesForUser yitian: ", user)
	subjects := enforcer.GetAllSubjects()
	fmt.Println("AllSubject: ", subjects)
	role, _ := enforcer.GetUsersForRole("yitian")
	fmt.Println("GetUsersForRole yitian: ", role)
	roles := enforcer.GetAllRoles()
	fmt.Println("roles: ", roles)
}

func TestRBACDom(t *testing.T) {
	enforcer, _ := casbin.NewEnforcer("conf.d/model_rbac_dom.conf", "conf.d/policy_rbac_dom.csv")
	ok, _ := enforcer.Enforce("yitian", "tuya.com.feng", "POST")
	fmt.Println("enforcer is", ok)
	user, _ := enforcer.GetRolesForUser("alice")
	fmt.Println("GetRolesForUser yitian: ", user)
	subjects := enforcer.GetAllSubjects()
	fmt.Println("AllSubject: ", subjects)
	role, _ := enforcer.GetUsersForRole("admin")
	fmt.Println("GetUsersForRole admin: ", role)
	roles := enforcer.GetAllRoles()
	fmt.Println(roles)
	manager := enforcer.GetRoleManager()
	fmt.Println(manager.PrintRoles())
}

func TestABAC(t *testing.T) {

}

func TestRESTFul(t *testing.T) {

}
