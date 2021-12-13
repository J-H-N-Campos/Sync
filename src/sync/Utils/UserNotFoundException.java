/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Utils;

/**
 *
 * @author mouri
 */
public class UserNotFoundException extends Exception
{
    public UserNotFoundException()
    {
        super("Usuário não localizado");
    }
}
