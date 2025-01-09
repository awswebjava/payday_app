package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.artww", "/web.artww"})
public final  class artww extends GXWebObjectStub
{
   public artww( )
   {
   }

   public artww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( artww.class ));
   }

   public artww( int remoteHandle ,
                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new artww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new artww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " ART";
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

