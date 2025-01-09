package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresa_horasextras_pordia", "/web.empresa_horasextras_pordia"})
public final  class empresa_horasextras_pordia extends GXWebObjectStub
{
   public empresa_horasextras_pordia( )
   {
   }

   public empresa_horasextras_pordia( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresa_horasextras_pordia.class ));
   }

   public empresa_horasextras_pordia( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresa_horasextras_pordia_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresa_horasextras_pordia_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa_horasextras_por Dia";
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

