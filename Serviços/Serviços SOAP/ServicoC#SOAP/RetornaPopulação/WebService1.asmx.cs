using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
namespace RetornaPopulação{
    /// <summary>
    /// Descrição resumida de WebService1
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que esse serviço da web seja chamado a partir do script ...
    //usando ASP.NET AJAX, remova os comentários da linha a seguir. 
    // [System.Web.Script.Services.ScriptService]
    public class WebService1 : System.Web.Services.WebService
    {
        [WebMethod]
        public int HelloWorld(string cidade){
            if (cidade == "CAICO"){
                return 67747;
            }
            else if (cidade == "SANTA CRUZ"){
                return 38538;
            }
            else if (cidade == "JARDIM DO SERIDO"){
                return 12566;
            }
            else if (cidade == "JARDIM DE PIRANHA"){
                return 14139;
            }
            else if (cidade == "CURRAIS NOVOS") {
                return 45060;
            }
            return 0;
        }
    }
}
