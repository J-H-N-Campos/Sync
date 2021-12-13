/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Utils;


import java.util.List;
import sync.View.TelaLogin;


/**
 *
 * @author mouri
 */
public class Authenticator
{
    private List<? extends GenericUser> validUsers;
    private GenericUser loggedUser;

    public Authenticator(List<? extends GenericUser> validUsers)
    {
        this.validUsers = validUsers;
        this.loggedUser = null;
    }
    
    public void runAuthentication()
    {
        runAuthentication( null );
    }
    
    public void runAuthentication( java.awt.Frame parent )
    {
        TelaLogin l = new TelaLogin(parent, this);
        l.setVisible(true);
    }

    public GenericUser getLoggedUser()
    {
        return loggedUser;
    }

    public void setLoggedUser(GenericUser loggedUser)
    {
        this.loggedUser = loggedUser;
    }
    
    public void validate( String login, String pw ) throws UserNotFoundException, PasswordException
    {
        boolean ok = false;
        GenericUser loggedUser = null;
        for (GenericUser user: validUsers)
        {
            if (user.getLogin().equals(login) )
            {
                loggedUser = user;
                ok = true;
            }
        }
        if (ok)
        {           
//            System.out.println(loggedUser.getPassword());
//            System.out.println(Encriptation.criptografar(pw));
            if (loggedUser.getPassword().equals( Encriptation.criptografar(pw) ))
            {
                this.loggedUser = loggedUser;
            }
            else
            {
                this.loggedUser = null;
                throw new PasswordException("");
            }
        }
        else
        {
            throw new UserNotFoundException();
        }
    }
}
