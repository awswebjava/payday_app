package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.deduccionessolapaview", "/web.deduccionessolapaview"})
public final  class deduccionessolapaview extends GXWebObjectStub
{
   public deduccionessolapaview( )
   {
   }

   public deduccionessolapaview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( deduccionessolapaview.class ));
   }

   public deduccionessolapaview( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new deduccionessolapaview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new deduccionessolapaview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "deducciones Solapa View";
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

