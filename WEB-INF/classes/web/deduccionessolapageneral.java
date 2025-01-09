package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.deduccionessolapageneral", "/web.deduccionessolapageneral"})
public final  class deduccionessolapageneral extends GXWebObjectStub
{
   public deduccionessolapageneral( )
   {
   }

   public deduccionessolapageneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( deduccionessolapageneral.class ));
   }

   public deduccionessolapageneral( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new deduccionessolapageneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new deduccionessolapageneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "deducciones Solapa General";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

