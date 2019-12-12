package opsas.conf

import auth.Role
import auth.User
import auth.UserRole

import javax.jws.soap.SOAPBinding

class BootStrap {

    def init = { servletContext ->
        def adminRole = Role.findOrSaveWhere(authority: "ROLE_ADMIN");
        def userRole = Role.findOrSaveWhere(authority: "ROLE_USER");

        def admin = User.findOrSaveWhere(username:'admin',password: 'admin',firstName: 'Adm',lastName: 'Mda',email: 'adm@adm.com')
        def user = User.findOrSaveWhere(username:'usr',password: 'usr1234',firstName: 'User',lastName: '1',email: 'usr@usr.com')

        if(!admin.authorities.contains(adminRole)){
            UserRole.create(admin,adminRole,true)
        }

        if(!user.authorities.contains(userRole)){
            UserRole.create(user,userRole,true)
        }





    }
    def destroy = {
    }
}
