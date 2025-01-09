package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.calculoview", "/web.calculoview"})
public final  class calculoview extends GXWebObjectStub
{
   public calculoview( )
   {
   }

   public calculoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( calculoview.class ));
   }

   public calculoview( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new calculoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new calculoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Calculo View";
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

