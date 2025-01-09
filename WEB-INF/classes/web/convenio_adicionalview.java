package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_adicionalview", "/web.convenio_adicionalview"})
public final  class convenio_adicionalview extends GXWebObjectStub
{
   public convenio_adicionalview( )
   {
   }

   public convenio_adicionalview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_adicionalview.class ));
   }

   public convenio_adicionalview( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_adicionalview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_adicionalview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "convenio_adicional View";
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

