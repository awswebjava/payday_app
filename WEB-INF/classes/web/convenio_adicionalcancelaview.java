package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_adicionalcancelaview", "/web.convenio_adicionalcancelaview"})
public final  class convenio_adicionalcancelaview extends GXWebObjectStub
{
   public convenio_adicionalcancelaview( )
   {
   }

   public convenio_adicionalcancelaview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_adicionalcancelaview.class ));
   }

   public convenio_adicionalcancelaview( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_adicionalcancelaview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_adicionalcancelaview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "convenio_adicional Cancela View";
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

