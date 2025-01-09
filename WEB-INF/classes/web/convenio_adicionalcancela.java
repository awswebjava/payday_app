package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_adicionalcancela", "/web.convenio_adicionalcancela"})
public final  class convenio_adicionalcancela extends GXWebObjectStub
{
   public convenio_adicionalcancela( )
   {
   }

   public convenio_adicionalcancela( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_adicionalcancela.class ));
   }

   public convenio_adicionalcancela( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_adicionalcancela_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_adicionalcancela_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "convenio_adicional Cancela";
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

