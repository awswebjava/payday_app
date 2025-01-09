package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_adicionalww", "/web.convenio_adicionalww"})
public final  class convenio_adicionalww extends GXWebObjectStub
{
   public convenio_adicionalww( )
   {
   }

   public convenio_adicionalww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_adicionalww.class ));
   }

   public convenio_adicionalww( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_adicionalww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_adicionalww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " convenio_adicional";
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

