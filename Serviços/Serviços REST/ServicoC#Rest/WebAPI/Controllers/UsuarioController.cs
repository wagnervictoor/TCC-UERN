using System.Collections.Generic;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace WebAPI.Controllers
{

    [RoutePrefix("api/retornaPopulacao")]
    public class UsuarioController : ApiController
    {   

        [AcceptVerbs("GET")]
        [Route("retornaPopulacao/{cidade}")]
        public int retornaPopulacao(string Cidade)
        {
            if (Cidade.Equals("CAICO"))
            {
                return 67747;
            }
            else if (Cidade.Equals("SANTA CRUZ"))
            {
                return 38538;
            }
            else if (Cidade.Equals("JARDIM DO SERIDO"))
            {
                return 12566;
            }
            else if (Cidade.Equals("JARDIM DE PIRANHA"))
            {
                return 14139;
            }
            else if (Cidade.Equals("CURRAIS NOVOS"))
            {
                return 45060;
            }
            return 0;
        }

    }
}