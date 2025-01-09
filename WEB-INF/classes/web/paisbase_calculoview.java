package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paisbase_calculoview", "/web.paisbase_calculoview"})
public final  class paisbase_calculoview extends GXWebObjectStub
{
   public paisbase_calculoview( )
   {
   }

   public paisbase_calculoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisbase_calculoview.class ));
   }

   public paisbase_calculoview( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisbase_calculoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisbase_calculoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Paisbase_calculo View";
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

